package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.sun.corba.se.spi.extension.ZeroPortPolicy;

public interface EchoServer extends Remote {
    public String echo() throws RemoteException;
    public String echo(String message) throws RemoteException;
}