package com.accenture.russiaatc.irentservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class RestControllerSecurityInterceptor extends HandlerInterceptorAdapter {

    @Value("${security.secretString}")
    private String secret;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String[] authParts = authorizationHeader.split("");

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authParts[1]).getBody();
            CallContext callContext = CallContext.builder()
                    .userId(Long.valueOf(claims.getSubject()))
                    .login(claims.get("login", String.class))
                    .role(claims.get("role", String.class))
                    .build();
            log.info("Пользователь id={}, login={}, role={}", callContext.getUserId(), callContext.getLogin(), callContext.getRole());
            SecurityContext.set(callContext);
        }
        catch (Exception e) {
        }
        return true;
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        SecurityContext.clear();
    }

}
