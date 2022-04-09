package br.edu.dac.karlos.projetojpa2.model.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.model.dao.ProductDAO;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;

@Service
public class ProductUpdateService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public void updateProduct(Product product) {
		Scanner input =  new Scanner(System.in);
		System.out.println("O QUE VOCÊ DESEJA ALTERAR => \n"+ 
				"1 - NOME \n"+
				"2 - QUANTIDADE \n");
		int choose = Integer.parseInt(input.nextLine());
		switch (choose) {
			case 1 : {
				System.out.print("Insira o novo nome: ");
				String name = input.nextLine(); 
				product.setName(name);
				break;
			}
			case 2 : {
				System.out.print("Insira a nova quantidade: ");
				int quantity = Integer.parseInt(input.nextLine()); 
				if (quantity == 0) {
					productDAO.deleteById(product.getId());
					System.out.println("PRODUTO REMOVIDO");
				} else {
					product.setQuantity(quantity);					
				}
				break;
			}
		}
		productDAO.save(product);
	}
}
