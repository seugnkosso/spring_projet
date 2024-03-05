package com.spring.spring_project_ecom.services.impl;

import com.spring.spring_project_ecom.data.entities.Article;
import com.spring.spring_project_ecom.data.repositories.ArticleRepository;
import com.spring.spring_project_ecom.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    @Override
    public List<Article> getArticles() {
        return articleRepository.findAllByActiveTrue();
    }
}
