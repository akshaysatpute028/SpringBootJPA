package com.cdac.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdac.springbootjpa.model.Product;
import com.cdac.springbootjpa.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired(required = true)
	private ProductService productService;
	
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	@GetMapping("/add")
	public String getAddPage() {
		return "addproductform";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute Product product) {
		Product newproduct=productService.save(product);
		return "redirect:/fetchall";
	}
	
	@GetMapping("/fetchall")
	public String getProductsPage(Model m) {
		Iterable<Product> product=productService.findAll();
		m.addAttribute("productlist",product);
		return "allproducts";
	}
	
	@GetMapping("/select")
	public String getSearchPage() {
		return "searchproduct";
	}
	
	@GetMapping("/contact")
	public String getContactPage() {
		return "contact";
	}
	
}
