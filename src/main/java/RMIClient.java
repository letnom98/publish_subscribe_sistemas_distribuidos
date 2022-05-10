package main.java;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// public class RMIClient {
//     public static void main(String args[]) throws MalformedURLException, NotBoundException {
//         // String clientName = args[0], serverName = args[1];
//         // int port = args[1] != "" ? Integer.parseInt(args[2]) : 1099;
//         int port = 1099;
//         String clientName = "teste1";
//         String serverName = "rmi://localhost/TopicPublisher";
//         try {
//             IClient client = (IClient) UnicastRemoteObject.exportObject(new Client(clientName), port);
//             client.setServer((IServer) Naming.lookup(serverName));
//             client.listChannels();
//         } catch (RemoteException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }

//     }
// }

public class RMIClient {

    public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
        String serverName = "rmi://localhost:1099/TopicPublisher";
        IServer server = (IServer) Naming.lookup(serverName);
        IClient client = new Client("teste1", server);
        //ClientPanel panel = new ClientPanel(client);
    }
}