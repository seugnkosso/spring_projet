package com.spring.spring_project_ecom.data.fixtures;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import com.spring.spring_project_ecom.data.enums.EtatCommande;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.data.repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(4)
@RequiredArgsConstructor
public class CommandeFixture implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0 ; i< 20; i++){
                Client client = clientRepository.findByTelephone("77233494"+i);
                for (int j =0 ;j< 5 ; j++){
                    Commande commande = new Commande();
                    commande.setDateComd(new Date());
                    commande.setMontant(1000.0+j*i);
                    commande.setActive(j % 2 == 0);
                    Adresse adresse;
                    if (j % 2 == 0 ){
                        adresse = new Adresse();
                        adresse.setNumVilla("numVilla"+j);
                        adresse.setVille("ville"+j);
                        adresse.setQuartier("quartier"+j);
                        commande.setEtat(EtatCommande.Encours);
                    }else{
                        commande.setEtat(EtatCommande.Terminer);
                        adresse = client.getAdresse();
                    }
                    commande.setAdresse(adresse);
                    commande.setClient(client);
                    commandeRepository.save(commande);
                }
        }
    }
}
