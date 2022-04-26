package main.java;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client implements IClient {
	
	private String name;
	
	public Client(String name) {
		// TODO Auto-generated constructor stub
		this.name =  name;
	}

	@Override
	public void exhibit(String message) throws RemoteException {
		// TODO Auto-generated method stub
	}
	
	public static void main(String args[]) throws MalformedURLException, NotBoundException {
		int port = Integer.parseInt(args[1]);
		String clientName = args[0], serverName = args[2];
		try {
			IClient client = (IClient)UnicastRemoteObject.exportObject(new Client(clientName), port);
			IServer server = (IServer)Naming.lookup(serverName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
