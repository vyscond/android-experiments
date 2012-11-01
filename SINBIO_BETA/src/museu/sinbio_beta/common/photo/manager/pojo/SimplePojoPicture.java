
package museu.sinbio_beta.common.photo.manager.pojo;


import museu.sinbio_beta.R;
import museu.sinbio_beta.common.composite.GenericItemList;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class SimplePojoPicture extends GenericItemList
{
    
    private String imagePath;
    
    private String imageName;
    
    public String getImagePath ( )
    {
        return imagePath;
    }
    
    
    public int getWidth ( )
    {
        return width;
    }

    
    public void setWidth ( int width )
    {
        this.width = width;
    }

    
    public int getHeight ( )
    {
        return height;
    }

    
    public void setHeight ( int height )
    {
        this.height = height;
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
    
    
    
    
    public Bitmap getImage ( )
    {
        return image;
    }

    
    public void setImage ( Bitmap image )
    {
        this.image = image;
    }

    public SimplePojoPicture( int layout , Bitmap image )
    {
        this.layout = layout;
        
        this.image = image;
        
        
    }
    
    public SimplePojoPicture( int layout , Bitmap image , String imageName)
    {
        this.layout = layout;
        
        this.image = image;
        
        this.imageName = imageName;
    }
    
    public SimplePojoPicture( int layout , Bitmap image , String imageName ,  int width , int height)
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
        
        image = (ImageView) v.findViewById ( R.id.imageView_picture );
        image.setLayoutParams(new LinearLayout.LayoutParams( width , height));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(1, 1, 1, 1);
        
        
        image_name = (TextView) v.findViewById ( R.id.textView_picture_name );
        
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
