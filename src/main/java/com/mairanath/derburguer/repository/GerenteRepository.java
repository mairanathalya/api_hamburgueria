package com.mairanath.derburguer.repository;

import com.mairanath.derburguer.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    List<Gerente> findByNomeContainsIgnoreCase(String nome);
}
