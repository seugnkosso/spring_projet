package com.spring.spring_project_ecom.security.services;

import com.spring.spring_project_ecom.security.data.entities.AppRole;
import com.spring.spring_project_ecom.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUserName(String userName);
    AppUser saveUser(String username,String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String userName,String roleName);
    void removeRoleToUser(String userName,String roleName);
}
