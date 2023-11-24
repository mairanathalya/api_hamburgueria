package com.mairanath.derburguer.authentication.service;

import com.mairanath.derburguer.authentication.model.RoleModel;
import com.mairanath.derburguer.authentication.model.UserModel;
import com.mairanath.derburguer.authentication.repository.RoleModelRepository;
import com.mairanath.derburguer.authentication.repository.UserRepository;
import com.mairanath.derburguer.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleModelRepository roleModelRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          return userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Não foi encontrado o usúario:" + username));
    }

    @Transactional
    public UserDTO criarUsuario(UserDTO userDTO){


        if (userDTO.getUsername() != null && userDTO.getPassword() != null && !userDTO.getListrole().isEmpty()) {

            List<RoleModel> roleModel = roleModelRepository.findByRoleNameIn(userDTO.getListrole());

            if(roleModel.isEmpty()){
                throw new UsernameNotFoundException("ROLE inexistente" );
            }

            UserModel userModel = new UserModel();
            userModel.setRoles(roleModel);
            userModel.setUserName(userDTO.getUsername());
            userModel.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

            userRepository.save(userModel);
        }else {
            throw new UsernameNotFoundException("Parametros null");
        }

        return userDTO;
    }
}
