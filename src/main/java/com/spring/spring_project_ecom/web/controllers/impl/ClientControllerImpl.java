package com.spring.spring_project_ecom.web.controllers.impl;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.web.controllers.ClientController;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import com.spring.spring_project_ecom.web.dto.response.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    @Override
    public String listeClient(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "") String keyword)
    {
        Page<Client> clients = clientService.getAllClientwithpaginateAndFilter(keyword,PageRequest.of(page,size));
        Page<ClientResponseDto> clientDto = clients.map(ClientResponseDto::toDto);
        model.addAttribute("clients",clientDto.getContent());
        model.addAttribute("clientsTotal",clientDto.getTotalElements());
        model.addAttribute("size",clientDto.getContent().stream().count());
        model.addAttribute("pages",new int[clientDto.getTotalPages()]);
        model.addAttribute("nbrPage",clientDto.getTotalPages());
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "client/liste";
    }

    @Override
    public String showForm(Model model) {
        ClientCreateRequestDto clientCreateRequestDto = ClientCreateRequestDto.builder().build();
        model.addAttribute("clientCreateDto",clientCreateRequestDto);
        return "client/form.add.client";
    }

    @Override
    public String saveClient(ClientCreateRequestDto clientDto) {
        clientService.addClient(clientDto);
        return "redirect:/client/form ";
    }

    @Override
    public String index() {
        return "redirect:/client ";
    }
}
