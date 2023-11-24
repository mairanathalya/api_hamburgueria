package com.mairanath.derburguer.repository;

import com.mairanath.derburguer.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainsIgnoreCase(String nome);

    List<Produto> findByCodigoDeBarrasContainsIgnoreCase(String codigoDeBarras);
}
