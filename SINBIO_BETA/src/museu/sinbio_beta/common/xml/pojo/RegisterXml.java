
package museu.sinbio_beta.common.xml.pojo;

import museu.sinbio_beta.MenuActivity;
import android.util.Log;

public class RegisterXml
{
    
    private String idAmostra , data , hora , fileName , foldePath;
    
    private String xml;
    
    public RegisterXml ( String idAmostra , String data , String hora , String fileName , String foldePath )
    {
        super ( );
        this.idAmostra = idAmostra;
        this.data = data;
        this.hora = hora;
        this.fileName = fileName;
        this.foldePath = foldePath;
        
        this.xml = "<registro>" + "\n" +
                    "<id_amostra>" + this.idAmostra + "</id_amostra>" + "\n" +
                    "<data>" + this.data + "</data>" + "\n" +
                    "<hora>" + this.hora + "</hora>" + "\n" +
                    "</registro>";
        
    }
    
    private String class_in = "RegisterXml";
    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , "CreateReg : " + msg );
    }
    
    public RegisterXml ( String dregContent )
    {
        
        
        super ( );
        
        this.echo ( "Build pojo with dreg file" );
        
        for ( String line : dregContent.split ( ";" ) )
        {
            
            if(line == null || line.equals ( "" ) || line.equals ( "\n" ) )
            {
                this.echo ( "Void line ;*" );
                
                break;
            }
            
            this.echo ( "Parsing line : " + line );
            
            String[] id_and_value = line.split ( "=" );
            
            String dregId = id_and_value[0].replaceAll ( "\n" , "" ).replaceAll ( " " , "" );
            String dregValue = id_and_value[1].replaceAll ( "\n" , "" ).replaceAll ( " " , "" );
            
            this.echo("ID : ["+dregId+"]");
            
            this.echo("Value : ["+dregValue+"]");
            
            
            
            if( dregId.equals ( "id_amostra" ) )
            {
                this.idAmostra = dregValue;
            }
            
            else if ( dregId.equals ( "data" ) )
            {
                this.data = dregValue;
            }
            
            else if ( dregId.equals ( "hora" ) )
            {
                this.hora = dregValue;
            }
            
        }
        
        this.echo ( "Pojo builded:\n"+
                
                this.idAmostra +"\n"+
                this.data+"\n"+
                this.hora+"\n"
        );
        
    }
    
    public String getXmlAsString ( )
    {
        return this.xml;
    }
    
    public String getIdAmostra ( )
    {
        return idAmostra;
    }
    
    public void setIdAmostra ( String idAmostra )
    {
        this.idAmostra = idAmostra;
    }
    
    public String getData ( )
    {
        return data;
    }
    
    public void setData ( String data )
    {
        this.data = data;
    }
    
    public String getHora ( )
    {
        return hora;
    }
    
    public void setHora ( String hora )
    {
        this.hora = hora;
    }
    
    public String getFileName ( )
    {
        return fileName;
    }
    
    public void setFileName ( String fileName )
    {
        this.fileName = fileName;
    }
    
    public String getFoldePath ( )
    {
        return foldePath;
    }
    
    public void setFoldePath ( String foldePath )
    {
        this.foldePath = foldePath;
    }
    
}
