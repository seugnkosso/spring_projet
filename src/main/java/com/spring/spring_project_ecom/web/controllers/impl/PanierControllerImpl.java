package com.spring.spring_project_ecom.web.controllers.impl;

import com.spring.spring_project_ecom.data.entities.Article;
import com.spring.spring_project_ecom.data.repositories.ArticleRepository;
import com.spring.spring_project_ecom.web.controllers.PanierController;
import com.spring.spring_project_ecom.web.dto.request.ArticlePanierDto;
import com.spring.spring_project_ecom.web.dto.request.PanierDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"panier"})
@RequiredArgsConstructor
public class PanierControllerImpl implements PanierController {
    private final ArticleRepository articleRepository;
    @Override
    public String addPanier(Model model,
                            @Valid ArticlePanierDto articleForm,
                            @ModelAttribute("panier") PanierDto panier) {
        Article article = articleRepository.findById(articleForm.getIdArticle()).orElse(null);
        if (article != null) {
            articleForm.setPrix(articleForm.getPrix()==null ? article.getNouveauPrix() : articleForm.getPrix());
            articleForm.setLibelle(article.getLibelle());
//            panier.getArticlesPanier().add(articleForm);
            panier.addArticlePanier(articleForm);
//            panier.setTotal(panier.getArticlesPanier().stream().);
        }
        return "redirect:/commande/form/"+panier.getClient().getId();
    }
}
