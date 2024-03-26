package com.spring.spring_project_ecom.api.controllers;

import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

public interface ClientRestController {
    @GetMapping("/clients")
    ResponseEntity<Map<Object,Object>> listeClient(
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       @RequestParam(defaultValue = "") String keyword
                       );
    @PostMapping("/clients")
    String saveClient(@RequestBody ClientCreateRequestDto clientDto);

}
