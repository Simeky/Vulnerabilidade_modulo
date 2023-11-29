package com.vulnerabilidade.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.vulnerabilidade.classes.Users;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;
  
  public String generate_token(Users user){
    try {

      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token =  JWT.create()
                      .withIssuer("vulnerabilidade")
                      .withSubject(user.getLogin())
                      .withExpiresAt(generate_expiration_date())
                      .sign(algorithm);
      
      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Error while generating token", e);
    }
  }

  public String validate_token(String token){
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return  JWT.require(algorithm)
              .withIssuer("vulnerabilidade")
              .build()
              .verify(token)
              .getSubject();
    } catch (JWTVerificationException e) {
      return "";
    }


  }

  private Instant generate_expiration_date(){

    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    
  }

}
