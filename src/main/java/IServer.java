package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
	void publish(IClient client, Topic topic) throws RemoteException;
	void subscribe(IClient client, Topic topic) throws RemoteException;
	void comment(Topic topic, String message) throws RemoteException;
	List<Topic> avalableTopics() throws RemoteException;
}
