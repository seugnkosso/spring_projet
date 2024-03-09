package com.spring.spring_project_ecom.security.data.fixtures;

import com.spring.spring_project_ecom.data.entities.Categorie;
import com.spring.spring_project_ecom.data.repositories.CategorieRepository;
import com.spring.spring_project_ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(1)
@RequiredArgsConstructor
public class AppRoleFixture implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        securityService.saveRole("Admin");
        securityService.saveRole("Client");
    }
}
