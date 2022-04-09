package br.edu.dac.karlos.projetojpa2.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.dac.karlos.projetojpa2.model.entity.Owner;

@Repository
public interface OwnerDAO extends PagingAndSortingRepository<Owner, String>{

}
