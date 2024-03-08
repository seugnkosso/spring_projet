package com.spring.spring_project_ecom.web.controllers;

import com.spring.spring_project_ecom.web.dto.request.ArticlePanierDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public interface PanierController {
    @PostMapping("/admin/panier/add")
    String addPanier(Model model, @Valid ArticlePanierDto articleForm, @ModelAttribute("panier") PanierDto panier);
}
