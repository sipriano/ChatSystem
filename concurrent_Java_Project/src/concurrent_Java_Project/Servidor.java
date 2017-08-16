package concurrent_Java_Project;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
public class Servidor extends Thread {
	
	ServerSocket servidor = null;
	
	public void iniciar(){
	
	try{
		servidor = new ServerSocket(12345);
		System.out.println("Abrindo conex�o");
		Socket cliente = servidor.accept();
		System.out.println("Nova conex�o com o cliente "+ cliente.getInetAddress().getHostAddress());
		
		Scanner s = new Scanner(cliente.getInputStream());
		while(s.hasNextLine()){
			System.out.println(s.nextLine());
		}
	}
	catch(IOException e){
		e.printStackTrace();
		
	}
	finally{
		try{
			servidor.close();
			System.out.println("Fechando conex�o");
		}
		catch(IOException e){
			e.printStackTrace();
			
			}
		}
	}
}