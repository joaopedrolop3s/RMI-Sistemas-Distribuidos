import java.rmi.*;

public interface InterfaceServidorMat extends Remote
{
    public double distancia(double x1, double y1, double x2, double y2) throws RemoteException;
}