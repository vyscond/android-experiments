package museu.goeldi.mobile.util;

import java.util.HashMap;
import java.util.LinkedList;

public class StupidXML
{
    public Tag getNewTag( )
    {
        return new Tag();
    }
    
    public class Tag{
        
        private String tag_begin;
        
        private String tag_name;
        
        private String tag_end;
        
        LinkedList<Tag> sub_tags = new LinkedList<Tag>();
        
        public void setTagName(String name)
        {
            this.tag_name = name;
            
            this.tag_begin = "<"+this.tag_name; // temos que fazer só no metodo de gerar a String xml
            
            this.tag_end = "<"+this.tag_name+"/>";
        }
        
        private String value;
        
        public void setValue(String value)
        {
            this.value = value;
        }

      
        public void addSubTag(Tag t)
        {
         
            this.sub_tags.addFirst(t);
        }
        
        
        
        private HashMap<String, String> tag_attributes = new HashMap<String, String>();
        
        public void addAttribute(String name , String value)
        {
            this.tag_attributes.put(name, value);
        }
        
        
        
        
        public String getXML()
        {
            String XML = "";
            
            XML += this.tag_begin + " ";
            
            if( this.tag_attributes.size() > 0 )
            {
            
                for (String attribute_name : this.tag_attributes.keySet())
                {
                    XML += attribute_name+"="+this.tag_attributes.get(attribute_name)+" ";
                }
            }
            
            XML +=   ">"+"\n";
            
            /* ---  [END] --- parsing attributes --- */
            
            /* --- [BGN] ---  value for node --- */
            
            if( this.value != null && (!this.value.equals("")) )
            {
                XML += this.value+"\n";
            } else
            {
                XML += "\n";
            }
            
            /* --- [END] ---  value for node --- */
            
            /* --- [BGN] --- appending subtag --- */
            
            if( this.sub_tags.size() > 0 )
            {
            
                for (Tag subTag : this.sub_tags)
                {
                    XML +=subTag.getXML() + "\n";
                }
            }
            
            /* --- [END] --- appending subtag --- */
            
           
            
            XML += this.tag_end+"\n";
            
            return XML;
        }
        

        
    }
    
}
