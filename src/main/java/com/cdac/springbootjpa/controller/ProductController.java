package com.cdac.springbootjpa.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable(value = "id") int p_id,@ModelAttribute Product product,Model m) {
		product=productService.findById(p_id);
		m.addAttribute("product",product);
		return "editproductform";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") int p_id,Model m) {
		productService.deleteById(p_id);
		return "redirect:/fetchall";
	}
	
	@PostMapping("/getproduct")
	public String searchProduct(Model m,HttpServletRequest req) {
		String id=req.getParameter("p_id");
		if(id=="") {
			String stat="<div class=\"alert alert-danger\">\r\n"
					+ "    <strong>Error !</strong> Field is empty .\r\n"
					+ "  </div>";
			m.addAttribute("status",stat);
			return "searchproduct";
		}
		else {
			int p_id=Integer.parseInt(id);
			try {
				Product product= productService.findById(p_id);
				if(product.getP_id()==p_id) {
					m.addAttribute("product",product);
					return "viewsearchproduct";
				}
			}catch(NoSuchElementException e){
				String stat="<div class=\"alert alert-danger\">\r\n"
						+ "    <strong>No Content found !</strong> User does not exist.\r\n"
						+ "  </div>";
				m.addAttribute("status",stat);
				return "searchproduct";
			}
		}
		return "searchproduct";
	}
	
}
