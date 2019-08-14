package com.produtos.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findById(Long id);
	
}
