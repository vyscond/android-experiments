
package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider
{
    
    ServerSocket       providerSocket;
    
    Socket             connection = null;
    
    ObjectOutputStream out;
    
    ObjectInputStream  in;
    
    String             message;
    
    void run ( )
    {
        try
        {
            // 1. creating a server socket
            
            InetAddress bindAddr = InetAddress.getByName ( "189.82.168.73" );//
//            
            providerSocket = new ServerSocket ( 2004 , 10 , bindAddr );
//            providerSocket = new ServerSocket ( 2004 , 10 );
            // 2. Wait for connection
            System.out.println (providerSocket.getInetAddress ( ));
            System.out.println (providerSocket.getLocalSocketAddress ( ));
            System.out.println ( "Waiting for connection" );
            connection = providerSocket.accept ( );
            System.out.println ( "Connection received from " + connection.getInetAddress ( ).getHostName ( ) );
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            System.out.println ("xD");
        }
    }
}