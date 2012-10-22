
package museu.goeldi.mobile.cadastro.java_metadata_object.base;

import java.lang.reflect.Field;

import museu.goeldi.mobile.util.StupidXML;
import museu.goeldi.mobile.util.StupidXML.Tag;
import android.util.Log;

public class RegistroAmostra implements Metadonnee
{
    
    private String id_da_amostra_dado_pelo_coletor;
    
    private String expedicao;
    
    private String projeto;
    
    private String protocolo;
    
    private String atrativo;
    
    private String data_da_coleta;
    
    private String hora_da_coleta;
    
    public String getLangageDeBalisageExtensible ( )
    {
        
        StupidXML xml_manager = new StupidXML ( );
        
        Log.d ( "SaveXML" , "generating XML String" );
        
        Log.d ( "SaveXML" , "Criando root node" );
        
        Tag root = xml_manager.getNewTag ( );
        
        root.setTagName ( "amostra" );
        
        Log.d ( "SaveXML" , "Root node criado" );
        
        Log.d ( "SaveXML" , "Procurando os atributos de classe" );
        
        for ( Field f : this.getClass ( ).getDeclaredFields ( ) )
        {
            
            String field_name = f.getName ( );
            
            Log.d ( "SaveXML" , "Class Attribute : " + field_name );
            
            Tag t = xml_manager.getNewTag ( );
            
            t.setTagName ( field_name );
            
            String field_value = "vazio";
            
            try
            {
                
                Log.d ( "SaveXML" , "Trying : reach value on the attribute!" );
                
                RegistroAmostra a = new RegistroAmostra ( );
                
                Object o = f.get ( this );
                
                field_value = String.valueOf ( o );
                
            }
            catch ( IllegalArgumentException e1 )
            {
                // TODO Auto-generated catch block
                Log.d ( "SaveXML" , "Something is wrong dude!! @_@" );
                e1.printStackTrace ( );
            }
            catch ( IllegalAccessException e1 )
            {
                // TODO Auto-generated catch block
                Log.d ( "SaveXML" , "Something is wrong dude!! @_@" );
                e1.printStackTrace ( );
            }
            
            t.setValue ( field_value );
            
            root.addSubTag ( t );
            
        }
        
        return root.getXML ( );
        
    }
    
    public String getId_da_amostra_dado_pelo_coletor ( )
    {
        return id_da_amostra_dado_pelo_coletor;
    }
    
    public void setId_da_amostra_dado_pelo_coletor (
            String id_da_amostra_dado_pelo_coletor )
    {
        this.id_da_amostra_dado_pelo_coletor = id_da_amostra_dado_pelo_coletor;
    }
    
    public String getExpedicao ( )
    {
        return expedicao;
    }
    
    public void setExpedicao ( String expedcao )
    {
        this.expedicao = expedcao;
    }
    
    public String getProjeto ( )
    {
        return projeto;
    }
    
    public void setProjeto ( String projeto )
    {
        this.projeto = projeto;
    }
    
    public String getProtocolo ( )
    {
        return protocolo;
    }
    
    public void setProtocolo ( String protocolo )
    {
        this.protocolo = protocolo;
    }
    
    public String getAtrativo ( )
    {
        return atrativo;
    }
    
    public void setAtrativo ( String atrativo )
    {
        this.atrativo = atrativo;
    }
    
    public String getData_da_coleta ( )
    {
        return data_da_coleta;
    }
    
    public void setData_da_coleta ( String data_da_coleta )
    {
        this.data_da_coleta = data_da_coleta;
    }
    
    public String getHora_da_coleta ( )
    {
        return hora_da_coleta;
    }
    
    public void setHora_da_coleta ( String hora_da_coleta )
    {
        this.hora_da_coleta = hora_da_coleta;
    }
    
    public String getElementRacine ( )
    {
        // TODO Auto-generated method stub
        return "registro_amostra_sinbio_mobile";
    }
    
    public String getMePersistentSQL ( )
    {
        // TODO Auto-generated method stub
        return "take over!";
    }
    
}
