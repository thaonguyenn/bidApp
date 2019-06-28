package org.webproject.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.webproject.model.Account;
import org.webproject.model.Customer;
import org.webproject.model.Orders;
import org.webproject.model.Product;
import org.webproject.model.SessionItems;
import org.webproject.service.AccountService;
import org.webproject.service.CustomerService;
import org.webproject.service.OrdersService;
import org.webproject.service.ProductService;
import org.webproject.service.SessionItemsService;


@Controller
public class CheckOutController {
	@Autowired
	AccountService serviceAccount;
	@Autowired
	ProductService productService;
	@Autowired
	SessionItemsService sessionItemsService;
	@Autowired
	CustomerService serviceCustomer;
	@Autowired
	OrdersService serviceOrders;

	

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String newAccount(ModelMap model) {
		Account account = new Account();
		model.addAttribute("accountC", account);
		model.addAttribute("edit", false);
		return "Register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String saveAccount(Account accountC, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "Register";
		}		
		String id = serviceAccount.saveAccount(accountC);
		Customer customer = new Customer();
		customer.setIdCus(id);			
		serviceCustomer.saveCustomer(customer);
		return "redirect:/login";
	}

	@RequestMapping(value = { "/loginAdmin" }, method = RequestMethod.GET)
	public String loginAdmin(ModelMap model) {
		Account accountCus = new Account();
		model.addAttribute("accountAd", accountCus);
		return "LoginAdmin";
	}
	
	@RequestMapping(value = { "/loginAdmin" }, method = RequestMethod.POST)
	public String loginAdminValid(Account accountAd, HttpServletRequest request, ModelMap model) {
		boolean checkValid = serviceAccount.isValidAccount(accountAd.getEmail(), accountAd.getPassword());
		if (checkValid && accountAd.getPassword().equals("admin")) {
			HttpSession session = request.getSession();
			session.invalidate();
			session = request.getSession(true);
			session.setAttribute("accountAd", accountAd);
		}
		return "redirect:/admin/listCustomer";
	}
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request) {
		Account accountCus = new Account();
		model.addAttribute("accountCus", accountCus);
		if(request.getParameter("error")!=null) {
			model.addAttribute("invalidError", "Your email and password don't match!");
		}
		return "Login";
	}
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginValid(Account accountCus, HttpServletRequest request, ModelMap model) {
		boolean checkValid = serviceAccount.isValidAccount(accountCus.getEmail(), accountCus.getPassword());
		if (checkValid) {
			accountCus = serviceAccount.setIdByEmailAndPass(accountCus);
			HttpSession session = request.getSession(true);
			session.setAttribute("account", accountCus);
			return "redirect:/";
		} else {
			
			return "redirect:/login?error=true";
		}
		
	}

	@RequestMapping(value = { "/customer/checkout" }, method = RequestMethod.GET)
	public String paymentBid(ModelMap model,@RequestParam("idProduct") String idProduct,@RequestParam("idCustomer") String idCustomer, @RequestParam("idSession") String idSession) {
		Product product = productService.getDetailProduct(idProduct);
		model.addAttribute("product", product);		
		Customer customer = serviceAccount.getCustomerByIdCus(idCustomer);
		String emailCus  = customer.getAccount().getEmail();
		model.addAttribute("emailCus", emailCus);	
		List<SessionItems> list = new ArrayList<SessionItems>();
		
		List<SessionItems> sessionItem = sessionItemsService.getSessionItem();	 
		System.out.println(sessionItem.get(0).getCustomer().getIdCus() + "  " + sessionItem.get(0).getBidsessions().getSessionID());
		System.out.println(idCustomer + " " + idSession);
		System.out.println(sessionItem.get(0).getBidsessions().getSessionID().equals(idSession));
		System.out.println(sessionItem.get(0).getCustomer().getIdCus().equals(idCustomer));
		for (int i = 0; i < sessionItem.size(); i++) {
			if(sessionItem.get(i).getBidsessions().getSessionID().equals(idSession)&&
			sessionItem.get(i).getCustomer().getIdCus().equals(idCustomer)) {
				list.add(sessionItem.get(i));
				System.out.println(sessionItem.get(i).getBidsessions().getSessionID());
				
			}			
		}
		System.out.println(sessionItem.size());
		model.addAttribute("sessionItem", list.get(list.size()-1));
		model.addAttribute("idCustomer", idCustomer);
		return "checkout";
	}


	@RequestMapping(value = { "/customer/checkout" }, method = RequestMethod.POST)
	public String saveCustomer(ModelMap model,@RequestParam("fullName") String fullName, @RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("total") String total,@RequestParam("payment") String payment,@RequestParam("feeShip") float feeShip,@RequestParam("idOrders") String idOrders,@RequestParam("idCus") String idCus) {
		System.out.println("nnnnn"+idCus);
		Customer customer = new Customer();
		Orders orders = new Orders();
		orders.setPayment(payment);
		orders.setFeeShip(feeShip);
		orders.setTotal(Double.parseDouble(total));
		orders.setCustomer(serviceAccount.getCustomerByIdCus(idCus));
		//String idCus = sessionItemsService.getIdCusBySessionItem(customer.getIdCus());
		serviceCustomer.updateCustomer(idCus, fullName, phoneNumber, address);		
		serviceOrders.saveOrders(orders);
		model.addAttribute("success", "Order is created successfully" );
		return "redirect:/";

	}

@RequestMapping(value = { "/checkEmailExist" }, method = RequestMethod.GET)
public void checkEmail(HttpServletRequest request, HttpServletResponse response,
		@RequestParam("email") String email) throws ServletException, IOException {
	// String targetId = request.getParameter("email");
	System.out.println(serviceAccount.checkEmailExist(email));
	if ((email != null) && !serviceAccount.checkEmailExist(email)) {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<valid>true</valid>");
	} else {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<valid>false</valid>");
	}
}
@RequestMapping(value = { "/calculateFee" }, method = RequestMethod.GET)
public void calculateFee(HttpServletRequest request, HttpServletResponse response,
		@RequestParam("id_location") String id_location) throws ServletException, IOException {
//		int km = new org.webproject.model.MainActivity(proccessStringAdd(id_location), "khu+phố+6+phường+Linh+Trung+quận+Thủ+Đức+tphcm").start();
//		int money = km * 3;
		int money = 2;
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<fee>"+money+"</fee>");
}
public String proccessStringAdd(String st) {
	String[] array = st.split(" ");
	String result = new String();
	for (String string : array) {
		result+=(string+"+");
		System.out.println(string);
	}
	return result;
}
}