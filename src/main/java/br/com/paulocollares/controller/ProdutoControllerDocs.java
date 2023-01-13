package br.com.paulocollares.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.paulocollares.dto.ProdutoDTO;
import br.com.paulocollares.model.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("API REST Produtos")
public interface ProdutoControllerDocs {
	
	@ApiOperation(value = "Operação de criação do Produto")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Produto criado com sucesso"),
		@ApiResponse(code = 400, message = "Faltam campos obrigatórios, valor de intervalo de campo errado ou produto já cadastrado no sistema."),
	})
	Produto criar(Produto produto);
	
	@ApiOperation(value = "Localizar produto por operação de ID")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Sucesso produto encontrado"),
		@ApiResponse(code = 404, message = "Código de erro produto não encontrado"),
	})
	  Optional<Produto>listar(Integer id);
	
	@ApiOperation(value = "Lista todos os registros dos produtos")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Retorna todos os registros dos produtos"),
	 
	})
	  List<Produto> listar();
	
	@ApiOperation(value = "Excluir produto por operação de id")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Sucesso produto deletado"),
			@ApiResponse(code = 404, message = "Código de erro produto não encontrado"),
		})
	     ResponseEntity<Produto> deletar(Integer id);
	
	@ApiOperation(value = "Atualizar produto por operação de ID")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Sucesso produto atualizado"),
		@ApiResponse(code = 404, message = "Código de erro produto não encontrado"),
	})
	  ResponseEntity<Produto> atualizar(Integer id, ProdutoDTO produtoDTO );

}
