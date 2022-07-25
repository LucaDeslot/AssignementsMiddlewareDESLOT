package server;

import java.rmi.*;

import compute.*;

public class EchoServerImpl implements EchoServer {
	
	// pro potrebu serializace (marshalingu)
	private static final long serialVersionUID = -1937161867341487386L;

	public EchoServerImpl() throws RemoteException {
		super();
		}
    
	public String echo() throws RemoteException {
		return "echo";
	}
  
  public String echo(String message) throws RemoteException {
		return "echo with message: " + message;
	}
	
}