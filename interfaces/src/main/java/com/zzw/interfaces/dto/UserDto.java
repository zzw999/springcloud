package com.zzw.interfaces.dto;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
public class UserDto {

    private Long id;

    private String name;

    private String password;

    private RoleDto role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

}
