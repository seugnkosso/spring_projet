package com.spring.spring_project_ecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Adresse{

    private String quartier;

    private String ville;

    private String numVilla;
}
