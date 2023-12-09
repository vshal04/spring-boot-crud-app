package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(path = "Product")
public class ProductController {

	@Autowired
	@Qualifier("productservice")
	private ProductService productService;

	@PostMapping(path = "/addProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product products) throws Exception {
		ResponseEntity<String> response = null;
		String result = productService.addProduct(products);
		if (result != null)
			response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;

	}

	@GetMapping(path = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		ResponseEntity<List<Product>> response = null;
		List<Product> list = productService.viewProduct();
		if (list != null)
			response = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		return response;
	}

	@GetMapping(path = "/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) throws Exception {
		ResponseEntity<Product> response = null;
		Product product = productService.viewProductByID(productId);
		if (product != null)
			response = new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}

	// updateProductById pending

	@DeleteMapping(path = "/deleteproductById/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") int productId) throws Exception {
		ResponseEntity<String> response = null;
		if (productService.deleteProductById(productId))
			response = new ResponseEntity<String>("Product with the given id is deleted", HttpStatus.OK);
		return response;

	}

}
