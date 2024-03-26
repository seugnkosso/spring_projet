package com.spring.spring_project_ecom.services.impl;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.security.data.entities.AppRole;
import com.spring.spring_project_ecom.security.data.entities.AppUser;
import com.spring.spring_project_ecom.security.data.repositories.AppRoleRepositories;
import com.spring.spring_project_ecom.security.data.repositories.AppUserRepositories;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AppRoleRepositories appRoleRepositories;
    private final AppUserRepositories appUserRepositories;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<Client> getAllClientwithpaginateAndFilter(String keyword, Pageable pageable) {
        return clientRepository.findAllByTelephoneContainsAndActiveTrue(keyword,pageable);
    }

    @Override
    public void addClient(ClientCreateRequestDto dto) {
        Client client = dto.toEntity();
        client.getRoles().add(appRoleRepositories.findByRoleName("Client"));
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    @Override
    public Client getClientByid(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
