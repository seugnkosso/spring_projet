package com.spring.spring_project_ecom.data.entities;

import com.spring.spring_project_ecom.security.data.entities.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DiscriminatorValue("client")
public class Client extends AppUser {

    private String nomComplet;
    private String telephone;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes ;
}
