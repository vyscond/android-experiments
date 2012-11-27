package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;

public class TCPServer extends Thread {
    
    public static final int SERVERPORT = 2000;
    private boolean running = false;
    private PrintWriter mOut;
    private OnMessageReceived messageListener;
 
    public static void main(String[] args) {
 
        //opens the window where the messages will be received and sent
        ServerBoard frame = new ServerBoard();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
 
    }
 
    
    
    /**
     * Constructor of the class
     * @param messageListener listens for the messages
     */
    public TCPServer(OnMessageReceived messageListener) {
        this.messageListener = messageListener;
    }
 
 
    /**
     * Method to send the messages from server to client
     * @param message the message sent by the server
     */
    public void sendMessage(String message){
        if (mOut != null && !mOut.checkError()) {
            mOut.println(message);
            mOut.flush();
        }
    }
    ServerSocket serverSocket ;
    
    public String getIP()
    {
        return this.serverSocket.getInetAddress ( ).getHostAddress ( );
    }
    
    public int getPort()
    {
        return SERVERPORT;
    }
    
    @Override
    public void run() {
        super.run();
 
        running = true;
 
        try {
            System.out.println("Server : try to connecting");
 
            
            
            //create a server socket. A server socket waits for requests to come in over the network.
            serverSocket = new ServerSocket ( SERVERPORT , 10 , InetAddress.getByName ( "192.168.0.142" ) );
            System.out.println (this.getIP ( ));
            System.out.println (this.getPort ( ));
            //create client socket... the method accept() listens for a connection to be made to this socket and accepts it.
            Socket client = serverSocket.accept();
            System.out.println("Server : Preparing for receiving");
 
            try {
 
                //sends the message to the client
                mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
 
                //read the message received from client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
 
                //in this while we wait to receive messages from client (it's an infinite loop)
                //this while it's like a listener for messages
                while (running) {
 
                    
                    FileOutputStream fileStream=new FileOutputStream("Download.zip");
                    ZipOutputStream zip=new ZipOutputStream(fileStream);
                    //zip.putNextEntry(new ZipEntry("1.zip"));
                    byte[] buffer=new byte[1024];
                    int readByte;
                    while((readByte=in.read())>0){
                        System.out.println(readByte);
                        zip.write(buffer,0,readByte);
                        
                    }
                    fileStream.close();
                    
                }
                
                System.out.println ("Server : file saved as Download.zip");
 
            } catch (Exception e) {
                System.out.println("S: Error");
                e.printStackTrace();
            } finally {
                client.close();
                System.out.println("S: Done.");
            }
 
        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }
 
    }
 
 
    //Declare the interface. The method messageReceived(String message) will must be implemented in the ServerBoard
    //class at on startServer button click
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }
 
}