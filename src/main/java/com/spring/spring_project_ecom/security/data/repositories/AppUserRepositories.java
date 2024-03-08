package com.spring.spring_project_ecom.security.data.repositories;

import com.spring.spring_project_ecom.security.data.entities.AppRole;
import com.spring.spring_project_ecom.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepositories extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}
