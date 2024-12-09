package org.example.keycloaksample.config;

import org.example.keycloaksample.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class KeycloakSessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username;
        OidcUser oidcUser;
        if (authentication != null && authentication.getPrincipal() instanceof OidcUser) {
            oidcUser = (OidcUser) authentication.getPrincipal();
            username = oidcUser.getName();
            CustomUser customUser = new CustomUser(username, "", oidcUser.getAuthorities());
            Authentication authenticated = new UsernamePasswordAuthenticationToken(customUser, null, oidcUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticated);
            filterChain.doFilter(request, response);
        }
        else {filterChain.doFilter(request, response);
        }
    }
}
