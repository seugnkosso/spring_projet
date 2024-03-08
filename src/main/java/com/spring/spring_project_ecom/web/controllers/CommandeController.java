package com.spring.spring_project_ecom.web.controllers;

import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommandeController {

    @GetMapping("/admin/commandes")
    String commandes(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size);

    @GetMapping("/commandes/client/{id}")
    String commandesClient(Model model,
                        @PathVariable Long id,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam(defaultValue = "0") int page);

    @GetMapping("/admin/commande/form/{id}")
    String formCommande(Model model,
                        @PathVariable Long id,
                        @ModelAttribute PanierDto panier);

    @GetMapping("/admin/commande/save")
    String saveCommande(@ModelAttribute("panier") PanierDto panier);
}
