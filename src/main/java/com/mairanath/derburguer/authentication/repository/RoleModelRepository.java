package com.mairanath.derburguer.authentication.repository;

import com.mairanath.derburguer.authentication.model.RoleModel;
import com.mairanath.derburguer.enuns.RoleName;

import java.util.List;

public interface RoleModelRepository {
    List<RoleModel> findByRoleNameIn(List<RoleName> listrole);
}
