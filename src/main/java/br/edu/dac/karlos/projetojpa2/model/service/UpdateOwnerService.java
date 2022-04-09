package br.edu.dac.karlos.projetojpa2.model.service;



import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.controller.ProductController;
import br.edu.dac.karlos.projetojpa2.model.dao.OwnerDAO;
import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;

@Service
public class UpdateOwnerService {
	
	@Autowired
	private OwnerDAO ownerDAO;
	
	@Autowired
	private ProductController productController;
	
	private Scanner input = new Scanner(System.in);

	public void updateOwner(Owner owner) {
		System.out.println("INFORME O QUE DESEJA ALTERAR ABAIXO: \n"
				+ "1 - ATUALIZAR NOME \n"
				+ "2 - ATUALIZAR IDADE \n"
				+ "3 - INSERIR PRODUTO \n"
				+ "4 - ATUALIZAR PRODUTO \n"
				+ "5 - DETETAR PRODUTO \n"
				+ "6 - DELETAR OWNER \n"
				+ "~~QUALQUER OUTRO NÚMERO PARA SAIR~~)");
		int opcao = Integer.parseInt(input.nextLine());
		switch (opcao) {
			case 1: {
				System.out.print("INSIRA O NOVO NOME: ");
				String name = input.nextLine();
				owner.setName(name);
				ownerDAO.save(owner);
				break;
			}
			case 2:{
				System.out.print("INSIRA A NOVA IDADE: ");
				int idade = Integer.parseInt(input.nextLine());
				owner.setAge(idade);
				ownerDAO.save(owner);
				break;
			}
			case 3:{
				Product product = new Product();
				System.out.print("CÓDIGO DO PRODUTO: ");
				int code = Integer.parseInt(input.nextLine());
				System.out.print("NOME DO PRODUTO: ");
				String name = input.nextLine();
				System.out.print("QUANTIDADE DESSE PRODUTO: ");
				int quantity = Integer.parseInt(input.nextLine());
				product.setId(code);
				product.setName(name);
				product.setQuantity(quantity);
				List<Product> products = owner.getProducts();
				products.add(product);
				ownerDAO.save(owner);
				break;
			}
			case 4:{
				System.out.print("CÓDIGO DO PRODUTO A ATUALIZAR: ");
				int code = Integer.parseInt(input.nextLine());
				productController.update(code);
				break;
			}
			case 5:{
				System.out.print("CÓDIGO DO PRODUTO A DELETAR: ");
				int code = Integer.parseInt(input.nextLine());
				productController.delete(code);
				break;
			}
			case 6:{
				ownerDAO.deleteById(owner.getCpf());
				System.out.print("OWNER REMOVIDO \n");
				break;
			}
		}
	}
	
}
