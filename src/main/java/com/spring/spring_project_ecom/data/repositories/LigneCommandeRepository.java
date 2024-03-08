package com.spring.spring_project_ecom.data.repositories;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.LigneCommande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {

}
