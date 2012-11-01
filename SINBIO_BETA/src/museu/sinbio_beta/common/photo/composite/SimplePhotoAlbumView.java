
package museu.sinbio_beta.common.photo.composite;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.common.composite.GenericAdapter;
import museu.sinbio_beta.common.composite.Simple;
import museu.sinbio_beta.common.photo.manager.pojo.SimplePojoPicture;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.GridView;




public class SimplePhotoAlbumView extends Simple
{
    
    private final String class_in = "SimplePhotoAlbumView : ";
    
    private GridView gridView;

    private GenericAdapter adapter;
    
    public SimplePhotoAlbumView ( Context context , Activity activity , GridView gridView , int column_qtt )
    {
        super ( context );
        // TODO Auto-generated constructor stub
        
        this.echo ( "this.gridView = gridView;" );
        
        this.gridView = gridView;

        //this.gridView.setLayoutParams ( new LinearLayout.LayoutParams ( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT )  );
        
        //this.gridView.setAlwaysDrawnWithCacheEnabled ( true );
        
        //this.gridView.setChoiceMode ( GridView.CHOICE_MODE_MULTIPLE );
        
        //this.gridView.setVelocityScale ( 100.0f );
        
        /* --- setup gridview ---*/
        
        this.echo ( "this.gridView.setNumColumns ( column_qtt );" );
        
        this.gridView.setNumColumns ( column_qtt );
        
        this.echo ( "Photos per Line : " + column_qtt );
        
        this.echo ( "this.adapter = new GenericAdapter ( this.context );" );
        
        this.adapter = new GenericAdapter ( this.context );
        
        this.gridView.setAdapter ( this.adapter );
        
        
               
        //this.gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        
        
        
        
    }
    
    public void addPhoto( SimplePojoPicture p )
    {
        this.adapter.addItem ( p );
        this.adapter.notifyDataSetChanged ( );
    }
    
  
    /*
     * private Metric adjustMetrics(int factor)// Olny for API 13+ { Metric m =
     * new Metric ( );"SimplePhotoAlbum"
     * 
     * Display display = this.activity.getWindowManager().getDefaultDisplay();
     * Point size = new Point(); display.getSize(size); int width = size.x; int
     * height = size.y;
     * 
     * m.for_width = width;
     * 
     * m.for_height = height;
     * 
     * return m;
     * 
     * }
     */

    
    public GridView getGridView ( )
    {
        return gridView;
    }
    
    private void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , class_in + msg );
    }

    public void remove ( int position )
    {
        // TODO Auto-generated method stub
        this.adapter.removeItemByIndex ( position );
        this.adapter.notifyDataSetChanged ( );
    }
    
}
