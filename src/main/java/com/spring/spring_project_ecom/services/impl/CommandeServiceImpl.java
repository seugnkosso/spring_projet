package com.spring.spring_project_ecom.services.impl;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.data.repositories.CommandeRepository;
import com.spring.spring_project_ecom.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private  final CommandeRepository commandeRepository;

    @Override
    public Page<Commande> getCommandesByClientWithpaginate(Long id, Pageable pageable) {
        return commandeRepository.findCommandesByClientIdAndActiveTrue(id,pageable);
    }

    @Override
    public Page<Commande> getAllCommandeWhithpaginate(Pageable pageable) {
        return commandeRepository.getCommandesByActiveTrue(pageable);
    }
}
