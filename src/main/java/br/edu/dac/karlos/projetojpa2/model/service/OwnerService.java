package br.edu.dac.karlos.projetojpa2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.dac.karlos.projetojpa2.model.dao.OwnerDAO;
import br.edu.dac.karlos.projetojpa2.model.entity.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerDAO ownerDAO;
	
	@Autowired
	private UpdateOwnerService updateOwnerService;
	
	public void create(Owner owner) {
		ownerDAO.save(owner);
	}
	
	public Owner read(String cpf) {
		return ownerDAO.findById(cpf).orElse(null);
	}
	
	public List<Owner> readAll(){
		return (List<Owner>) ownerDAO.findAll();
	}
	
	public void update(String cpf) {
		updateOwnerService.updateOwner(ownerDAO.findById(cpf).orElse(null));
	}
	
	public void delete(String cpf) {
		ownerDAO.deleteById(cpf);
	}
	
}
