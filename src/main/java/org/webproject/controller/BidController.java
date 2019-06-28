package org.webproject.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.webproject.model.Account;
import org.webproject.model.BidSessions;
import org.webproject.model.Customer;
import org.webproject.model.ImageProduct;
import org.webproject.model.Product;
import org.webproject.model.SessionItems;
import org.webproject.service.BidSessionsService;
import org.webproject.service.CustomerService;
import org.webproject.service.ImageProductService;
import org.webproject.service.ProductService;
import org.webproject.service.RunningClock;
import org.webproject.service.SessionItemsService;
 

@Controller
@SessionAttributes("account")
public class BidController {
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	RunningClock clock;
	@Autowired
	BidSessionsService bidSessionService;
	@Autowired
	ProductService productService;
	@Autowired
	SessionItemsService itemService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ImageProductService imageService;
	@Autowired
	SessionItemsService sessionItemsService;
	
    @RequestMapping("/")
    public String auctionfloor(Model model) {
    	taskExecutor.execute(clock);
    	List<Product> productDone = productService.listTopProductWithStatus(4, 4);
    	model.addAttribute("productDone", productDone);
    	List<BidSessions> sessions = bidSessionService.getListReadySession();
    	model.addAttribute("sessions", sessions.subList(0, 4));
        return "Home";
        
    }
    @RequestMapping(value = { "/customer/detailProduct" }, method = RequestMethod.GET)
    public String loadDetailProduct(Model model,@ModelAttribute(value = "account") Account acc, @RequestParam("idSession") String idSession, @RequestParam("idProduct") String idProduct) {
    	//get detail product
    	Product product = productService.getDetailProduct(idProduct);
    	model.addAttribute("product", product);
    	//get all image
    	
    	//set time
    	BidSessions bidSession = bidSessionService.getDetailBidSession(idSession);
    	int status = bidSession.getPresentStatus();
    	if (status == 2) {
    		long diff = bidSession.getBidTime().getTime() - new Date().getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffSeconds = diff / 1000 % 60;
			model.addAttribute("biddingTime", diffMinutes + ":" +diffSeconds);
    	} else if (status == 3) {
    		model.addAttribute("biddingTime", 00 + ":" + 00 + ":" + bidSession.getCountdown());
    	}
    	model.addAttribute("idSession", idSession);
    	model.addAttribute("idProduct", idProduct);
    	model.addAttribute("acc", acc);
    	//get bid items
//    	List<SessionItems> items = itemService.getItemsByIdSession(idSession);
//    	model.addAttribute("items",items);
    	
    	return "AuctionFloor";
    }
    @RequestMapping("/loadListReadySession")
    public void loadListReadySession(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<BidSessions> listReadySessions = bidSessionService.getListReadySession();
    	List<String> ids = new ArrayList<String>();
    	for (BidSessions bidSession : listReadySessions) {
			ids.add(bidSession.getProduct().getIdProduct());
		}
    	List<Product> listProduct = productService.getListProductByListID(ids);
    	response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        int i = 0;
        String im = "";
        StringBuffer sb = new StringBuffer();
        for (Product product : listProduct) {
        	im = product.getListImages().iterator().next().getNameImage();
        	long diff = listReadySessions.get(i).getBidTime().getTime() - new Date().getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffSeconds = diff / 1000 % 60;
        	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        	sb.append("<product>");
        	sb.append("<idProduct>"+product.getIdProduct()+"</idProduct>");
        	sb.append("<nameProduct>"+product.getNameProduct()+"</nameProduct>");
        	sb.append("<description>"+product.getDescription()+"</description>");
        	sb.append("<img>"+im+"</img>");
        	sb.append("<timeBinding>"+dateFormat.format(listReadySessions.get(i).getBidTime())+"</timeBinding>");
        	sb.append("<timeNow>"+diffMinutes+":"+diffSeconds+"</timeNow>");
        	sb.append("</product>");
        	if(diffMinutes == 0 && diffSeconds == 0) {
        		bidSessionService.updateStatus(listReadySessions.get(i).getSessionID(), 3);
        	}
        	i++;
        }
        response.getWriter().write("<products>" + sb.toString() + "</products>");
    }
    
