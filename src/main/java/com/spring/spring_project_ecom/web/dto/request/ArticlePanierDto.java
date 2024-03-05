package com.spring.spring_project_ecom.web.dto.request;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlePanierDto {
    private Long idArticle;
    private String libelle;
    private Double nouveauPrix;
    private Double montant=0.0;
    private Double quantite;
    private Double prix;

    public Double calculeNewQte(Double newQte){
        quantite+=newQte;
        return quantite;
    }
    public Double calculeMontant(Double mont){
        montant+=mont;
        return montant;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticlePanierDto that = (ArticlePanierDto) o;
        return Objects.equals(idArticle, that.idArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle);
    }
}
