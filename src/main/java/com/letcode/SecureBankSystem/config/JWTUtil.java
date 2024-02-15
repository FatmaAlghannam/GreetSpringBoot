package com.letcode.SecureBankSystem.config;

import antlr.Token;
import com.letcode.SecureBankSystem.bo.customUserDetails.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JWTUtil {
    private final String jwtSignKey = "secret";

    public String generateToken(CustomUserDetails userDetails){
        return doGenerateToken(userDetails.getClaims(),userDetails.getUserName());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, jwtSignKey).compact();
    }
    private Claims getALLClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSignKey).parseClaimsJwt(token).getBody();
    }
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        final  Claims claims= getALLClaimsFromToken(token);
        return  claimsResolver.apply(claims);

    }
    public  Date getExpirationDateFromToken(String token){
        //method referance that is the big one and take from the small one "big boss::small one"
        return  getClaimsFromToken(token, Claims:: getExpiration);

    }
    public  boolean isTokenExpired(String token ){
        Date tokenExpirationDate= getExpirationDateFromToken(token);
        return tokenExpirationDate.before(new Date());

    }
    public  boolean isTokenValid(String token){
        try{
            return  !isTokenExpired(token);

        }catch (Exception exception){
            return  false;
        }
    }
    public  String getUserNameFromToken(String token){
        return  getClaimsFromToken(token,Claims::getSubject);

    }

}
