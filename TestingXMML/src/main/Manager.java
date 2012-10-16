package main;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;

public class Manager {

	public static void main(String[] args) {

		
		Element root = new Element("root");
		
		root.appendChild("Hello World!");
		
		root.addAttribute(new Attribute("test_attrib", "his_value"));
		

		
		Element node2 = new Element("node2");
		
		node2.appendChild("beachy");
		
		root.appendChild(node2);
		
		Document doc = new Document(root);
		
		
		
		String result = doc.toXML();
		
		System.out.println(result.replaceAll(">", ">\n").replaceAll("<", "\n<"));
		
		
		/* --------------------------------------- */
		
		

	}

}
