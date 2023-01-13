package br.com.paulocollares.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	
    private String nome;
	private Double valor;

}
