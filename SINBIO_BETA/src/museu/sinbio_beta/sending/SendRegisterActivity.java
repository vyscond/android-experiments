
package museu.sinbio_beta.sending;

import java.io.IOException;
import java.util.ArrayList;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.R;
import museu.sinbio_beta.common.composite.GenericAdapter;
import museu.sinbio_beta.common.composite.GenericItemList;
import museu.sinbio_beta.common.connection.ConnectTask;
import museu.sinbio_beta.common.filesystem.SdcardManager;
import museu.sinbio_beta.sending.socket.MailMan;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SendRegisterActivity extends Activity
{
    
    private ListView       availableRegisters;
    
    private SdcardManager  sdcardManager;
    
    private GenericAdapter adapter;
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_send_register );
        
        this.sdcardManager = new SdcardManager ( );
        
        this.availableRegisters = (ListView) findViewById ( R.id.listView_sendregister_availables );
        
        this.adapter = new GenericAdapter ( this , this.generateRegisterItemArray ( ) );
        
        this.availableRegisters.setAdapter ( this.adapter );
        
        this.availableRegisters.setOnItemClickListener (

        new OnItemClickListener ( )
            {
                
                public void onItemClick ( AdapterView < ? > arg0 , View arg1 , int arg2 , long arg3 )
                {
                    // TODO Auto-generated method stub
                    selectingRegister ( arg0 , arg1 , arg2 , arg3 );
                }
            }

       );
        
    }
    
    protected void selectingRegister ( AdapterView < ? > arg0 , View arg1 , int arg2 , long arg3 )
    {
        // TODO Auto-generated method stub
        
        try
        {
            //Toast.makeText ( this , "["+arg2+"]" , Toast.LENGTH_SHORT ).show ( );
            
            RegisterItem regItem = ((RegisterItem) arg0.getItemAtPosition ( arg2 ));
            
            //Toast.makeText ( this , "Zipping["+regItem.getRegisterPath ( )+"]" , Toast.LENGTH_SHORT ).show ( );
            
            String folderPathToZip = regItem.getRegisterPath ( );
            
            String zipPathWithName = regItem.getRegisterPath ( )+".zip";
            
            this.sdcardManager.zipDirectory ( folderPathToZip , zipPathWithName );
            
            this.sendZip ( zipPathWithName );
            
        }catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
    /*---------------------------------------------------------------------
     * 
     *                              THE WEBZTER
     * 
     *---------------------------------------------------------------------*/
    
    
    
    public void sendZip( String fileName  )
    {
        String ip = "192.168.43.104";
        
        String port = "666";
        ConnectTask conn  = new ConnectTask ( );
        
        Toast.makeText ( this , "Sending : ["+fileName+"]" , Toast.LENGTH_LONG ).show();
        
        conn.execute ( fileName , ip , port);
        
        conn.sthap ( );
        
        Toast.makeText ( this , "Done" , Toast.LENGTH_LONG ).show();
        
    }
    
    /*---------------------------------------------------------------------
     * 
     *                              ZIPANDO
     * 
     *---------------------------------------------------------------------*/
    
    private void zipFolder( String folderPath , String zipPath )
    {
        
        try
        {
            this.sdcardManager.zipDirectory ( folderPath , zipPath );
        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private ArrayList < GenericItemList > generateRegisterItemArray ( )
    {
        ArrayList < GenericItemList > items = new ArrayList < GenericItemList > ( );
        
        ArrayList < String > foldersName = this.sdcardManager.toArrayListFolders ( "SINBIO" );
        
        for ( String name : foldersName )
        {
            this.echo ( "Adding >> " + this.sdcardManager.getBasePath ( ) + "/" + "SINBIO" + "/" + name );
            
            items.add ( new RegisterItem ( R.layout.pojo_register_item , name , this.sdcardManager.getBasePath ( ) + "/" + "SINBIO" + "/" + name ) );
        }
        
        return items;
    }
    
    private void echo ( String string )
    {
        // TODO Auto-generated method stub
        Log.d ( MenuActivity.__FLAG__ , "SendRegister : " + string );
    }

    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_send_register , menu );
        return true;
    }
    
    private class RegisterItem extends GenericItemList
    {
        
        private long   id;
        
        private int    layout;
        
        private String registerName;
        
        private String registerPath;
        
        public RegisterItem ( int layout , String registerName , String registerPath )
        {
            super ( );
            this.layout = layout;
            this.registerName = registerName;
            this.registerPath = registerPath;
        }
        
        @ SuppressWarnings ( "unused" )
        public String getRegisterName ( )
        {
            return registerName;
        }
        
        @ SuppressWarnings ( "unused" )
        public void setRegisterName ( String registerName )
        {
            this.registerName = registerName;
        }
        
        public String getRegisterPath ( )
        {
            return registerPath;
        }
        
        @ SuppressWarnings ( "unused" )
        public void setRegisterPath ( String registerPath )
        {
            this.registerPath = registerPath;
        }
        
        @ Override
        public View initializeWidgets ( View v )
        {
            // TODO Auto-generated method stub
            
            ( (TextView) v.findViewById ( R.id.textView_pojo_register_item_name ) ).setText ( this.registerName );
            return v;
        }
        
        @ Override
        public int getLayout ( )
        {
            // TODO Auto-generated method stub
            return this.layout;
        }
        
        @ Override
        public void setLayout ( int layout_id )
        {
            // TODO Auto-generated method stub
            this.layout = layout_id;
        }
        
        @ Override
        public long getId ( )
        {
            // TODO Auto-generated method stub
            return this.id;
        }
        
        @ Override
        public void setId ( long id )
        {
            // TODO Auto-generated method stub
            this.id = id;
        }
        
    }
}
