package com.spring.spring_project_ecom.web.dto.response;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import com.spring.spring_project_ecom.data.entities.LigneCommande;
import com.spring.spring_project_ecom.data.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeResponseDto {
    private Long id;
    private Date dateComd;
    private Double montant;
    private Double prix;
    private EtatCommande etat;
    private EtatCommande etatSuivant;
    private String quartier;
    private String ville;
    private String numVilla;

    public static CommandeResponseDto toDto (Commande commande){
        EtatCommande etatSuivant = EtatCommande.Payer;
        if (commande.getEtat() != EtatCommande.Payer){
            long index = commande.getEtat().getIndexEnumEtat() + 1;
            etatSuivant = EtatCommande.values()[(int)index];
        }
        return CommandeResponseDto
                .builder()
                .id(commande.getId())
                .dateComd(commande.getDateComd())
                .montant(commande.getMontant())
                .etat(commande.getEtat())
                .quartier(commande.getAdresse().getQuartier())
                .ville(commande.getAdresse().getVille())
                .numVilla(commande.getAdresse().getNumVilla())
                .etatSuivant(etatSuivant)
                .build();
    }
}
