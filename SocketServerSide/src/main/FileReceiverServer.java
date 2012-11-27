package main;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiverServer implements Runnable {

	@Override
	public void run() {

		try {

			int bytesRead;
			int current = 0;
			
			InetAddress addr = InetAddress.getLocalHost();  
			
			System.out.println (addr.toString ( ));
			
			ServerSocket serverSocket = null;
			serverSocket = new ServerSocket ( 666 , 0 , addr );

			
				Socket clientSocket = null;
				System.out.println("Waiting for connection at : "+serverSocket.getInetAddress ( ).toString ( )+":"+serverSocket.getLocalPort ( ));
				clientSocket = serverSocket.accept();
				System.out.println("We have a client here");
				InputStream in = clientSocket.getInputStream();

				in = new DataInputStream(in);

				String fileName = ((DataInputStream) in).readUTF();
				
				System.out.println("Filename : "+fileName);
				
				OutputStream output = new FileOutputStream(fileName);
				
				long size = ((DataInputStream) in).readLong();
				
				System.out.println("Tamanho : "+size);
				
				while (true) {
				byte[] buffer = new byte[1024];
				while (size > 0
						&& (bytesRead = in.read(buffer, 0,
								(int) Math.min(buffer.length, size))) != -1) {
					output.write(buffer, 0, bytesRead);
					
					size -= bytesRead;
				}
				System.out.println("Received");
				// Writing the file to disk
				// Instantiating a new output stream object
				/*
				 * OutputStream output = new FileOutputStream("E7060v1.2.zip");
				 * 
				 * byte[] buffer = new byte[1024]; while ((bytesRead =
				 * in.read(buffer)) != -1) { output.write(buffer, 0, bytesRead);
				 * }
				 */
				// Closing the FileOutputStream handle
				
				output.close();
				clientSocket.close();
				serverSocket.close();
				System.exit(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
