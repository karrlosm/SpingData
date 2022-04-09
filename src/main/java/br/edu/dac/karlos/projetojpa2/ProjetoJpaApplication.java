package br.edu.dac.karlos.projetojpa2;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.dac.karlos.projetojpa2.controller.OwnerController;
import br.edu.dac.karlos.projetojpa2.controller.ProductController;
import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.entity.Product;

@SpringBootApplication
public class ProjetoJpaApplication implements CommandLineRunner {

	@Autowired
	private OwnerController ownerController;
	
	@Autowired
	private ProductController productController;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		boolean stop = false;
		while(stop == false) {
			System.out.println("BEM VINDO(A) AO NOSSO SISTEMA \n"
					+ "RESPONDA AO MENU ABAIXO COM A NUMERAÇÃO CORRESPONDENTE A CADA TÓPICO.");
			System.out.print("1 - INSERIR OWNER \n "
					+ "2 - LISTAR TODOS OS OWNERS \n"
					+ "3 - INSERIR/ATUALIZAR DADOS \n "
					+ "4 - EXIBIR TODOS OS PRODUTOS \n "
					+ "5 - EXIBIR PRODUTOS DE ACORDO COM OS OWNERS \n"
					+ "~~QUALQUER OUTRO NÚMERO PARA SAIR~~ \n");
			int choose = Integer.parseInt(input.nextLine());
			switch (choose) {
				case 1: {
					System.out.print("CPF: ");
					String cpf = input.nextLine();
					System.out.print("NOME: ");
					String name = input.nextLine();
					System.out.print("IDADE: ");
					int age = Integer.parseInt(input.nextLine());
					ownerController.createOwner(cpf, name, age);
					break;
				}
				case 2:{
					List<Owner> owners = ownerController.list();
					for (Owner owner: owners) {
						System.out.println(owner.toString());
					}
					break;
				}
				case 3:{
					System.out.print("CPF DO OWNER CORRESPONDENTE:");
					String cpf = input.nextLine();
					ownerController.update(cpf);
					break;
				}
				case 4:{
					List<Product> products = productController.list();
					for (Product product: products) {
						System.out.println(product.toString());
					}
					break;
				}
				case 5:{
					List<Product> products = productController.listByOwner(choose);
					for (Product product: products) {
						System.out.println(product.toString());
					}
					break;
				}
				default : {
					stop = true;
					break;
				}
			}
		}
	}
}
