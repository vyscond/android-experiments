package museu.sinbio_beta.sending.socket;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import museu.sinbio_beta.MenuActivity;
import android.util.Log;


public class MailMan
{
    private String IP;
    
    private int PORT;
    
    private Socket socket;
    
    private OutputStream outputStream;
    
    private InputStream inputStream;

    
    

    public void sendingFile(String fileName, String destinationIP, int port) {

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
                System.out.println("File exist :D");
            }

            /* --- Sync --- */
            
            byte[] mybytearray = new byte[(int) myFile.length()];

            this.echo ( "Talking with server : Sending file name -> "+fileName );
            
            dos.writeUTF(fileName);

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
    
    
    
    public String getIP ( )
    {
        return IP;
    }

    
    public void setIP ( String iP )
    {
        IP = iP;
    }

    
    public int getPORT ( )
    {
        return PORT;
    }

    
    public void setPORT ( int PORT )
    {
        this.PORT = PORT;
    }

    public void setUpConnection()
    {
        
        this.echo ( "setUpConnection" );
        
        try
        {
            InetAddress serverAddr = InetAddress.getByName(this.IP);
            
            this.echo ( serverAddr.getHostAddress ( ) +"");
            
            this.socket = new Socket ( serverAddr, this.PORT );
            
            this.echo ( "Connected?" );
            
            outputStream = this.socket.getOutputStream ( );
            
            outputStream.flush();
            
            inputStream = this.socket.getInputStream ( );
            
            
            
        }
        catch ( UnknownHostException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            this.echo("UnknownHost");
            
        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            this.echo("IO wong wong");
        }
        
        this.echo ( "End setup" );
    }
    
    private void echo ( String string )
    {
        // TODO Auto-generated method stub
        Log.d ( MenuActivity.__FLAG__ , "MailMan : " + string );
    }


    public void sendShitForAnotherPC()
    {
        
        
        
        this.setUpConnection ( );
        
        this.echo ( "Connection workin" );
    }
}
