package com.spring.spring_project_ecom.data.repositories;

import com.spring.spring_project_ecom.data.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findAllByActiveTrue();
}
