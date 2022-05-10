package main.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2300730970416274309L;
	private HashMap<IClient, Channel> publishedChannels = new HashMap<IClient, Channel>();
	private HashMap<String, HashSet<IClient>> subscribedClients = new HashMap<String, HashSet<IClient>>();

	public Server() throws RemoteException {
		super();
	}

	@Override
	public void publish(IClient client, Channel channel) throws RemoteException {
		publishedChannels.put(client, channel);
		subscribedClients.put(channel.getName(), new HashSet<IClient>());
	}

	@Override
	public void publish(IClient client, String video) throws RemoteException {
		Channel channel = publishedChannels.get(client);
		channel.addVideo(video);
		HashSet<IClient> subscribers = subscribedClients.get(channel.getName());
		subscribers.forEach(subscriber -> {
			try {
				subscriber.alert("New video : " + channel.getName() + " - " + video);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void subscribe(IClient client, String channel) throws RemoteException {
		HashSet<IClient> subscribers = subscribedClients.get(channel);
		subscribers.add(client);
		client.alert("Congratulations! You just subscribed!");
	}

	@Override
	public List<String> availableChannels() throws RemoteException {
		List<String> channelsNames = new ArrayList<String>();
		publishedChannels.forEach((client, channel) -> channelsNames.add(channel.getName()));
		return channelsNames;
	}
}
