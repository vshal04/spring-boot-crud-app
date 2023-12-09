package com.example.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.example.model.Product;

public interface ProductService {
	
	public String addProduct(Product product) throws Exception;
	
	public List<Product> viewProduct();
	
	public Product viewProductByID(int productId) throws Exception;
	
	public boolean updateProductById(int productId);
	
	public boolean deleteProductById(int productId) throws Exception;

}
