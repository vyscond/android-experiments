
package museu.sinbio_beta.common.connection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.zip.ZipInputStream;

import museu.sinbio_beta.MenuActivity;

import android.util.Log;

public class Connection
{
    
    private String            serverMessage;
    
    private String            serverIP         = "192.168.43.104"; // your computer IP address
                                                                   
    private int               serverPort       = 4444;
    
    private OnMessageReceived mMessageListener = null;
    
    private boolean           mRun             = false;
    
    private PrintWriter       out;
    
    private BufferedReader    in;
    
    /**
     * Constructor of the class. OnMessagedReceived listens for the messages received from server
     */
    
    public Connection ( OnMessageReceived listener )
    {
        mMessageListener = listener;
    }
    
    public Connection (  )
    {
        
    }
    
    public Connection ( String serverIP , int serverPort , OnMessageReceived listener )
    {
        
        this.serverIP = serverIP;
        
        this.serverPort = serverPort;
        
        mMessageListener = listener;
        
    }
    
    public void sendZip (String fileName , String destinationIP , int port )
    {
        
     // create socket

        try {

            /* establishing connection */
            
            this.echo("Trying to reach HOST : "+destinationIP+"@"+port);

            Socket sock = new Socket(destinationIP, port);
            
            this.echo ( "Connection was accepted" );
            
            this.echo ( "Build OutputStreamer" );
            
            /* Build Streams */
            
            OutputStream os = sock.getOutputStream();
            
            this.echo ( "Build DataOutputStreamer" );
            
            DataOutputStream dos = new DataOutputStream(os);

            this.echo("Loading .zip File :D");
            
            // sendfile
            File myFile = new File(fileName);

            if (myFile.exists()) {
                this.echo("File exist :D");
            }

            /* --- Sync --- */
            
            byte[] mybytearray = new byte[(int) myFile.length()];

            this.echo ( "Talking with server : Sending file name -> "+myFile.getName ( ) );
            
            dos.writeUTF(myFile.getName ( ));

            this.echo ( "Talking with server : Sending file size -> "+myFile.length ( ) );
            
            dos.writeLong(mybytearray.length);

            this.echo("Building file writers");
            
            FileInputStream fis = new FileInputStream(myFile);

            BufferedInputStream bis = new BufferedInputStream(fis);

            bis.read(mybytearray, 0, mybytearray.length);

            this.echo(">> Sending File <<");
            
            os.write(mybytearray, 0, mybytearray.length);

            System.out.println(">> done <<");

            os.flush();

            sock.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    private void echo ( String string )
    {
        // TODO Auto-generated method stub
        Log.d ( MenuActivity.__FLAG__ , "MailMan : " + string );
    }
    
    /**
     * Sends the message entered by client to the server
     * 
     * @param message
     *            text entered by client
     */
    public void sendMessage ( String message )
    {
        
        Log.d ( MenuActivity.__FLAG__ , class_in + "SendMessage was invoked" );
        
        if ( out != null && ! out.checkError ( ) )
        {
            out.println ( message );
            out.flush ( );
        }
    }
    
    public void stopClient ( )
    {
        mRun = false;
    }
    
    String fileName = "";    
    public void run ( )
    {
        
        mRun = true;
        
        try
        {
            // here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName ( serverIP );
            
            Log.d ( MenuActivity.__FLAG__ , class_in + "C: Connecting..." );
            
            // create a socket to make the connection with the server
            Socket socket = new Socket ( serverAddr , serverPort );
            
            try
            {
                
                // send the message to the server
                out = new PrintWriter ( new BufferedWriter ( new OutputStreamWriter ( socket.getOutputStream ( ) ) ) , true );
                
                Log.d ( MenuActivity.__FLAG__ , class_in + "C: Sent." );
                
                Log.d ( MenuActivity.__FLAG__ , class_in + "C: Done." );
                
                // receive the message which the server sends back
                in = new BufferedReader ( new InputStreamReader ( socket.getInputStream ( ) ) );
                
                // in this while the client listens for the messages sent by the server
                // while (mRun) {
                // serverMessage = in.readLine();
                //
                // if (serverMessage != null && mMessageListener != null) {
                // //call the method messageReceived from MyActivity class
                // mMessageListener.messageReceived(serverMessage);
                // }
                // serverMessage = null;
                //
                // }
                
//                File file=new File(fileName);
//                
//                FileInputStream fileStream = new FileInputStream(file);
//                
//                ZipInputStream zis=new ZipInputStream(new BufferedInputStream(fileStream));
//                
//                
//                byte[] buffer=new byte[1024];
//                
//                int readByte;
//                
//                while((readByte=fileStream.read())>0){
//                
//                    out.write(readByte);
//                }
                
                Log.d ( MenuActivity.__FLAG__ , class_in +  "Sending success");
//                fileStream.close();
                
                
                
                
            }
            catch ( Exception e )
            {
                
                Log.d ( MenuActivity.__FLAG__ , class_in + "S: Error" );
                
            }
            finally
            {
                // the socket must be closed. It is not possible to reconnect to this socket
                // after it is closed, which means a new socket instance has to be created.
                socket.close ( );
            }
            
        }
        catch ( Exception e )
        {
            
            Log.d ( MenuActivity.__FLAG__ , class_in + "C: Error" );
            
        }
        
    }
    
    String class_in = "TCPClient : ";
    
    // Declare the interface. The method messageReceived(String message) will must be implemented in the MyActivity
    // class at on asynckTask doInBackground
    public interface OnMessageReceived
    {
        
        public void messageReceived ( String message );
    }
}