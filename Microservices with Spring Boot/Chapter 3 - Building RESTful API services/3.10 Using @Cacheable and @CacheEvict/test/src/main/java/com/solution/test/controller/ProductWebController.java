package com.solution.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.solution.test.model.Product;

@Controller
public class ProductWebController {

	@Autowired
	ProductController productController;
	
	//READ Operation
	@GetMapping("/")
	public String getAllProducts(Model model) {
		List<Product> productsList = productController.getAllProducts();
		model.addAttribute("products",productsList);
		return "list_products";
	}
	
	//CREATE Operation
	@GetMapping("/new_product")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}	
	@PostMapping(value="/save_new")
	public String saveNewProduct(@ModelAttribute("product") Product product) {
		productController.addProduct(product);
		return "redirect:/";
	}
	
	//UPDATE Operation
	@GetMapping("/update_product/{pid}")
	public String editForm(@PathVariable(name="pId") Long id, Model model) {
		model.addAttribute("product",productController.getProduct(id));
		return "update_product";
	}
	@PostMapping(value="/save_product")
	public  String saveupdateProduct(@ModelAttribute("product") Product product) {
		productController.updateProduct(product,  product.getId());
		return "redirect:/";
	}
	
	//DELETE Operation
	@GetMapping("/delete_product/{pId}")
	public String deleteProduct(@PathVariable(name="pId") Long id, Model model) {
		model.addAttribute("product", productController.getProduct(id));
		return "delete_product";
	}
	@PostMapping("save_delete")
	public String saveDeleteProduct(@ModelAttribute("product") Product product) {
		productController.deleteProduct(product.getId());
		return "redirect:/";
	}
	
}
