package com.group.project.configuration;

import com.group.project.services.CustomUserDetailsService;
import com.group.project.utils.JwtUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Andreas
 */
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    
    //private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    private final CustomUserDetailsService customUserDetailsService;

    public CustomAuthorizationFilter(CustomUserDetailsService customUserDetailsManager) {
        this.customUserDetailsService = customUserDetailsManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().startsWith("/login")
                || request.getServletPath().startsWith("/js")) {
            filterChain.doFilter(request, response);
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String realjwt = authorizationHeader.substring("Bearer ".length()).trim();
                //TODO 2 Να το ελεγξει expired, valid
                JwtUtil jwtUtil = JwtUtil.getInstance();
                Authentication loggedinuser = SecurityContextHolder.getContext().getAuthentication();
                String jwtusername = jwtUtil.getUsernameFromToken(realjwt);
                if (loggedinuser == null && jwtusername != null) {
                    // 1o request μετα το login
                    UserDetails userfromdb = customUserDetailsService.loadUserByUsername(jwtusername);
                    UsernamePasswordAuthenticationToken principal
                            = new UsernamePasswordAuthenticationToken(userfromdb, null, userfromdb.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(principal);
                    filterChain.doFilter(request, response);
                } else {
                    // Δεν ειναι το 1ο request μετα το login
                    UserDetails user = (UserDetails) loggedinuser.getPrincipal();
                    if (user.getUsername().equals(jwtusername)) {
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendError(403, "You must login");
                    }
                }
            } else {
                response.sendError(403, "You must login");
            }
        }
    }

}
