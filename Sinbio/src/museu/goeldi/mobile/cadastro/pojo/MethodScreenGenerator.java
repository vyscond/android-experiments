package museu.goeldi.mobile.cadastro.pojo;

import java.io.IOException;
import java.io.InputStream;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import museu.goeldi.mobile.kiss.Util;
import android.app.Activity;
import android.util.Log;

public class MethodScreenGenerator {
	
	private Util donald = new Util();
	
	public MethodScreenGenerator( Activity act , String fileName )
	{
		InputStream inputStream_xml = this.donald.assetToInputStream(act, fileName);
		
		Builder parser = new Builder();
		
		try {
			
			Document xmlConfigFile = parser.build(inputStream_xml);
			
		} catch (ValidityException e) {
			// TODO Auto-generated catch block
			Log.d(this.getClass().toString(), "Error de validação no XML");
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			Log.d(this.getClass().toString(), "Error de validação no XML");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d(this.getClass().toString(), "XML não existe .-.");
		}
		
		
		
	}
	
}
