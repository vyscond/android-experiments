package museu.sinbio_beta.common.xml.manager;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.common.filesystem.SdcardManager;
import museu.sinbio_beta.common.xml.pojo.RegisterXml;
import android.util.Log;


public class XmlManager
{
    
    private SdcardManager sdcardManager;
    private String class_in = "XmlManager : ";
    
    public XmlManager()
    {
        sdcardManager = new SdcardManager ( );
    }
    
    public RegisterXml getXml(String fileName , String extension , String absolutePath)
    {
        
        RegisterXml reg = new RegisterXml ( this.sdcardManager.getFileAsString ( fileName , extension , absolutePath ) );
        
        return reg;
    }
    
    public void saveXml( RegisterXml reg )
    {
        String content =reg.getXmlAsString ( );
        
        // --- gerando .dreg
        
        String dregName = reg.getFileName ( );
        String dregExtension = "dreg";
        String dregContent = "";
        
        dregContent += "id_amostra = " + reg.getIdAmostra ( ) + "; \n"+
                       "data = " + reg.getData ( )+"; \n"+
                       "hora = " + reg.getHora ( )+ ";";
        
        this.sdcardManager.saveAs( reg.getFileName ( ) , content     , "reg"         , reg.getFoldePath ( ) );
        
        this.sdcardManager.saveAs( dregName            , dregContent , dregExtension , reg.getFoldePath ( ) );
    }

    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , class_in  + msg );
    }
    
    public String getDreg ( String fileName , String absolutePath )
    {
        this.echo ( "Bitch try to reached dreg at ["+ absolutePath+fileName+".dreg" +"]");
        return this.sdcardManager.getFileAsString ( fileName , "dreg" , absolutePath );
    }
    
    
}
