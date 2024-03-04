package com.spring.spring_project_ecom.data.fixtures;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@RequiredArgsConstructor
public class ClientFixture implements CommandLineRunner {
    private final ClientRepository clientRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0 ; i< 20; i++){
                Client client = new Client();
                client.setNomComplet("client"+i);
                client.setTelephone("77233494"+i);
                Adresse adresse = new Adresse();
                adresse.setNumVilla("numVilla"+i);
                adresse.setVille("ville"+i);
                adresse.setQuartier("quartier"+i);
                client.setAdresse(adresse);
                client.setActive(i % 2 == 0);
                clientRepository.save(client);
        }
    }
}
