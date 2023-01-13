package br.com.paulocollares.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.paulocollares.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	  public Page<Produto> findAll(Pageable pageable);
	  
	  @Query("select p from Produto p "
			   + "where lower(nome) like %:busca% ")
	  
	  public Page<Produto> busca(@Param("busca") String busca, Pageable pageable);
}
