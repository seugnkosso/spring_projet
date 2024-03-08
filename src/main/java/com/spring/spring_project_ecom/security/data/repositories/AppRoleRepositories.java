package com.spring.spring_project_ecom.security.data.repositories;

import com.spring.spring_project_ecom.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepositories extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String rolename);
}
