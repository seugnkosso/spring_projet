package com.spring.spring_project_ecom.web.controllers;

import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientController {
    @GetMapping("/")
    String index();
    @GetMapping("/client")
    String listeClient(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam(defaultValue = "") String keyword);

    @GetMapping("/client/form")
    String showForm(Model model);

    @PostMapping("/client/save")
    String saveClient(ClientCreateRequestDto clientDto);

}
