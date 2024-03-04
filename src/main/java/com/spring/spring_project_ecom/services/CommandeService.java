package com.spring.spring_project_ecom.services;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommandeService {
    Page<Commande> getCommandesByClientWithpaginate(Long id, Pageable pageable);
    Page<Commande> getAllCommandeWhithpaginate(Pageable pageable);
}
