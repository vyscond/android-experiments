
package museu.goeldi.mobile.cadastro.photoalbum.virtual.composite.pojo;

import museu.goeldi.mobile.R;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;


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
    
    public Photo( int layout , Bitmap image , String imageName)
    {
        this.layout = layout;
        
        this.image = image;
        
        this.imageName = imageName;
    }
    
    public Photo( int layout , Bitmap image , String imageName ,  int width , int height)
    {
        this.layout = layout;
        
        this.image = image;
        
        this.imageName = imageName;
        
        this.width = width;
        
        this.height = height;
    }
    
    @ Override
    public View initializeWidgets ( View v )
    {
        
        // TODO Auto-generated method stub
        
        ImageView image;
        
        TextView image_name;
        
        image = (ImageView) v.findViewById ( R.id.imageView_photo );
        image.setLayoutParams(new LinearLayout.LayoutParams( width , height));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(1, 1, 1, 1);
        
        
        image_name = (TextView) v.findViewById ( R.id.textView_photo_name );
        
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

        image_name.setText ( this.imageName );
        
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
