package br.edu.dac.karlos.projetojpa2.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.dac.karlos.projetojpa2.model.entity.Product;

@Repository
public interface ProductDAO extends PagingAndSortingRepository<Product, Integer>{

}
