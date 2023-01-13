package br.com.paulocollares.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table(name = "produto")
public class Produto {
	
	@Id
	//@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	 
	 @NotBlank
	 @Size(max= 60)
	@Column(name = "nome", nullable = false)
	private String nome;
	
	//@NotBlank
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	 
	
	

}
