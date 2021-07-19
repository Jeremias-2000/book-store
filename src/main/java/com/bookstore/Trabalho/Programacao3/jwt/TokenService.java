package com.bookstore.Trabalho.Programacao3.jwt;



//@Service
public class TokenService {



    /*public String generateToken(Authentication authentication) {
       User logged = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("Book Store API")
                .setSubject(logged.getUserId()) // id do usuario
                .setIssuedAt(new Date()) // passando a data de hoje
                .setExpiration(new Date(System.currentTimeMillis() +  SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET_KEY)
                .compact();
    }


    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.SECRET_KEY)
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET_KEY).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }*/
}
