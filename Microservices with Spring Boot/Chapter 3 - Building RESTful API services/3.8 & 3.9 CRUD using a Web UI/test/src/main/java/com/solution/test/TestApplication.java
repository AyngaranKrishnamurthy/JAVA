package com.solution.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.solution.test.model.Product;
import com.solution.test.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@EnableCaching
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		productRepository.save(new Product("Television","Electronics"));
		productRepository.save(new Product("Radio","Electronics"));
		productRepository.save(new Product("Pen","Stationery"));
		productRepository.save(new Product("Book","Stationery"));
		productRepository.save(new Product("Shirt","Fabric"));
	}

}
