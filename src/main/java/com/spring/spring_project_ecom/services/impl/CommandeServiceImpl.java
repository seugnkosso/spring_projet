package com.spring.spring_project_ecom.services.impl;

import com.spring.spring_project_ecom.data.entities.*;
import com.spring.spring_project_ecom.data.enums.EtatCommande;
import com.spring.spring_project_ecom.data.repositories.ArticleRepository;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.data.repositories.CommandeRepository;
import com.spring.spring_project_ecom.data.repositories.LigneCommandeRepository;
import com.spring.spring_project_ecom.exceptions.EntityNotFoundException;
import com.spring.spring_project_ecom.services.CommandeService;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private  final CommandeRepository commandeRepository;
    private  final ClientRepository clientRepository;
    private  final ArticleRepository articleRepository;
    private  final LigneCommandeRepository ligneCommandeRepository;


    @Override
    public Page<Commande> getCommandesByClientWithpaginate(Long id, Pageable pageable) {
        return commandeRepository.findCommandesByClientIdAndActiveTrue(id,pageable);
    }

    @Override
    public Page<Commande> getAllCommandeWhithpaginate(Pageable pageable) {
        return commandeRepository.getCommandesByActiveTrue(pageable);
    }

    @Override
    public void saveCommande(PanierDto panierDto) {
        Client client = clientRepository.findById(panierDto.getClient().getId()).orElseThrow(() -> new EntityNotFoundException("client n'existe pas"));
        if(client != null){
            Commande commande = new Commande(new Date(),
                    panierDto.getTotal(),
                    EtatCommande.Encours,
                    new Adresse(panierDto.getClient().getQuartier(),
                            panierDto.getClient().getVille(),
                            panierDto.getClient().getNumVilla()),
                    null,
                    client
                    );
            commande.setActive(true);
            commandeRepository.save(commande);
            List<LigneCommande> ligneCommandes = panierDto.getArticlesPanier().stream().map(articlePanierDto -> {
                Article article = articleRepository.findById(articlePanierDto.getIdArticle()).orElseThrow(() -> new EntityNotFoundException("l'article n,existe pas"));
                LigneCommande lcmd = new LigneCommande(
                        articlePanierDto.getMontant(),
                        articlePanierDto.getQuantite(),
                        articlePanierDto.getPrix(),
                        article,
                        commande
                );
                lcmd.setActive(true);
                return lcmd;
            }).toList();
            ligneCommandeRepository.saveAllAndFlush(ligneCommandes);
        }
    }
}
