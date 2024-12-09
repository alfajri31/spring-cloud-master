package org.example.keycloaksample.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

            // Extract user information from OAuth2 token
            String userName = oauthToken.getPrincipal().getName();
            String email = (String) oauthToken.getPrincipal().getAttributes().get("email");

            // You can add custom logic here, like logging or role-based redirects
            System.out.println("User Logged In: " + userName);
            System.out.println("User Email: " + email);
        }

        // Redirect to a default page
        response.sendRedirect("/welcome");
    }
}
