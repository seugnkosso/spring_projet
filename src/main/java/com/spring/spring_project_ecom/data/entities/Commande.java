package com.spring.spring_project_ecom.data.entities;

import com.spring.spring_project_ecom.data.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "commandes")
public class Commande extends AbstractEntity{

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateComd;

    private Double montant;

    @Enumerated(value = EnumType.STRING)
    private EtatCommande etat;

    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    private Client client;

}
