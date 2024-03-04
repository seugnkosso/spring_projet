package com.spring.spring_project_ecom.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommandeController {

    @GetMapping("/commandes")
    String commandes(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size);

    @GetMapping("/commandes/client/{id}")
    String commandesClient(Model model,
                        @PathVariable Long id,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam(defaultValue = "0") int page);
}
