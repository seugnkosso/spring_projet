package com.spring.spring_project_ecom.security.data.entities;

import com.spring.spring_project_ecom.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")
public class AppRole extends AbstractEntity {
    @Column(nullable = false,unique = true)
    private String roleName;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    List<AppUser> users;
}
