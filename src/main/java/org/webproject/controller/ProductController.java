package org.webproject.controller;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import org.webproject.model.Product;
import org.webproject.service.BidSessionsService;
import org.webproject.service.CustomerService;
import org.webproject.service.ImageProductService;
import org.webproject.service.ProductService;


@Controller
@SessionAttributes("account")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ImageProductService imageService;
	@Autowired
	BidSessionsService bidSessionService;

	@RequestMapping(value = { "/customer/addProduct" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "uploadProduct";
	}
	
	@RequestMapping(value = { "/customer/listBiddedProduct" }, method = RequestMethod.GET)
	public String listBiddedProduct(ModelMap model) {
		List<Product> productDone = productService.listTopProductWithStatus(4, 8);
    	model.addAttribute("productDone", productDone);
		return "listProductFinish";
	}
	
	@RequestMapping(value = { "/customer/listBiddingProduct" }, method = RequestMethod.GET)
	public String listBiddingProduct(ModelMap model) {
		List<BidSessions> sessions = bidSessionService.getListReadySession();
    	model.addAttribute("sessions", sessions);
		return "listProductReady";
	}
	@RequestMapping(value = { "/customer/addProduct" }, method = RequestMethod.POST)
	public String addProductA(@RequestParam("uploadedImage") byte[] uploadedImage, @ModelAttribute(value = "account") Account acc, HttpServletResponse response,HttpServletRequest resquest,Product product, BindingResult result, ModelMap model,@RequestParam("idProduct") String idProduct) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=UTF-8");
		resquest.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Customer owner = customerService.getCustomerById(acc.getIdCus());
		product.setOwner(owner);
		productService.addProduct(product);
		
		//set images
		String tmp = new String(uploadedImage);
	    imageService.addImageForStudent(tmp, uploadedImage, product);
	 
		return "redirect:/customer/listUserOwner";
	}
	
	@RequestMapping(value = { "/customer/listUserOwner" }, method = RequestMethod.GET)
	public String getProduct(ModelMap model,@ModelAttribute(value = "account") Account acc) {
		System.out.println("nnnnnn"+acc.getIdCus());
		System.out.println("nnnnnn"+acc.getEmail());
		List<Product> listProduct = productService.getOwnerProduct(acc.getIdCus());
		System.out.println(listProduct.size());
		model.addAttribute("listProducts", listProduct);
		List<Product> list = productService.getBuyerProduct(acc.getIdCus());
		System.out.println(list.size());
		model.addAttribute("lists", list);
		return "listUser";
	}

}
