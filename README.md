Aluno: Pablo Montel de Oliveira e Julio Carvalho

Compilação e execute do servidor
LOCAL: src/main/java
CMD: javac -d classes Channel.java IClient.java IServer.java Client.java Server.java RMIClient.java RMIServer.java
CMD: cd classes
CMD: PATH=%PATH%;C:\Program Files\Java\jdk-18.0.1.1\bin   #VERSÃO JDK PATH!!!!!!!
CMD: start rmiregistry
CMD: cd ..
CMD: java -classpath classes -Djava.rmi.server.codebase=file:classes/ main.java.RMIServer
(!) "Server Started!" caso tudo ocorra bem

Executar cliente (novo terminal)
LOCAL: src/main/java
CMD: java -classpath classes -Djava.rmi.server.codebase=file:classes/ main.java.RMIClient [user]

onde:
[user] é uma string para identificar esse usuário.
