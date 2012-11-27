package museu.sinbio_beta.common.connection;

import museu.sinbio_beta.MenuActivity;
import android.os.AsyncTask;
import android.util.Log;



public class ConnectTask extends AsyncTask<String,String,Connection> {
    
    

    private Connection myConn;

    public void sthap()
    {
        myConn.stopClient ( );
    }
    
    @Override
    protected Connection doInBackground(String... args) {

//        
//        //we create a TCPClient object and
//        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "Creating connection" );
//        myConn = new Connection( args[0] , Integer.parseInt ( args[1] ) , 
//                
//                new Connection.OnMessageReceived() {
//                    
//                    public void messageReceived(String message) {
//                    
//                        //this method calls the onProgressUpdate
//                        publishProgress(message);
//                    }
//                }
//        );
//        myConn.fileName = args[2];
//        myConn.run();
//        
//        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "connect is out!" );


        //we create a TCPClient object and
        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "Creating connection" );
        myConn = new Connection();
        
        String fileName = args[0];
        
        String destinationIP = args[1];
        
        int port = Integer.parseInt ( args[2] );
        
        Log.d ( MenuActivity.__FLAG__ , "Status connection : IP<"+destinationIP+"> Port<"+port+">"  );
        
        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "Try sending file" );
        
        myConn.sendZip ( fileName , destinationIP , port );
        
        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "connect is out!" );
        
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        
        Log.d ( MenuActivity.__FLAG__ , "ConnectTask : " + "onProgressUpdate was called" );
        
        super.onProgressUpdate(values);

        
    }
}