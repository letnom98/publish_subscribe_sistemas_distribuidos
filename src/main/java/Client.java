package main.java;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Client implements IClient {
	
	private String name;
	protected IServer server;
	
	public Client(String name) {
		super();
		this.name =  name;
	}

	@Override
	public void alert(String message) throws RemoteException {
		System.out.println(message);
	}
	
	@Override
	public void publishVideo(String name) throws RemoteException {
		server.publish(this, name);
		
	}
	
	@Override
	public void publishChannel(String name) throws RemoteException {
		server.publish(this, new Channel(name, this.name));
		
	}
	
	@Override
	public void subscribe(String channelName) throws RemoteException {
		server.subscribe(this, channelName);
	}
	
	@Override
	public void listChannels() throws RemoteException {
		List<String> availableChannels =  server.availableChannels();
		availableChannels.forEach(channel -> System.out.println(channel));
	}
	
	public static void main(String args[]) throws MalformedURLException, NotBoundException {
		String clientName = args[0], serverName = args[1];
		int port = args[1] != "" ? Integer.parseInt(args[2]) : 1099;
		try {
			IClient client = (IClient)UnicastRemoteObject.exportObject(new Client(clientName), port);
			client.setServer((IServer)Naming.lookup(serverName));
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

	@Override
	public void setServer(IServer server) {
		this.server = server;
		
	}

}
