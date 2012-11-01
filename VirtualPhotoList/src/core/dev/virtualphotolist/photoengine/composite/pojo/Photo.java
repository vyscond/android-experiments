
package core.dev.virtualphotolist.photoengine.composite.pojo;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import core.dev.virtualphotolist.R;

public class Photo extends GenericItemList
{
    
    private String imagePath;
    
    private String imageName;
    
    public String getImagePath ( )
    {
        return imagePath;
    }
    
    public void setImagePath ( String imagePath )
    {
        this.imagePath = imagePath;
    }
    
    public String getImageName ( )
    {
        return imageName;
    }
    
    public void setImageName ( String imageName )
    {
        this.imageName = imageName;
    }
    
    private int width;
    
    private int height;
    
       
    private Bitmap image;
    
    public Photo( int layout , Bitmap image )
    {
        this.layout = layout;
        
        this.image = image;
    }
    
    @ Override
    public View initializeWidgets ( View v )
    {
        
        // TODO Auto-generated method stub
        
        ImageView image;
        
        TextView image_name;
        
        image = (ImageView) v.findViewById ( R.id.imageView1 );
        //image.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(1, 1, 1, 1);
        
        
        //image_name = (TextView) v.findViewById ( R.id.textView1 );
        
        /* --- setting image on imageview --- */

                
        image.setImageBitmap ( this.image );
        
        
        image.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                Toast.makeText ( v.getContext ( ) , "["+imageName+"]" , Toast.LENGTH_SHORT ).show();
                
            }
        });
        
        //image.setLayoutParams ( new LinearLayout.LayoutParams ( this.width , this.height ) );
        
        /* --- setting image text --- */

        //image_name.setText ( this.imageName );
        
        return v;
    }
    
    @ Override
    public int getLayout ( )
    {
        // TODO Auto-generated method stub
        return this.layout;
    }
    
    @ Override
    public void setLayout ( int layout_id )
    {
        // TODO Auto-generated method stub
        this.layout = layout_id;
    }
    
    @ Override
    public long getId ( )
    {
        // TODO Auto-generated method stub
        return this.id;
    }
    
    @ Override
    public void setId ( long id )
    {
        // TODO Auto-generated method stub
        this.id = id;
    }
    
    private long id;
    
    private int  layout;
    
}
