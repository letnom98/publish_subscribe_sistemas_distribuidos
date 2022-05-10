package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	void alert(String message) throws RemoteException;
	void publishVideo(String name) throws RemoteException;
	void publishChannel(String name) throws RemoteException;
	void subscribe(String channelName) throws RemoteException;
	void listChannels() throws RemoteException;
	void setServer(IServer server) throws RemoteException;
}
