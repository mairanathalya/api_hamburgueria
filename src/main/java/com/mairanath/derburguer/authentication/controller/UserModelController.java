package com.mairanath.derburguer.authentication.controller;

import com.mairanath.derburguer.authentication.model.UserModel;
import com.mairanath.derburguer.authentication.repository.UserRepository;
import com.mairanath.derburguer.authentication.service.TokenService;
import com.mairanath.derburguer.authentication.service.UserDetailsServiceImpl;
import com.mairanath.derburguer.dto.TokenDto;
import com.mairanath.derburguer.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class UserModelController {

    @Autowired
    UserDetailsServiceImpl service;

    @Autowired
    UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDto> login (@RequestBody UserModel user){
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(userToken);
        var usuario = (UserModel) authentication.getPrincipal();
        return ResponseEntity.ok(tokenService.gerarToken(usuario));
    }

    @RequestMapping(value="/criar-usuario", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserDTO>  criarUsuario (@RequestBody UserDTO user) {

        return ResponseEntity.status(201).body(service.criarUsuario(user));
    }

}
