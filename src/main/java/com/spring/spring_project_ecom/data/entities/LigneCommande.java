package com.spring.spring_project_ecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ligne_commandes")
public class LigneCommande extends AbstractEntity{

    private Double montant;

    private Double quantite;

    private Double prix;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Commande commande;

}
