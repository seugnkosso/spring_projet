package com.spring.spring_project_ecom.data.repositories;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Page<Commande> getCommandesByActiveTrue(Pageable pageable);
    Page<Commande> findCommandesByClientIdAndActiveTrue(Long id, Pageable pageable);
}
