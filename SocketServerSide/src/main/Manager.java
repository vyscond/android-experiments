package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Manager {

	public static void main(String[] args){
		//SmtpServer  smtpServer = new SmtpServer();
		
		//smtpServer.runServer();
		
		
		
		(new Thread( new FileReceiverServer() ) ).start();
	}
	
	
	public void Suff(){
		int portNumber = 666;
		
		ServerSocket MyService = null;
		
		try {
			
			MyService = new ServerSocket(portNumber);
			
		} catch (IOException e) {
			
			System.out.println(e);
			
		}
		
		Socket serviceSocket = null;
	    
		try {
	    
			serviceSocket = MyService.accept();
	    
		}
	    catch (IOException e) {
	       System.out.println(e);
	    }
		
		// -------------------------
		
		DataInputStream input = null;
	    try {
	       input = new DataInputStream(serviceSocket.getInputStream());
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    
	    // --- sending ------------------------------------------------------
	    
	    PrintStream output = null;
	    try {
	       output = new PrintStream(serviceSocket.getOutputStream());
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    
	    // --- closing --------------------------------------------
	    
	    try {
	        output.close();
	        input.close();
	        serviceSocket.close();
	        MyService.close();
	     } 
	     catch (IOException e) {
	        System.out.println(e);
	     }

	}

}
