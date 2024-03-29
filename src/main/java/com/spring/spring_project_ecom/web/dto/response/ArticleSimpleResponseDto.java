package com.spring.spring_project_ecom.web.dto.response;

import com.spring.spring_project_ecom.data.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleSimpleResponseDto {
    private Long id;
    private String libelle;
}
