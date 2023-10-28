package com.mairanath.derburguer.repository;

import com.mairanath.derburguer.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findByRazaoSocialContainsIgnoreCase(String razaoSocial);
}
