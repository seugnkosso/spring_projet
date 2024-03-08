package com.spring.spring_project_ecom.security.data.entities;

import com.spring.spring_project_ecom.data.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "AppUser")
public class AppUser extends AbstractEntity {
    @Column(nullable = false,unique = true)
    private String userName ;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    List<AppRole> roles = new ArrayList<AppRole>();
}
