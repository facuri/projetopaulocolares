package br.com.paulocollares.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulocollares.dto.ProdutoDTO;
import br.com.paulocollares.model.Produto;
import br.com.paulocollares.repository.ProdutoRepository;
import br.com.paulocollares.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
//@CrossOrigin
public class ProdutoController implements ProdutoControllerDocs {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	private ProdutoService produtoService;
	
    @Autowired
    public ProdutoController(ProdutoService produtoService) {
		 this.produtoService = produtoService;
	}
    
	@GetMapping
	public List<Produto> listar() {

		return (List<Produto>) produtoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Produto> listar(@PathVariable Integer id) {

		// Optional<Produto> rastreador = produtoRepository.findById(id);
		return produtoRepository.findById(id);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criar(@Valid @RequestBody Produto produto) {
      return produtoService.criar(produto);
		 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> atualizar(@Valid @PathVariable Integer id, 
			                                 @RequestBody  ProdutoDTO produtoDTO ){
		
		  Optional<Produto> produtoAtual = produtoRepository.findById(id);
		  
		  Produto atualizado = new  Produto();
		  
		  if(!produtoAtual.isPresent()) {
			  
			  return ResponseEntity.notFound().build();
		  }
		   produtoAtual.get().setNome(produtoDTO.getNome());
		   produtoAtual.get().setValor(produtoDTO.getValor());
		   
		   atualizado = produtoRepository.save(produtoAtual.get());
		   
		   return new ResponseEntity<>(atualizado, HttpStatus.CREATED);
		
		 }
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Produto> deletar(@PathVariable Integer id){
		
		 Optional<Produto> produto = produtoRepository.findById(id);
		 
		 if(!produto.isPresent()) {
			  
			  return ResponseEntity.notFound().build();
		  }else {
			  produtoRepository.deleteById(id);
		  }
		 
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  
	}

}
