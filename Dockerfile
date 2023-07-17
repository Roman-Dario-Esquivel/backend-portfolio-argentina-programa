FROM amazoncorretto:11-alpine-jdk 
ENV   GOOGLE_APPLICATION_CREDENTIALS src/main/java/com/portafolio/Roman_Dario_Esquivel/firebase/romandarioesquivelfirebase.json
MAINTAINER romandarioesquivel   
COPY   target/Roman_Dario_Esquivel-0.0.1-SNAPSHOT.jar  romandarioesquivel-app.jar  
ENTRYPOINT ["java","-jar","/romandarioesquivel-app.jar"] 