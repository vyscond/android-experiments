package main;

import java.io.IOException;

import main.StupidXML.Tag;
import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class Manager {

	public static void main(String[] args) throws ValidityException, ParsingException, IOException {

//	    StupidXML xml_manager = new StupidXML();
//		
//	    Tag root = xml_manager.getNewTag();
//	    
//	    root.setTagName("root");
//	    
//	    root.addAttribute("test_1", "1");
//	    root.addAttribute("test_2", "2");
//	    
//	    Tag under_root = xml_manager.getNewTag();
//	    
//	    under_root.setTagName("under_root");
//	    
//	    root.addSubTag(under_root);
//	    
//	    Tag under_under_root = xml_manager.getNewTag();
//	    
//	    under_under_root.setTagName("under_all");
//	    
//	    under_under_root.setValue("Hoho");
//	    
//	    under_root.addSubTag(under_under_root);
//	    
//	    System.out.println(root.getXML());
//	    
//
//		/* --------------------------------------- */
//		
//		RegistroAmostra r = new RegistroAmostra();
//		
//		r.toXML();
	    
	    Element root = new Element ( "registro" );
	    
	    Element id = new Element ( "id_amotra" );
	    id.appendChild ( "opa" );
	    
	    root.appendChild ( id );
	    
	    root.appendChild ( new Element ( "data" ) );
	    
	    root.appendChild ( new Element ( "hora" ) );

	    Document doc = new Document(root);
	    String result = doc.toXML();
	    
	    System.out.println(result);
	    
	    Builder parser = new Builder();
	    Document doc2 = parser.build ( result );
	}

}
