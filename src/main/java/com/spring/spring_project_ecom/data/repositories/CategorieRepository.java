package com.spring.spring_project_ecom.data.repositories;

import com.spring.spring_project_ecom.data.entities.Categorie;
import com.spring.spring_project_ecom.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    
}
