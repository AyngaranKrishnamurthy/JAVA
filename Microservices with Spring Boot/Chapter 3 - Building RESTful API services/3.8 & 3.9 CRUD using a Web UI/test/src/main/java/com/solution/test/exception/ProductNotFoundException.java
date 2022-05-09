package com.solution.test.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID=1L;
	
	public ProductNotFoundException(Long id) {
		super("The product with Id:"+id+" cannot be found");
	}
}
