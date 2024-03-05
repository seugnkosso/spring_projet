package com.spring.spring_project_ecom.data.fixtures;

import com.spring.spring_project_ecom.data.entities.Adresse;
import com.spring.spring_project_ecom.data.entities.Article;
import com.spring.spring_project_ecom.data.entities.Categorie;
import com.spring.spring_project_ecom.data.repositories.ArticleRepository;
import com.spring.spring_project_ecom.data.repositories.CategorieRepository;
import com.spring.spring_project_ecom.data.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
@Order(4)
@RequiredArgsConstructor
public class ArticleFixture implements CommandLineRunner {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1 ; i< 21; i++){
            if (categorieRepository.findById((long) i).isPresent()) {
                 Categorie cat = categorieRepository.findById((long) i).get();
                for (int j=0;j<5;j++) {
                        Article article = new Article();
                        article.setLibelle("article"+j+i);
                        article.setAncienPrix(1200.0+j+i);
                        article.setNouveauPrix(1300.0+j+i);
                        article.setQteStock(12+i+j);
                        article.setPhoto("image0"+j+i);
                        article.setPromo(i % 2 == 0);
                        article.setActive(true);
                        article.setCategorie(cat);
                        articleRepository.save(article);
                    }
            }
        }
    }
}
