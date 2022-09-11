package com.ecom.eshop.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(Authentication authentication){
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(customUserDetails.getId())
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }

    public String getUserIdFromJwt(String jwtToken){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims.getId();
    }

    public boolean validateToken(String jwtToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
