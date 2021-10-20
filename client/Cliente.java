import java.rmi.*;
import java.util.Scanner;

/* classe cliente, executada no lado cliente do servidor. */

public class Cliente
{
	public Cliente()
	{
		System.out.println("Executando Cliente... \n");

		try
		{
			msi = (InterfaceServidorMat) Naming.lookup("rmi://rmi-server:1099/servidormat1"); // Este método lookup procura pelo objeto remoto (stub) usando o nome definido, no caso "servidormat1". O endereço rmi-server é explicado separadamente, junto com a descrição do ambiente
		}
		catch (Exception e)
		{
			System.out.println("Falhou a execucao do Cliente.\n"+e);
			System.out.println("Certifique se a aplicacao no servidor esta em execucao.\n");
			System.exit(0);
		}
	}

	public static void main (String[] argv)
	{
		//Se o método lookup encontra o objeto remoto através da conexão feita pelo método cliente, é possível invocar os métodos presentes no objeto instanciado na classe ArrancaServidor, no caso ServidorMat.

		//instancia classe
		Cliente c = new Cliente();

		//recupera dados do usuário
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Entre com valores de x1 e y1 separados por espaco:");
		double x1 = keyboard.nextDouble();
		double y1 = keyboard.nextDouble();

		System.out.println("Entre com valores de x2 e y2 separados por espaco:");
		double x2 = keyboard.nextDouble();
		double y2 = keyboard.nextDouble();

		System.out.println("");

		//realizada chamada do método do servidor
		try
		{
			System.out.println("Distancia entre os dois pontos: " + c.distancia(x1,y1,x2,y2));
		}
		catch (Exception e)
		{
			System.out.println("Excecao durante chamadas remotas:" +e);
		}
	}

	//definições de interface do lado cliente, para compatibilidade de chamada com lado servidor (esse conceito foi análise própria, não tenho 100% de certeza)
	private InterfaceServidorMat msi;

	public double distancia(double x1, double y1, double x2, double y2) throws RemoteException{
		 return msi.distancia(x1,y1,x2,y2);
	}
}