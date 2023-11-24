package com.mairanath.derburguer.authentication.repository;

import com.mairanath.derburguer.authentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUserName(String userName);

    ///UserDetails findByLogin(String login);
}
