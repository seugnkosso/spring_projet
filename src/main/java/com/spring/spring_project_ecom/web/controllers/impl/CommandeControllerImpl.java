package com.spring.spring_project_ecom.web.controllers.impl;

import com.spring.spring_project_ecom.data.entities.Article;
import com.spring.spring_project_ecom.data.entities.Client;
import com.spring.spring_project_ecom.data.entities.Commande;
import com.spring.spring_project_ecom.services.ArticleService;
import com.spring.spring_project_ecom.services.ClientService;
import com.spring.spring_project_ecom.services.CommandeService;
import com.spring.spring_project_ecom.web.controllers.CommandeController;
import com.spring.spring_project_ecom.web.dto.request.ArticlePanierDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import com.spring.spring_project_ecom.web.dto.response.ArticleSimpleResponseDto;
import com.spring.spring_project_ecom.web.dto.response.ClientResponseDto;
import com.spring.spring_project_ecom.web.dto.response.CommandeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class CommandeControllerImpl implements CommandeController {
    private final CommandeService commandeService;
    private final ArticleService articleService;
    private final ClientService clientService;
    @Override
    public String commandes(Model model,
                            @RequestParam(defaultValue = "5") int size,
                            @RequestParam(defaultValue = "0") int page) {
        Page<Commande> commandes = commandeService.getAllCommandeWhithpaginate(PageRequest.of(page,size));
        Page<CommandeResponseDto> commandesDto = commandes.map(CommandeResponseDto::toDto);
        model.addAttribute("commandesDto",commandesDto.getContent());
        model.addAttribute("clientId",null);
        return getString(model, page, commandesDto);
    }

    @Override
    public String commandesClient(Model model,
                                  @PathVariable Long id,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "0") int page) {
        Page<Commande> commandes = commandeService.getCommandesByClientWithpaginate(id, PageRequest.of(page,size));
        Page<CommandeResponseDto> commandesDto = commandes.map(CommandeResponseDto::toDto);
        model.addAttribute("commandesDto",commandesDto.getContent());
        model.addAttribute("clientId",id);
        return getString(model, page, commandesDto);
    }

    @Override
    public String formCommande(Model mode,
                               @PathVariable Long id,
                               @ModelAttribute("panier") PanierDto panier) {
        List<Article> articles = articleService.getArticles();
        panier.setClient(ClientResponseDto.toDto(clientService.getClientByid(id)));
        List<ArticleSimpleResponseDto> articlesimpleResponseDto = articles.stream().map(art -> new ArticleSimpleResponseDto(art.getId(), art.getLibelle())).toList();
        mode.addAttribute("articleSelectForm" ,articlesimpleResponseDto);
        mode.addAttribute("panier",panier);
        mode.addAttribute("articleForm",new ArticlePanierDto());
        return "commande/form.add.commande";
    }

    @Override
    public String saveCommande(@ModelAttribute("panier") PanierDto panier) {
        commandeService.saveCommande(panier);
        Long id = panier.getClient().getId();
        panier.init();
        return "redirect:/admin/commande/form/"+id;
    }

    private String getString(Model model, @RequestParam(defaultValue = "0") int page, Page<CommandeResponseDto> commandesDto) {
        model.addAttribute("commandesTotal",commandesDto.getTotalElements());
        model.addAttribute("size",commandesDto.getContent().stream().count());
        model.addAttribute("pages",new int[commandesDto.getTotalPages()]);
        model.addAttribute("nbrPage",commandesDto.getTotalPages());
        model.addAttribute("currentPage",page);
        return "commande/liste";
    }

}
