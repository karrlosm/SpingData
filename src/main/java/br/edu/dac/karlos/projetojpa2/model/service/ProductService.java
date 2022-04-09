package br.edu.dac.karlos.projetojpa2.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.model.dao.ProductDAO;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductUpdateService productUpdateService;

	public void create(Product product) {
		productDAO.save(product);
	}
	
	public Product read(int code) {
		return productDAO.findById(code).orElse(null);
	}
	
	public List<Product> readAll(){
		return (List<Product>) productDAO.findAll();
	}
	
	public List<Product> readByCode(){
		return (List<Product>) productDAO.findAll();
	}
	
	public void update(int code) {
		productUpdateService.updateProduct(productDAO.findById(code).orElse(null));
	}
	
	public void delete(int code) {
		Product product = productDAO.findById(code).orElse(null);
		if (product != null) {
			if (product.getQuantity() > 1) {
				int newQuantity = product.getQuantity();
				product.setQuantity(newQuantity - 1);
				productDAO.save(product);
			} else {
				productDAO.deleteById(code);
			}
		} else {
			System.out.println("PRODUTO INEXISTENTE NO SISTEMA");
		}	
	}
}
