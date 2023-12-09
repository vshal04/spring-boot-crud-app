package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;


@Service("productservice")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String addProduct(Product product) throws Exception {
		String result = null;
		if (product.getName() != null || product.getDescription() != null || product.getPrice() != 0) {
			productRepository.save(product);
			result = "product added";
			return result;
		}
		throw new Exception("Please fill the mandatory field");
	}

	@Override
	public List<Product> viewProduct() {
		List<Product> productList = productRepository.findAll();
		if(!productList.isEmpty()) {
			return productList;
		}
		return productList;
	}

	@Override
	public Product viewProductByID(int productId) throws Exception {
		Product result = null;
		
		 if(productRepository.existsById(productId)) {
			 result = productRepository.findById(productId).get();
			 return result;
		 }
		 throw new Exception("No product with this Id found");
	}

	@Override
	public boolean updateProductById(int productId) {
		return false;
	}

	@Override
	public boolean deleteProductById(int productId) throws Exception{
		if(productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			return true;
		}
		throw new Exception("No product with this Id found to delete");
	}

}
