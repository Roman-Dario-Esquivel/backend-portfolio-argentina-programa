from amazoncorretto:11-alpine-jdk   
MAINTAINER romandarioesquivel   
COPY   target/Roman_Dario_Esquivel-0.0.1-SNAPSHOT.jar  romandarioesquivel-app.jar  
ENTRYPOINT ["java","-jar","/romandarioesquivel-app.jar"] 