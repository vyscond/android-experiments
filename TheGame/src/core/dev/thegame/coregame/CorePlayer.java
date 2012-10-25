package core.dev.thegame.coregame;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;


public class CorePlayer
{
    private BitmapTextureAtlas mBitmapTextureAtlas;
    private TextureRegion myTextureRegion;
    private TextureRegion myBackgroundTextureRegion;
    private SimpleBaseGameActivity simpleBaseGameActivity;
    
    
    
    public CorePlayer ( SimpleBaseGameActivity simpleBaseGameActivity )
    {
        super ( );
        this.simpleBaseGameActivity = simpleBaseGameActivity;
    }



    public void onLoadResources(Engine myEngine  )
    {
        this.mBitmapTextureAtlas = new BitmapTextureAtlas( this.simpleBaseGameActivity.getTextureManager ( ) , 512, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        
        
        this.myTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this.simpleBaseGameActivity, "Megaman8bit.jpg", 0, 0); 
        this.myBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBitmapTextureAtlas, this.simpleBaseGameActivity, "Megaman8bit.jpg", 0, 185);
        
        myEngine.getTextureManager().loadTexture(this.mBitmapTextureAtlas); 
        
    }
}
