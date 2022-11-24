package com.example.config;

import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PerRequestFilter extends OncePerRequestFilter {

    PerRequestFilter() {

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if(authHeader==null) {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        }
//        else {
//            String jwt = authHeader.replace("Bearer","");
//            if(!isJwtValid(jwt)) {
//                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            }
//            else {
//                filterChain.doFilter(request, response);
//            }
//        }
        filterChain.doFilter(request, response);
    }

    private boolean isJwtValid(String jwt) {
        boolean returnValue = true;
        String subject = Jwts.parser().setSigningKey("fajrifajri").parseClaimsJws(jwt).getBody().getSubject();
        if(subject==null || subject.isEmpty()) {
            returnValue = false;
        }
        return returnValue;
    }
}
