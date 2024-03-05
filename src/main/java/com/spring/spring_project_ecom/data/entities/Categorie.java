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
@Table(name = "categories")
public class Categorie extends AbstractEntity{

    @Column(unique = true,length = 50, nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
