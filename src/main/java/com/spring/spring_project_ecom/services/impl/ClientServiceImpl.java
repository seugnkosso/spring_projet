package com.spring.spring_project_ecom.services.impl;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public Page<Client> getAllClientwithpaginateAndFilter(String keyword, Pageable pageable) {
        return clientRepository.findAllByTelephoneContainsAndActiveTrue(keyword,pageable);
    }

    @Override
    public void addClient(ClientCreateRequestDto dto) {
        Client client = dto.toEntity();
        client.setActive(true);
        clientRepository.save(client);
    }
}
