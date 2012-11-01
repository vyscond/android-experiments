package core.dev.thegame.coregame.sprite;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.content.Context;

    
public class CorePlayer
{   
    
    private SimpleBaseGameActivity simpleBaseGameActivity;
    
    private Sprite sprite;
    
    public CorePlayer ( SimpleBaseGameActivity simpleBaseGameActivity , String spriteFolderPath  , int textureAtlasWidth , int textureAtlasHeight , TextureOptions textureOptions , String spriteName , int spriteWidth , int spritHeight )
    {
        super ( );
        this.simpleBaseGameActivity = simpleBaseGameActivity;
        this.sprite = this.getSprite ( spriteWidth , spritHeight , this.getTextureRegion ( this.getBitmapTextureAtlas ( this.simpleBaseGameActivity.getTextureManager ( ) , spriteFolderPath  , textureAtlasWidth , textureAtlasHeight , textureOptions ) , this.simpleBaseGameActivity , spriteName ) , this.simpleBaseGameActivity.getVertexBufferObjectManager ( ) );
    }
    
    public BitmapTextureAtlas getBitmapTextureAtlas( TextureManager textureManager , String spriteFolderPath  , int textureAtlasWidth , int textureAtlasHeight , TextureOptions textureOptions )
    {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(spriteFolderPath);
        
        BitmapTextureAtlas bitmapTextureAtlas = new BitmapTextureAtlas(textureManager, 300,300, TextureOptions.BILINEAR);
        
        bitmapTextureAtlas.load();
        
        return bitmapTextureAtlas;
    }
    
    public TextureRegion getTextureRegion( BitmapTextureAtlas bitmapTextureAtlas , Context context , String spriteName )
    {
        return BitmapTextureAtlasTextureRegionFactory.createFromAsset ( bitmapTextureAtlas , context , spriteName  , 0 , 0);
    }
    
    public Sprite getSprite( int spriteWidth , int spritHeight , TextureRegion textureRegion , VertexBufferObjectManager vertexBufferObjectManager)
    {
        return new Sprite ( spriteWidth , spritHeight , textureRegion , vertexBufferObjectManager );
    }
    
    public Sprite getSprite ( )
    {
        
        
        return sprite;
    }
    
    public void setSprite ( Sprite sprite )
    {
        this.sprite = sprite;
    }
}   
