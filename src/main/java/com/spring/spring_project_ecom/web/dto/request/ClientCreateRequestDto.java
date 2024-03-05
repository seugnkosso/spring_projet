package com.spring.spring_project_ecom.web.dto.request;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "le nom est obligatoire")
    private String nomComplet;
    @NotBlank(message = "le telephone est obligatoire")
    @Pattern(regexp = "^[0-9]{9}", message = "le telephone doit etre 9 chiffre")
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
