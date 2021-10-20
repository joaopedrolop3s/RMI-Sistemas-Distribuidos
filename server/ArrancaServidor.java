import java.rmi.*;
import java.net.*;
import java.rmi.registry.Registry;

/* classe responsável pela conexão, está classe é executada com comando java para inicar o servidor */

public class ArrancaServidor
{
    public static void main(String argv[])
    {
        try
        {
			System.out.println("Subindo servidor...");

			InetAddress IP = InetAddress.getLocalHost();
            /* Este valor recupera o ip da maquina na rede. Este valor foi impresso abaixo e aparece no terminal */

            System.out.println(IP.getHostAddress());

            System.setProperty("java.rmi.server.hostname", IP.getHostAddress()); //seta o ip recuperado para o hostname do RMI

			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099); //define a porta de acesso para a conexão com o cliente

            InterfaceServidorMat stub = new ServidorMat(); // intancia um novo objeto do tipo servidorMAr, responsável pela implementação dos métodos da interface

            Naming.rebind("rmi://rmi-server:1099/servidormat1", stub); //o rebind não funcionou com apenas com o nome "servidormat1", foi necessário informar endereço completo. O endereço de maquina rmi-server será explicado seradamente junto com a explicação do ambiente.
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema no arranque do servidor.\n"+e.toString());
        }
    }
}