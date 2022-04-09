package br.edu.dac.karlos.projetojpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.dac.karlos.projetojpa2.model.entity.Product;
import br.edu.dac.karlos.projetojpa2.model.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public Product newProduct(int code, String name, int quantity) {
		Product product = new Product();
		product.setId(code);
		product.setName(name);
		product.setQuantity(quantity);
		productService.create(product);
		return product;
	}
	
	public List<Product>list(){
		return productService.readAll();
	}
	
	public List<Product>listByOwner(int code){
		return productService.readAll();
	}
	
	public void update(int code) {
		productService.update(code);
	}
	
	public void delete(int id) {
		productService.delete(id);
	}

}
