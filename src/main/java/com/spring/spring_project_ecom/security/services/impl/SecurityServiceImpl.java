package com.spring.spring_project_ecom.security.services.impl;

import com.spring.spring_project_ecom.security.data.entities.AppRole;
import com.spring.spring_project_ecom.security.data.entities.AppUser;
import com.spring.spring_project_ecom.security.data.repositories.AppRoleRepositories;
import com.spring.spring_project_ecom.security.data.repositories.AppUserRepositories;
import com.spring.spring_project_ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
    private final AppUserRepositories appUserRepositories;
    private final AppRoleRepositories appRoleRepositories;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AppUser getUserByUserName(String userName) {
        return appUserRepositories.findByUserName(userName);
    }

    @Override
    public AppUser saveUser(String username, String password) {
        AppUser user = appUserRepositories.findByUserName(username);
        if (user != null) {throw new RuntimeException("l'utilisateur existe deja");}
        user = new AppUser(username,passwordEncoder.encode(password),null);
        return appUserRepositories.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if(role != null){throw new RuntimeException("role existe deja");}
        role = new AppRole(roleName,null);
        return appRoleRepositories.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if(role == null){throw new RuntimeException("role not found");}
        AppUser user = appUserRepositories.findByUserName(userName);
        if (user == null) {throw new RuntimeException("user not found");}
        user.getRoles().add(role);
        appUserRepositories.save(user);
    }

    @Override
    public void removeRoleToUser(String userName, String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if(role == null){throw new RuntimeException("role not found");}
        AppUser user = appUserRepositories.findByUserName(userName);
        if (user == null) {throw new RuntimeException("user not found");}
        user.getRoles().remove(role);
        appUserRepositories.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepositories.findByUserName(username);
        List<SimpleGrantedAuthority> authorize = appUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).toList();
        return new User(appUser.getUserName(), appUser.getPassword(),authorize);
    }
}
