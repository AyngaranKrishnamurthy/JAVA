package com.solution.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solution.test.model.Product;
import com.solution.test.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts(){		//Read all			
			return productService.getAllProducts();					
		}
	
	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable("pId") String id){	//Read based on Id given		
			return productService.getProduct(id);					
		}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) { //Created a product listing
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{pid}")
	public void updateProduct(@RequestBody Product product, @PathVariable("pid") String id) {
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{pId}")
	public void deleteProduct(@PathVariable("pId") String id) {
		productService.deleteProduct(id);
	}
}
