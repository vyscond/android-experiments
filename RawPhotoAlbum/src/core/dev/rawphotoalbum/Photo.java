
package core.dev.rawphotoalbum;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    
    public Photo ( int layout , String imagePath , String imageName , int width , int height )
    {
        super ( );
        this.imagePath = imagePath;
        this.imageName = imageName;
        this.layout = layout;
        
        this.width = width;
        
        this.height = height;
    }
    
    @ Override
    public View initializeWidgets ( View v )
    {
        
        // TODO Auto-generated method stub
        
        ImageView image;
        
        TextView image_name;
        
        image = (ImageView) v.findViewById ( R.id.imageView1 );
        
        //image_name = (TextView) v.findViewById ( R.id.textView1 );
        
        /* --- setting image on imageview --- */

        Bitmap bmImg = BitmapFactory.decodeFile ( this.imagePath );
        
        image.setImageBitmap ( bmImg );
        
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
