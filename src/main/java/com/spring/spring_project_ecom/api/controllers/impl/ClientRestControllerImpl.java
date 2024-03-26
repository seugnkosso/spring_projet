package com.spring.spring_project_ecom.api.controllers.impl;

import com.spring.spring_project_ecom.api.controllers.ClientRestController;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import com.spring.spring_project_ecom.web.dto.response.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ClientRestControllerImpl implements ClientRestController {

    private final ClientService clientService;
    @Override
    public ResponseEntity<Map<Object,Object>> listeClient(int page, int size, String keyword) {
        Page<Client> clients = clientService.getAllClientwithpaginateAndFilter(keyword, PageRequest.of(page,size));
        Page<ClientResponseDto> clientDto = clients.map(ClientResponseDto::toDto);
        Map<Object,Object> model = new HashMap<>();
        model.put("results",clientDto.getContent());
        model.put("totalItems",clientDto.getTotalElements());
        model.put("size", (long) clientDto.getContent().size());
        model.put("pages",new int[clientDto.getTotalPages()]);
        model.put("totalPages",clientDto.getTotalPages());
        model.put("currentPage",page);
        return new  ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public String saveClient(ClientCreateRequestDto clientDto) {
        return null;
    }
}
