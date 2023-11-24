package com.mairanath.derburguer.authentication.repository;

import com.mairanath.derburguer.authentication.model.RoleModel;
import com.mairanath.derburguer.enuns.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {
     List<RoleModel> findByRoleNameIn(List<RoleName> roles);

     RoleModel findByRoleName(String nome);

}
