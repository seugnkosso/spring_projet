package com.spring.spring_project_ecom.security.controllers.impl;

import com.spring.spring_project_ecom.security.controllers.security;
import com.spring.spring_project_ecom.security.data.entities.AppUser;
import com.spring.spring_project_ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class securityImpl implements security {
    private final SecurityService securityService;
    @Override
    public String login(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {

            if (userDetails.getAuthorities()
                    .stream()
                    .anyMatch(role -> role.getAuthority().compareTo("Admin") == 0)
            ) {
                return "redirect:/admin/client";
            }

            if (userDetails.getAuthorities()
                    .stream()
                    .anyMatch(role -> role.getAuthority().compareTo("Client") == 0)
            ) {
                AppUser user = securityService.getUserByUserName(userDetails.getUsername());
                return "redirect:/commandes/client/"+user.getId();
            }

        }
        return "/security/login";
    }
}
