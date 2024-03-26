package com.spring.spring_project_ecom.web.dto.request;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.security.data.entities.AppRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCreateRequestDto {
    private Long id;
    @NotBlank(message = "le nom est obligatoire")
    private String nomComplet;
    @NotBlank(message = "le telephone est obligatoire")
    @Pattern(regexp = "^[0-9]{9}", message = "le telephone doit etre 9 chiffre")
    private String telephone;
    private String username;
    private String password;
    private String quartier;
    private String ville;
    private String numVilla;

    public Client toEntity (){
        Client client = new Client();
        client.setUserName(username);
        client.setNomComplet(nomComplet);
        client.setPassword(password);
        client.setTelephone(telephone);
        client.setAdresse(new Adresse(quartier,ville,numVilla));
        return client;
    }
}
