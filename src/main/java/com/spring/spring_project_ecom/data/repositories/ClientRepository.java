package com.spring.spring_project_ecom.data.repositories;

import com.spring.spring_project_ecom.data.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByTelephone(String tel);
    Page<Client> findAllByActiveTrue(Pageable pageable);
    Page<Client> findAllByTelephoneContainsAndActiveTrue(String telephone,Pageable pageable);
}
