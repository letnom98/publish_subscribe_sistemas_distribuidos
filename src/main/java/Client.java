package main.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Client extends UnicastRemoteObject implements IClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = -474121027877997630L;
	private String name;
	private IServer server;

	public Client(String name, IServer server) throws RemoteException {
		super();
		this.name = name;
		this.server = server;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IServer getServer() {
		return server;
	}

	public void setServer(IServer server) {
		this.server = server;

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
		List<String> availableChannels = server.availableChannels();
		if (availableChannels.isEmpty()) {
			System.out.println("No channels available");
		} else {
			availableChannels.forEach(channel -> System.out.println(channel));
		}
	}

}
