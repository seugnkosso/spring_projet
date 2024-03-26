package com.spring.spring_project_ecom.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "articles")
public class Article extends AbstractEntity{

    @Column(unique = true,length = 50, nullable = false)
    private String libelle;
    private Double ancienPrix;

    private Double nouveauPrix;

    private Boolean promo;

    private Integer qteStock;

    private String photo;


    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommande;



}
