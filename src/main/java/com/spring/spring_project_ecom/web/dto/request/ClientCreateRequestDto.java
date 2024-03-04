package com.spring.spring_project_ecom.web.dto.request;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCreateRequestDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String quartier;
    private String ville;
    private String numVilla;

    public Client toEntity (){
         return Client.builder()
                 .nomComplet(nomComplet)
                 .telephone(telephone)
                 .adresse(new Adresse(quartier,ville,numVilla))
                 .build();
    }
}
