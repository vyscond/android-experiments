package main;

import main.StupidXML.Tag;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;

public class Manager {

	public static void main(String[] args) {

	    StupidXML xml_manager = new StupidXML();
		
	    Tag root = xml_manager.getNewTag();
	    
	    root.setTagName("root");
	    
	    root.addAttribute("test_1", "1");
	    root.addAttribute("test_2", "2");
	    
	    Tag under_root = xml_manager.getNewTag();
	    
	    under_root.setTagName("under_root");
	    
	    root.addSubTag(under_root);
	    
	    Tag under_under_root = xml_manager.getNewTag();
	    
	    under_under_root.setTagName("under_all");
	    
	    under_under_root.setValue("Hoho");
	    
	    under_root.addSubTag(under_under_root);
	    
	    System.out.println(root.getXML());
	    

		/* --------------------------------------- */
		
		RegistroAmostra r = new RegistroAmostra();
		
		r.toXML();

	}

}
