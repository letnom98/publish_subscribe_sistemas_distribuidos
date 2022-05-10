package main.java;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            IServer server = new Server();
            String serverName = "rmi://localhost/TopicPublisher";
            if (LocateRegistry.getRegistry(1099) == null) {
                LocateRegistry.createRegistry(1099);
            }
            Naming.rebind(serverName, server);
            System.out.println("Server Started!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// public static void main(String args[]){
// //int port = args[1] != null ? Integer.parseInt(args[0]) : 1099;
// int port = 1099;
// String serverName = "rmi://localhost/TopicPublisher";
// Registry registry;
// try {
// registry = LocateRegistry.getRegistry(5000);
// IServer server = (IServer)UnicastRemoteObject.exportObject(new Server(), 0);
// if(registry == null) {
// System.out.println("entrei");
// registry = LocateRegistry.createRegistry(port);
// registry.rebind(serverName, server);
// }

// System.out.println("Server Started!");
// } catch (RemoteException e) {
// e.printStackTrace();
// }
// }