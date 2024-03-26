package com.spring.spring_project_ecom.web.controllers;

import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ClientController {
    @GetMapping("/")
    String index();

    @GetMapping("/admin/client")
    String listeClient(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       @RequestParam(defaultValue = "") String keyword,
                       @ModelAttribute("panier") PanierDto panier);

    @GetMapping("/admin/client/form")
    String showForm(Model model);

    @PostMapping("/admin/client/save")
    String saveClient(ClientCreateRequestDto clientDto, BindingResult bindingResult, RedirectAttributes redirectAttributes);

}
