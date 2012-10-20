package main;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistroAmostra
{
    
    private String id_da_amostra_dado_pelo_coletor = " a";
    
    private String expedicao                       = "a";
    
    private String projeto                         = "s";
    
    private String protocolo                       = "s";
    
    private String atrativo                        = "s";
    
    private String data_da_coleta                  = "s";
    
    private String hora_da_coleta                  = "s";
    
    public void toXML()
    {
        
        for (Field f : this.getClass().getDeclaredFields())
        {
            
            String field_name = f.getName();
            
            System.out.println(field_name);
            
            RegistroAmostra a = new RegistroAmostra();
            
            try
            {
                Object o = f.get(this);
                
                System.out.println(o);
            } catch (IllegalArgumentException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    public String getId_da_amostra_dado_pelo_coletor()
    {
        return id_da_amostra_dado_pelo_coletor;
    }
    
    public void setId_da_amostra_dado_pelo_coletor(String id_da_amostra_dado_pelo_coletor)
    {
        this.id_da_amostra_dado_pelo_coletor = id_da_amostra_dado_pelo_coletor;
    }
    
    public String getExpedicao()
    {
        return expedicao;
    }
    
    public void setExpedicao(String expedcao)
    {
        this.expedicao = expedcao;
    }
    
    public String getProjeto()
    {
        return projeto;
    }
    
    public void setProjeto(String projeto)
    {
        this.projeto = projeto;
    }
    
    public String getProtocolo()
    {
        return protocolo;
    }
    
    public void setProtocolo(String protocolo)
    {
        this.protocolo = protocolo;
    }
    
    public String getAtrativo()
    {
        return atrativo;
    }
    
    public void setAtrativo(String atrativo)
    {
        this.atrativo = atrativo;
    }
    
    public String getData_da_coleta()
    {
        return data_da_coleta;
    }
    
    public void setData_da_coleta(String data_da_coleta)
    {
        this.data_da_coleta = data_da_coleta;
    }
    
    public String getHora_da_coleta()
    {
        return hora_da_coleta;
    }
    
    public void setHora_da_coleta(String hora_da_coleta)
    {
        this.hora_da_coleta = hora_da_coleta;
    }
    
}
