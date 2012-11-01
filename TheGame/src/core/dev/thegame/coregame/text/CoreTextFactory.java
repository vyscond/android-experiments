
package core.dev.thegame.coregame.text;

import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.StrokeFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;

import android.graphics.Typeface;
import android.util.Log;




public class CoreTextFactory
{
    
    private SimpleBaseGameActivity simpleBaseGameActivity;
    
    public void echo ( String msg )
    {
        Log.d ( "TheGame" , msg );
    }
    
    public CoreTextFactory ( SimpleBaseGameActivity simpleBaseGameActivity )
    {
        super ( );
        
        this.simpleBaseGameActivity = simpleBaseGameActivity;
        
    }
        
    public Font createFont ( int texture_width , int texture_height , Typeface typeface_family , int typeface_style ,
            int font_size , int type )
    {
        this.echo ( "loading : normal font texture" );
        ITexture fontTexture = new BitmapTextureAtlas ( this.simpleBaseGameActivity.getTextureManager ( ) ,
                texture_width , texture_height , TextureOptions.BILINEAR );
        
        Font f = new Font ( this.simpleBaseGameActivity.getFontManager ( ) , fontTexture , Typeface.create (
                typeface_family , typeface_style ) , font_size , true , Color.WHITE );
        
        switch ( type )
        {
            case NORMAL_FONT :

                f = new Font ( this.simpleBaseGameActivity.getFontManager ( ) , fontTexture , Typeface.create (
                        typeface_family , typeface_style ) , font_size , true , Color.WHITE );
                
                break;
            
            case STROKE_FONT :

                f = new StrokeFont ( this.simpleBaseGameActivity.getFontManager ( ) , fontTexture , Typeface.create (
                        typeface_family , typeface_style ) , font_size , true , Color.BLACK , 2 , Color.WHITE , true );
                
                break;
            
            default :
                Log.d ( "TheGame" , "Invalid Style Type" );
                break;
        }
        
        f.load ( );
        
        return f;
    }
    
    public static final int STROKE_FONT      = 1;
    
    public static final int STROKE_ONLY_FONT = 2;
    
    public static final int NORMAL_FONT      = 3;
    
    public static final int NORMAL_FONT_BOLD = 4;
    
    
    
    public Text getText ( String text , int style , int pos_x , int pos_y , int font_size )
    {
        
        
        
        Font f = this.createFont ( 256 , 256 , Typeface.SERIF , Typeface.NORMAL , font_size , NORMAL_FONT );
        
        switch ( style )
        {
            case STROKE_FONT :

                f = this.createFont ( 256 , 256 , Typeface.SERIF , Typeface.NORMAL , font_size , STROKE_FONT );
                
                break;
            
            case STROKE_ONLY_FONT :

                f = this.createFont ( 256 , 256 , Typeface.SERIF , Typeface.BOLD , font_size , STROKE_FONT );
                
                break;
            
            case NORMAL_FONT :

                f = this.createFont ( 256 , 256 , Typeface.SERIF , Typeface.NORMAL , font_size , NORMAL_FONT );
                
                break;
            
            case NORMAL_FONT_BOLD :

                f = this.createFont ( 256 , 256 , Typeface.SERIF , Typeface.BOLD , font_size , NORMAL_FONT );
                
                break;
            
            default :

                break;
        }
        
        Text t = new Text ( pos_x , pos_y , f , text , this.simpleBaseGameActivity.getVertexBufferObjectManager ( ) );
        
        return t;
        
        // return t;
        
    }
}