    @RequestMapping("/loadListOpeningSession")
    public void loadListOpeningSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<BidSessions> listOpeningSessions = bidSessionService.getListOpeningSession();
    	List<String> ids = new ArrayList<String>();
    	for (BidSessions bidSession : listOpeningSessions) {
    		ids.add(bidSession.getProduct().getIdProduct());
    	}
    	List<Product> listProduct = productService.getListProductByListID(ids);
    	response.setContentType("text/xml");
    	response.setHeader("Cache-Control", "no-cache");
    	StringBuffer sb = new StringBuffer();
    	String im = "";
    	for (Product product : listProduct) {
    		im = product.getListImages().iterator().next().getNameImage();
    		sb.append("<product>");
    		sb.append("<idProduct>"+product.getIdProduct()+"</idProduct>");
    		sb.append("<nameProduct>"+product.getNameProduct()+"</nameProduct>");
    		sb.append("<description>"+product.getDescription()+"</description>");
    		sb.append("<img>"+im+"</img>");
    		sb.append("<countdown>"+10+"</countdown>");
    		sb.append("</product>");
    	}
    	response.getWriter().write("<products>" + sb.toString() + "</products>");
    }
    
    @RequestMapping("/loadItemSession")
    public void loadItemSession(@RequestParam("idSession") String idSession, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<SessionItems> items = itemService.getItemsByIdSession(idSession);
    	response.setContentType("text/xml");
    	response.setHeader("Cache-Control", "no-cache");
    	StringBuffer sb = new StringBuffer();
    	for (SessionItems item : items) {
    		sb.append("<item>");
    		sb.append("<price>"+item.getPrice()+"</price>");
    		sb.append("<customer>"+item.getCustomer().getIdCus()+"</customer>");
    		sb.append("<email>"+item.getCustomer().getAccount().getEmail()+"</email>");
    		sb.append("<time>"+item.getItemTime()+"</time>");
    		sb.append("</item>");
    	}
    	response.getWriter().write("<items>" + sb.toString() + "</items>");
    }
 
    @RequestMapping("/loadBidingTime")
    public void loadBidingTime(HttpServletRequest request, HttpServletResponse response, @RequestParam("idSession") String idSession, @RequestParam("idProduct") String idProduct) throws IOException {
    	BidSessions bidSession = bidSessionService.getBidSessionByIdSessionIdProduct(idSession, idProduct);
    	response.setContentType("text/xml");
    	response.setHeader("Cache-Control", "no-cache");
    	int status = bidSession.getPresentStatus();
    	if (status == 2) {
    		long diff = bidSession.getBidTime().getTime() - new Date().getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffSeconds = diff / 1000 % 60;
			response.getWriter().write("<bidingTime>" + diffMinutes + ":" +diffSeconds + "</bidingTime>");
    	} else if (status == 3) {
    		if ((bidSession.getCountdown() -1 ) < 0) {
    			response.getWriter().write("<bidingTime>Finished</bidingTime>");
    		} else {
    		//reduce countdown
    		bidSessionService.updateCountdown(bidSession.getCountdown() - 1,idSession);
			response.getWriter().write("<bidingTime>" + 00 + ":" + 00 + ":" + bidSession.getCountdown() + "</bidingTime>");
    	}
    	}
    }
    @RequestMapping("/bid")
    public void saveItemSession(Model model, @RequestParam("idSession") String idSession, @RequestParam("idCustomer") String idCustomer, @RequestParam("money") double money) {
    	bidSessionService.establishCountdown(idSession);
    	BidSessions session = bidSessionService.getDetailBidSession(idSession);
    	Customer customer = customerService.getCustomerById(idCustomer);
    	itemService.addItem(session, customer, money);
    }
    @RequestMapping("/checkValidPrice")
    public void checkValidPrice(HttpServletResponse response, Model model, @RequestParam("idSession") String idSession,  @RequestParam("priceB") String priceB) throws IOException { 	
    	List<SessionItems> list = new ArrayList<SessionItems>();
		List<SessionItems> sessionItem = sessionItemsService.getSessionItem();	 
		for (int i = 0; i < sessionItem.size(); i++) {
			if(sessionItem.get(i).getBidsessions().getSessionID().equals(idSession)) {
				list.add(sessionItem.get(i));				
			}			
		}
		SessionItems se = list.get(list.size()-1);
		if(Double.parseDouble(priceB) <= se.getPrice()) {
			response.getWriter().write("<valid>false</valid>");
		} else {
			response.getWriter().write("<valid>true</valid>");
		}
    }
}
