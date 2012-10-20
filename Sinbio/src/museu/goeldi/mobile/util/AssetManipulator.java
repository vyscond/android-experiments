package museu.goeldi.mobile.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;

public class AssetManipulator {

	/* --- loading content from assets */
	
	public InputStream assetToInputStream( Activity act , String fileName ){
		
		try {
			
        	InputStream assetFileStream = act.getAssets().open(fileName);
        	
        	return assetFileStream;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public String assetToString( Activity act , String fileName )
    {
    	String tmp = "";
    	
    	try {
			
        	InputStream assetFileStream = act.getAssets().open(fileName);
        	
        	BufferedReader input = new BufferedReader(new InputStreamReader(assetFileStream));
        	
        	String line;

            while ((line = input.readLine()) != null) {
                tmp += line;
                tmp += "\n";
            }

    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return tmp;
    }
	
}
