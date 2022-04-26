package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	void exhibit(String message) throws RemoteException;
}
