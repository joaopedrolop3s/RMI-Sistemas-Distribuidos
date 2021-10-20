import java.rmi.*;
import java.rmi.server.*;

/* Esta classe é a implementação da interface criada (interfaceservidormat). Ne
Nesta parte é preciso extender a clsse UnicastRemoteObject ou usar o método exportObject() da classe UnicastRemoteObject. */
    {
        System.out.println("Novo Servidor instanciado...");
        /* mensagem exibida do lado do servidor, quando a conexão é realizada com sucesso e o objeto é instanciado. */
    }
    public double distancia(double x1, double y1, double x2, double y2) throws RemoteException
    {
        //método responsável pelo calculo dos valores informados pelo cliente
        System.out.println("Valores recebidos do cliente: \n ponto1 = " + x1 + ", " + y1 + "\n ponto2 = " + x2 + ", " + y2 );
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}