package main;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileSender {

	public void sendingFile(String fileName, String destinationIP, int port) {

		// create socket

		try {

			System.out.println("Waiting...");

			Socket sock = new Socket(destinationIP, port);

			System.out.println("Accepted connection : " + sock);

			OutputStream os = sock.getOutputStream();

			DataOutputStream dos = new DataOutputStream(os);

			// sendfile
			File myFile = new File(fileName);

			if (myFile.exists()) {
				System.out.println("Sin");
			}

			byte[] mybytearray = new byte[(int) myFile.length()];

			System.out.println("Sending filename!");
			dos.writeUTF(fileName);

			System.out.println("Sending size!");
			System.out.println(myFile.length());
			dos.writeLong(mybytearray.length);

			FileInputStream fis = new FileInputStream(myFile);

			BufferedInputStream bis = new BufferedInputStream(fis);

			bis.read(mybytearray, 0, mybytearray.length);

			System.out.println("Sending...");

			os.write(mybytearray, 0, mybytearray.length);

			System.out.println("Done");

			os.flush();

			sock.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
