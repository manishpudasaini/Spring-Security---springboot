package com.springSecurity.SpringSecurity.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtService {

    private final String SECRETE_KEY= "4226452948404D635166546A576E5A7234753777217A25432A462D4A614E6452";

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignedKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRETE_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }


}
