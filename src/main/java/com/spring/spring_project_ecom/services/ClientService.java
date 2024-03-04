package com.spring.spring_project_ecom.services;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<Client> getAllClientwithpaginateAndFilter(String keyword, Pageable pageable);

    void addClient(ClientCreateRequestDto dto);
}
