package com.spring.spring_project_ecom.data.fixtures;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Categorie;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.CategorieRepository;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
@RequiredArgsConstructor
public class CategorieFixture implements CommandLineRunner {
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Categorie> categories = new ArrayList<>();
        for (int i = 0 ; i< 20; i++){
            Categorie cat = new Categorie();
            cat.setLibelle("categorie"+i);
            cat.setActive(true);
            categories.add(cat);
        }
        categorieRepository.saveAllAndFlush(categories);

    }
}
