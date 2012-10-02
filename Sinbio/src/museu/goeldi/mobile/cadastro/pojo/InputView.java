package museu.goeldi.mobile.cadastro.pojo;

import android.text.InputType;

public class InputView {

	private String title;
	
	private int format;
	

	public String getTitle()
	{
		return this.title;
	}
	
	public int getInputFormat()
	{
		
		
		/*
		 *
		 * 0 | InputType.TYPE_NUMBER_FLAG_DECIMAL       | numero decimal
		 * 1 | InputType.TYPE_NUMBER_FLAG_SIGNED        | numero inteiro com sinal
		 * 2 | InputType.TYPE_NUMBER_VARIATION_NORMAL   | plain normal numeric text
		 * 3 | InputType.TYPE_NUMBER_VARIATION_PASSWORD | numeric password
		 * 
		 */
	
		if( this.format  == 0 )
		{
			return InputType.TYPE_NUMBER_FLAG_DECIMAL;
		}
		
		else if( this.format  == 1 )
		{
			return InputType.TYPE_NUMBER_FLAG_SIGNED;
		}
		
		else if( this.format  == 2 )
		{
			return InputType.TYPE_NUMBER_VARIATION_NORMAL;
		}
		
		else if( this.format  == 3 )
		{
			return InputType.TYPE_NUMBER_VARIATION_PASSWORD;
		}
		
		else if( this.format  == 4 )
		{
			return InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED ;
		}
		
		else
		{
			return 0;
		}
	
	}
	
}
