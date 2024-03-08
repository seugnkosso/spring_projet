package com.spring.spring_project_ecom.web.dto.request;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.web.dto.response.ClientResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanierDto {
    List<ArticlePanierDto> articlesPanier;
    private Double total = 0.0;
    private ClientResponseDto client;

    public void addArticlePanier(ArticlePanierDto articlePanierDto){
        int i = articlesPanier.indexOf(articlePanierDto);
        if (i != -1) {
            ArticlePanierDto articlePanierDto1 = articlesPanier.get(i);;
            articlePanierDto1.calculeNewQte(articlePanierDto.getQuantite());
            articlePanierDto1.calculeMontant(articlePanierDto1.getQuantite()*articlePanierDto1.getPrix());
            total+=articlePanierDto1.getQuantite()*articlePanierDto1.getPrix();
        }else{
            articlePanierDto.setMontant(articlePanierDto.getQuantite()*articlePanierDto.getPrix());
            articlesPanier.add(articlePanierDto);
            total+=articlePanierDto.getMontant();
        }
    }
    public void init (){
        articlesPanier.clear();
        total = 0.0;
        client = null;
    }
}
