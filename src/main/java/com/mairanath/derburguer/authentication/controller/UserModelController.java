package com.mairanath.derburguer.authentication.controller;

import com.mairanath.derburguer.authentication.service.UserDetailsServiceImpl;
import com.mairanath.derburguer.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class UserModelController {

    @Autowired
    UserDetailsServiceImpl service;

   // @Autowired
   // private AuthenticationManager authenticationManager;



    @RequestMapping(value = "/criar_usuario", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO> criarUsuario (@RequestBody @Validated UserDTO user){
        return ResponseEntity.status(201).body(service.criarUsuario(user));
    }

}
