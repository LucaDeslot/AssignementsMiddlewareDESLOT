package client;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.*;

public class Client {
	public static void main(String args[]) {
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
		try {
			// vyhledani vzdaleneho objektu
			EchoServer echo;
			String name = "Echo";
			//String name = "MathD2";
			Registry registry = LocateRegistry.getRegistry("localhost", 2210);//localhost    , 147.32.82.231
			echo = (EchoServer) registry.lookup(name);

			// vypis vysledku
			System.out.println("Echo server response with message: " + echo.echo("hello world"));
		}
		catch (Exception e) {
			// neco je spatne :(
			System.err.println("Data exception: " + e.getMessage());
		}
	}
}