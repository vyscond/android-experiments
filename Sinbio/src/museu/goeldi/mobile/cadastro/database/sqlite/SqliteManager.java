package museu.goeldi.mobile.cadastro.database.sqlite;

import android.util.Log;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.Metadonnee;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.RegistroAmostra;

public class SqliteManager {

	public void persistJMO(Metadonnee m) {
		
		// TODO Auto-generated method stub
		Log.d("Monalisa_DB", "persisting JMO with SQL -> "+m.getMePersistentSQL() );
		
	}

}
