package br.com.paulocollares.service;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paulocollares.model.Produto;
import br.com.paulocollares.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		 this.produtoRepository = produtoRepository;
	}
	
	@Transactional
	public Produto criar(Produto produto) {
		
		return produto = produtoRepository.save(produto);

	}

}
