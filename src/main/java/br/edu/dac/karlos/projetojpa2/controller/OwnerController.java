package br.edu.dac.karlos.projetojpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;
import br.edu.dac.karlos.projetojpa2.model.service.OwnerService;

@Controller
public class OwnerController {
	@Autowired
	private OwnerService ownerService;
	
	public void createOwner(String cpf, String name, int age) {
		Owner owner = new Owner();
		owner.setCpf(cpf);
		owner.setName(name);
		owner.setAge(age);
		ownerService.create(owner);
	}
	
	public List<Owner >list(){
		return ownerService.readAll();
	}
	
	public void update(String cpf) {
		ownerService.update(cpf);
	}
	
	public void deletar(String cpf) {
		ownerService.delete(cpf);
	}
}
