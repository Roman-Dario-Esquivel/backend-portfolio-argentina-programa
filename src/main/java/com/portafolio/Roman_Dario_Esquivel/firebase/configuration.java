package com.portafolio.Roman_Dario_Esquivel.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {

    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setServiceAccountId("firebase-adminsdk-2qpc3@romandarioesquivel-9162f.iam.gserviceaccount.com")
                .build();
        
        
        FirebaseApp.initializeApp(options);
        
    }

}
