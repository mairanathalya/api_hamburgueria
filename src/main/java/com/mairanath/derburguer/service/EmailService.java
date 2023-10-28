package com.mairanath.derburguer.service;

import com.mairanath.derburguer.model.Email;
import com.mairanath.derburguer.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private EmailRepository repository;

    public Email salvar(Email email) {
        return repository.save(email);
    }

    public Optional<Email> buscarPorId(Long id){
        return repository.findById(id);
    }
}
