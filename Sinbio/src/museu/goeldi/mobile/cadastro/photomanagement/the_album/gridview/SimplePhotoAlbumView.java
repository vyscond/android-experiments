
package museu.goeldi.mobile.cadastro.photomanagement.the_album.gridview;

import museu.goeldi.mobile.cadastro.photomanagement.the_album.item.RawPhoto;
import museu.goeldi.mobile.screens.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;



public class SimplePhotoAlbumView extends Simple
{
    
    private final String class_in = "SimplePhotoAlbumView : ";
    
    private GridView gridView;
    
    private int      columns_qtt;
    
    public GridView getGridView ( )
    {
        return gridView;
    }
    
    public void setGridView ( GridView gridView )
    {
        this.gridView = gridView;
    }
    
    
    
    private Activity activity;
    
    public SimplePhotoAlbumView ( Context context , Activity activity , GridView gridView , int layout , String folder_name , int column_qtt )
    {
        super ( context );
        // TODO Auto-generated constructor stub
                
        this.gridView = gridView;

        this.gridView.setLayoutParams ( new LinearLayout.LayoutParams ( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT )  );
        
        this.gridView.setAlwaysDrawnWithCacheEnabled ( true );
        
        //this.gridView.setChoiceMode ( GridView.CHOICE_MODE_MULTIPLE );
        
        //this.gridView.setVelocityScale ( 100.0f );
        
        this.adapter = new GenericAdapter ( this.context );
        
        this.gridView.setAdapter ( this.adapter );
        
        this.echo ( "SimpleDataStruct routines are done!" );
        
        
        /* --- specific configs --- */
        
        this.gridView.setNumColumns ( column_qtt );
        
        this.columns_qtt = column_qtt;
        
        this.echo ( "Photos per Line : " + column_qtt );
        
        //this.gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        
        
        
        
    }
    
    public void addPhoto( RawPhoto p )
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

        
    private void echo ( String msg )
    {
        Log.d ( MainActivity.__FLAG__ , class_in + msg );
    }
    
}
