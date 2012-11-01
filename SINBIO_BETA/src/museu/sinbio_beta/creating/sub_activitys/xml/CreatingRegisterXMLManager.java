
package museu.sinbio_beta.creating.sub_activitys.xml;

import museu.sinbio_beta.common.xml.manager.XmlManager;
import museu.sinbio_beta.common.xml.pojo.RegisterXml;

public class CreatingRegisterXMLManager
{

    
    
    private XmlManager xmlManager;
    
    public CreatingRegisterXMLManager ( )
    {
        this.xmlManager = new XmlManager ( );
    }
    
    
    
    public void saveNewXml ( RegisterXml reg )
    {
        this.xmlManager.saveXml ( reg );
    }
    
    
}
