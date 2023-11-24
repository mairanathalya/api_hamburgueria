package com.mairanath.derburguer.dto;

import com.mairanath.derburguer.enuns.RoleName;

import java.util.List;

public class UserDTO {

    private String username;
    private String password;
    private List<RoleName> listrole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleName> getListrole() {
        return listrole;
    }

    public void setListrole(List<RoleName> listrole) {
        this.listrole = listrole;
    }
}
