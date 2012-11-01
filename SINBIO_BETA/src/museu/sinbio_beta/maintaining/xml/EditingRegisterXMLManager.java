package museu.sinbio_beta.maintaining.xml;

import android.util.Log;
import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.common.xml.manager.XmlManager;
import museu.sinbio_beta.common.xml.pojo.RegisterXml;


public class EditingRegisterXMLManager
{
    private String class_in = "EditingRegisterXMLManager";
    
    private XmlManager xmlManager;
    
    public EditingRegisterXMLManager ( )
    {
        this.xmlManager = new XmlManager ( );
    }
    
    public String getDreg( String fileName , String absolutePath )
    {
        
        this.echo ( "Calling xmlManager for getDreg :D" );
        
        return this.xmlManager.getDreg( fileName , absolutePath );
    }
    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , class_in + msg );
    }
    
    public RegisterXml getRegisterXml( String fileName , String absolutePath )
    {
        return this.xmlManager.getXml ( fileName, "dreg" , absolutePath );
    }
    
    public void saveNewXml ( RegisterXml reg )
    {
        this.xmlManager.saveXml ( reg );
    }

  
 
    
    
}
