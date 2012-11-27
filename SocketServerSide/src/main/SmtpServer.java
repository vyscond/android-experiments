package main;

import java.io.*;
import java.net.*;

public class SmtpServer {
	public void runServer() {
		// declaration section:
		// declare a server socket and a client socket for the server
		// declare an input and an output stream
		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;
		// Try to open a server socket on port 9999
		// Note that we can't choose a port less than 1023 if we are not
		// privileged users (root)
		try {
			echoServer = new ServerSocket(666);
		} catch (IOException e) {
			System.out.println(e);
		}
		// Create a socket object from the ServerSocket to listen and accept
		// connections.
		// Open input and output streams
		try {
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			// As long as we receive data, echo that data back to the client.
			while (true) {
				line = is.readLine();
				if(line.equals("quit"))
				{
					break;
				}
				System.out.println("On Server Side (Receiving) : "+line);
				os.println(line);
			}
			os.close();
			is.close();
			clientSocket.close();
			echoServer.close();
			
			System.out.println("Its over dude!!!");
			
			System.exit(0);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
	}
}