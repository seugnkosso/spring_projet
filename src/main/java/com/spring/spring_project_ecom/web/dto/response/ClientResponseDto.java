package com.spring.spring_project_ecom.web.dto.response;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponseDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String quartier;
    private String ville;
    private String numVilla;

    public static ClientResponseDto toDto (Client client){
        return ClientResponseDto
                .builder()
                .id(client.getId())
                .nomComplet(client.getNomComplet())
                .telephone(client.getTelephone())
                .quartier(client.getAdresse().getQuartier())
                .ville(client.getAdresse().getVille())
                .numVilla(client.getAdresse().getNumVilla())
                .build();
    }
}
