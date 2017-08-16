package cliente;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class Cliente {
	
	public void iniciar(){
		
	Socket cliente;
	try {
		cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor");
		Scanner s = new Scanner(System.in);
		
		PrintStream saida = new  PrintStream(cliente.getOutputStream());
		
		while(s.hasNextLine()){
			saida.println(s.nextLine());
			}
			saida.close();
			s.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
}