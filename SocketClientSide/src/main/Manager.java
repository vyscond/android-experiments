package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Manager {
	
	public static void main(String[] args){
		//SmtpClient smtpClient =  new SmtpClient();
		
		//smtpClient.testConnection();
		
		FileSender fileSender = new FileSender();
		
		fileSender.sendingFile("misc.zip" , "192.168.43.104" , 666);
		
		//192.168.43.104
		
		
	}
	
	
	
	
	public void Stuff(){
		
		String serverName = "0.0.0.0";
		
		int portNumber = 666;
		
		Socket MyClient = null;
	    try {
	           MyClient = new Socket( serverName, portNumber);
	    }
	    catch (IOException e) {
	        System.out.println(e);
	    }
	    
	    // --- Receiving ---------------------------------------------------
	    
	    DataInputStream input = null;
	    try {
	       input = new DataInputStream(MyClient.getInputStream());
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }

	    // --- Sending ---------------------------------------------------
	    
	    PrintStream output = null;
	    try {
	       output = new PrintStream(MyClient.getOutputStream());
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    
	    DataOutputStream output2;
	    try {
	       output2 = new DataOutputStream(MyClient.getOutputStream());
	    }
	    catch (IOException e) {
	       System.out.println(e);
	    }
	    
	    // --- closing -------------------------------------------------
	    try {
	           output.close();
	           input.close();
	       MyClient.close();
	    } 
	    catch (IOException e) {
	       System.out.println(e);
	    }
	}
	

}
