package main.java;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMIClient {

    public static void menu(IClient client) {
        int op = 0;
        String name;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("0 - Sair");
            System.out.println("1 - Publicar canal");
            System.out.println("2 - Publicar vídeo");
            System.out.println("3 - Se inscrever");
            System.out.println("4 - Consultar canais disponíveis");
            op = sc.nextInt();

            switch (op) {
                case 0:
                    op = 0;
                    break;
                case 1:
                    System.out.println("Digite o nome do canal:");
                    name = sc.next();
                    try {

                        client.publishChannel(name);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do vídeo:");
                    name = sc.next();
                    try {
                        client.publishVideo(name);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Qual o nome do canal?");
                    name = sc.next();
                    try {
                        client.subscribe(name);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Canais disponíveis:");
                    name = sc.next();
                    try {
                        client.listChannels();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                    break;
                default:
                    System.out.println("Opção não disponível :(");
                    op = -1;
                    break;
            }

        } while (op != 0);
        sc.close();
    }

    public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
        String clientName = args[0].isBlank() ? "client 0" : args[0];
        String serverName = "rmi://localhost:1099/TopicPublisher";
        IServer server = (IServer) Naming.lookup(serverName);
        IClient client = new Client(clientName, server);
        menu(client);
    }
}