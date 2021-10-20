import java.rmi.*;

/* Remote interface responsável por definir métodos implementados. O fato de haver relação de herança com a classe Remote declara que há metodos adicionais não explicitos nessa classe. */

public interface InterfaceServidorMat extends Remote
{
    public double distancia(double x1, double y1, double x2, double y2) throws RemoteException;
    //Este método recebe 4 parametros referentes aos pontos A(x1,y1) e B(x2,y2)
}