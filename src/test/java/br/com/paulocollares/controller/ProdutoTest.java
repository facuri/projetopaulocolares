package br.com.paulocollares.controller;

 
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.paulocollares.model.Produto;
import br.com.paulocollares.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
	
		ProdutoController.class
	})
public class ProdutoTest {
	
	//URL base para acesso desse controlador
	private final String BASE_URL = "/produtos";
	
	//Instância do ObjectMapper para trabalhar com JSON
	private ObjectMapper objectMapper;
	
	//Controlador REST tratado por meio de injeção de dependências
	@Autowired
	private ProdutoController restController;
	
	//Instância do MockMVC
	private MockMvc mockMvc;
	
	//Instância do mock repository
	@MockBean
	private ProdutoRepository mockRepository;
	
	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders
				  .standaloneSetup(restController)
				  .build();
	}
	
	@Test
	public void buscar_id_200() throws Exception{
		
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Teste");
		produto.setValor(10.0);
		
		 when(mockRepository.findById(1))
		                   .thenReturn(Optional.of(produto));
		
		           mockMvc.perform(get(BASE_URL + "/1"))
		           .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		           .andExpect(status().isOk()) 
		           .andExpect(jsonPath("$.id", is(1)))
		           .andExpect(jsonPath("$.nome", is("Teste")))
		           .andExpect(jsonPath("$.valor", is("10.0")));
		    
		    verify(mockRepository, times(1)).findById(1);
		            
		    
		
	}
	

}
