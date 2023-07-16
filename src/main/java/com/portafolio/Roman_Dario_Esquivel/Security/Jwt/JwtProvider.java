package com.portafolio.Roman_Dario_Esquivel.Security.Jwt;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.portafolio.Roman_Dario_Esquivel.Security.Entity.UsuarioPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
   private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    private String uid ;
     
    public String generateToken(Authentication authentication) throws FirebaseAuthException{
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        uid = usuarioPrincipal.getNombre();
         String customTokenFirebase;
         customTokenFirebase = FirebaseAuth.getInstance().createCustomToken(uid);
        return customTokenFirebase;
    }
    
    public String getNombreUSuarioFromToken(String token) throws FirebaseAuthException{
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
       String uid_validation = decodedToken.getUid();
        return uid_validation;
    }
    
    public boolean validateToken(String token) throws FirebaseAuthException{
       FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
       String uid_validation = decodedToken.getUid();
       return uid_validation.equals(uid);
    }
}
