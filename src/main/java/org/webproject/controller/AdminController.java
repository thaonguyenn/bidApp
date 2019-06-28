package org.webproject.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webproject.model.BidSessions;
import org.webproject.model.Customer;
import org.webproject.model.Product;
import org.webproject.service.BidSessionsService;
import org.webproject.service.CustomerService;
import org.webproject.service.ProductService;

@Controller
public class AdminController {
	@Autowired
	CustomerService serviceCustomer;
	@Autowired
	ProductService productService;
	@Autowired
	BidSessionsService bidSessionsService;

	@RequestMapping(value = { "/admin/listCustomer" }, method = RequestMethod.GET)
	public String listCustomer(ModelMap model) {

		List<Customer> customer = serviceCustomer.findAllCus();
		System.out.println(customer.size());
		model.addAttribute("customers", customer);
		model.addAttribute("total", serviceCustomer.getTotalCustomer());
		return "listCustomer";

	}

	@RequestMapping(value = {
			"/admin/findDetail/{idCus}" }, method = RequestMethod.GET, produces = "plan/text;charset=utf-8")
	@ResponseBody
	public void findCustomerById(@PathVariable("idCus") String idCus, HttpServletResponse response) throws IOException {
		Customer customer = serviceCustomer.findCustomerById(idCus);
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		StringBuilder sb = new StringBuilder();
		sb.append("<fullName>" + customer.getFullName() + "</fullName>");
		sb.append("<phoneNumber>" + customer.getPhoneNumber() + "</phoneNumber>");
		sb.append("<address>" + customer.getAddress() + "</address>");
		response.getWriter().write("<Customer>" + sb.toString() + "</Customer>");
	}

	@RequestMapping(value = { "/admin/approveProduct" }, method = RequestMethod.GET)
	public String approveProduct(ModelMap model) {
		List<Product> approve = productService.getListByStatus(1);
		System.out.println("aaaa" + approve.size());
		model.addAttribute("approve", approve);
		return "approveProduct";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = { "/admin/approveProduct" }, method = RequestMethod.POST)
	public String approvedProduct(ModelMap model, @RequestParam("approve") String idProduct) {
		productService.updateProduct(2, idProduct);
		Product product = productService.getDetailProduct(idProduct);
		BidSessions sess = new BidSessions();
		// set product
		sess.setProduct(product);
		// set time
		Date date = new Date();
		long time = date.getTime();
		//long m = 6 * 60 * 60 * 1000;// after 6 hours
		long m = 3 * 60 * 1000;// after 3 minutes
		Date dateAfter = new Date(time + m);
		if (dateAfter.getHours() >= 22 && dateAfter.getMinutes() > 0 || dateAfter.getHours() <= 7) {
			dateAfter.setHours(8);
		}
		sess.setBidTime(dateAfter);
		bidSessionsService.createSession(sess);
		List<Product> approve = productService.getListByStatus(1);
		model.addAttribute("approve", approve);
		return "approveProduct";
	}

	@RequestMapping(value = { "/admin/productApproved" }, method = RequestMethod.GET)
	public String productApproved(ModelMap model) {
		List<Product> approved = productService.getListByStatus(2);
		model.addAttribute("approve", approved);
		List<Product> pending = productService.getListByStatus(3);
		model.addAttribute("pending", pending);
		return "productApproved";
	}

	@RequestMapping(value = { "/admin/bidSuccessProduct" }, method = RequestMethod.GET)
	public String bidSuccessProduct(ModelMap model) {
		List<Product> bidSuccess = productService.getListByStatus(4);
		model.addAttribute("bidSuccess", bidSuccess);

		return "bidSuccessProduct";
	}

	@RequestMapping(value = {
			"/admin/findDetailProduct/{idProduct}" }, method = RequestMethod.GET, produces = "plan/text;charset=utf-8")
	@ResponseBody
	public void findProductById(@PathVariable("idProduct") String idProduct, HttpServletResponse response)
			throws IOException {
		Product product = productService.getDetailProduct(idProduct);
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		StringBuilder sb = new StringBuilder();
		sb.append("<nameProduct>" + product.getNameProduct() + "</nameProduct>");
		sb.append("<description>" + product.getDescription() + "</description>");
		sb.append("<price>" + product.getPrice() + "</price>");
		sb.append("<createDay>" + product.getCreateDay() + "</createDay>");
		response.getWriter().write("<Product>" + sb.toString() + "</Product>");
	}

}