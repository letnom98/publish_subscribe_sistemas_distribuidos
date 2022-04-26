package main.java;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Server implements IServer {
	
	@Override
	public void publish(IClient client, Topic topic) throws RemoteException {
		// TODO Auto-generated method stub
	}

	@Override
	public void subscribe(IClient client, Topic topic) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void comment(Topic topic, String message) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Topic> avalableTopics() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]){
		IServer server = new Server();
		String serverName = "rmi://localhost/TopicPublisher";
		
		Registry registry;
		try {
			
			registry = LocateRegistry.getRegistry(1099);
			if(registry == null) {
				registry = LocateRegistry.createRegistry(1099);
			}
			registry.rebind(serverName, server);
			
			System.out.println("Server Started!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
