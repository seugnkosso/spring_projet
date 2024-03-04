package com.spring.spring_project_ecom.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client extends AbstractEntity{

    private String nomComplet;
    private String telephone;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes ;
}
