package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
	void publish(IClient client, Channel channel) throws RemoteException;
	void publish(IClient client, String video) throws RemoteException;
	void subscribe(IClient client, String channel) throws RemoteException;
	List<String> availableChannels() throws RemoteException;
}
