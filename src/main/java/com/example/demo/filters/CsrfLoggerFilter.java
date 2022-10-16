package com.example.demo.filters;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// followed similar pattern to source: https://github.com/lspil/youtubechannel/blob/master/spring-security-csrf/

/**
 * Used to override doFilterInternal method so that the CSRF-TOKEN is
 * extracted from the request and included in the response header
 */
public class CsrfLoggerFilter extends OncePerRequestFilter {

    /**
     * Override method to extract CSRF-TOKEN from the request and include in the response header
     * @param request incoming HTTP request
     * @param response outgoing HTTP response
     * @param filterChain to store a request attribute for already filtered
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        response.setHeader("CSRF-TOKEN", csrfToken.getToken()); // set CSRF-TOKEN in response header
        filterChain.doFilter(request, response);
    }
}
