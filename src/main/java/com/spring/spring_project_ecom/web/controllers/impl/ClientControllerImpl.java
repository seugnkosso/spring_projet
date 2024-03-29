package com.spring.spring_project_ecom.web.controllers.impl;

import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.web.controllers.ClientController;
import com.spring.spring_project_ecom.web.dto.request.ClientCreateRequestDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import com.spring.spring_project_ecom.web.dto.response.ClientResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    @Override
    public String listeClient(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "") String keyword,
                              @ModelAttribute("panier") PanierDto panier)
    {
        panier.init();
        Page<Client> clients = clientService.getAllClientwithpaginateAndFilter(keyword,PageRequest.of(page,size));
        Page<ClientResponseDto> clientDto = clients.map(ClientResponseDto::toDto);
        model.addAttribute("clients",clientDto.getContent());
        model.addAttribute("clientsTotal",clientDto.getTotalElements());
        model.addAttribute("size", (long) clientDto.getContent().size());
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
    public String saveClient(@Valid ClientCreateRequestDto clientDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            redirectAttributes.addFlashAttribute("errors",errors);
        }else{
            clientService.addClient(clientDto);
        }
        return "redirect:/admin/client/form";
    }

    @Override
    public String index() {
        return "redirect:/admin/client ";
    }

    @ModelAttribute("panier")
    public PanierDto panier(){
        return new PanierDto(
                new ArrayList<>(),
                0.0,
                null
        );
    }
}
