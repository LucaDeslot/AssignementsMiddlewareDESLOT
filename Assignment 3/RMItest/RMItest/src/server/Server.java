package server;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.*;

public class Server {
	
	public static void main(String[] args) {
		// vytvorime security managera
		// konfigurace je specifikovana bud pomoci -Djava.security.policy=file.policy
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		// jmeno nasi sluzby
		String name = "Echo";
		
		try {
			// vytvoreni samotneho objektu a jeho stubu
			EchoServer msi = new EchoServerImpl();
			
			EchoServer stub =
                (EchoServer) UnicastRemoteObject.exportObject(msi, 5000); //server + port
			//MathServer msi2 = new MathServerImpl2();
			
			// zaregistrovani jmena u objektu 
			Registry registry = LocateRegistry.createRegistry(2210);
			registry.rebind(name, stub);
			//registry.rebind(name2, msi2);
			//vytvorim DB
		}
		catch (Exception e) {
			//neco je spatne :(
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}