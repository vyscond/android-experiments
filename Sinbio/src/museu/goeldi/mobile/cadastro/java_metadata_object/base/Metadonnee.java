package museu.goeldi.mobile.cadastro.java_metadata_object.base;

public interface Metadonnee {
	
	public abstract String getElementRacine(); //obter elemento root
	
	public abstract String getMePersistentSQL(); // obter sql de persistencia 
	
	public abstract String getLangageDeBalisageExtensible(); // obter string xml
	
}
