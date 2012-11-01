
package core.dev.thegame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.Texture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.Log;
import android.view.Display;
import android.widget.Toast;
import core.dev.thegame.coregame.joystick.JoystickButton;
import core.dev.thegame.coregame.sprite.CorePlayer;
import core.dev.thegame.stages.PhaseOne;

public class MainActivity extends SimpleBaseGameActivity
{
    
    public static int CAMERA_WIDTH  = 800;
    
    public static int CAMERA_HEIGHT = 480;
    
    /* --- Touch Axys --- */

    public Camera     mCamera;
    
    // A reference to the current scene
    public Scene      mCurrentScene;
    
    public EngineOptions onCreateEngineOptions ( )
    {
        
        final Display display = getWindowManager ( ).getDefaultDisplay ( );
        
        CAMERA_WIDTH = display.getWidth ( );
        CAMERA_HEIGHT = display.getHeight ( );
        
        mCamera = new Camera ( 0 , 0 , CAMERA_WIDTH , CAMERA_HEIGHT );
        
        return new EngineOptions ( true , ScreenOrientation.LANDSCAPE_SENSOR , new RatioResolutionPolicy ( CAMERA_WIDTH , CAMERA_HEIGHT ) , mCamera );
        
    }
    
    @ Override
    protected void onCreateResources ( )
    {
        Log.d ( "TheGame" , "onCreateResources" );
        
        // TODO Auto-generated method stub
        
    }
    
    @ Override
    protected Scene onCreateScene ( )
    {
        
        Log.d ( "TheGame" , "onCreateScene" );
        
        CorePlayer maNigga = new CorePlayer ( this , "gfx/" , 300 , 300 , TextureOptions.BILINEAR_PREMULTIPLYALPHA , "megaman_300_300.jpg" , 300 , 300 );
        
        //JoystickButton b = new JoystickButton ( this , "gfx/controller/" , 48 , 48 , TextureOptions.BILINEAR_PREMULTIPLYALPHA , "PS3_x_48_48.png" , 48 , 48 );
        
        
        
        mCurrentScene = new PhaseOne ( this );
        
        mCurrentScene.attachChild ( maNigga.getSprite ( ) );
        
        
        
        /* Button :D */
        
        
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath ( "gfx/controller/" );
        
        BitmapTextureAtlas bitmapTextureAtlas = new BitmapTextureAtlas ( this.getTextureManager ( ) , 48 , 48 , TextureOptions.BILINEAR );
        
        bitmapTextureAtlas.load ( );
        
        TextureRegion textureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset ( bitmapTextureAtlas , this , "PS3_x_48_48.png" , 0 , 0 );
        
        Sprite p = new Sprite ( 48 , 48 , textureRegion , this.getVertexBufferObjectManager ( ) )
        {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                //Insert Code Here
                Log.d ( "TheGame" , "You touched a button :D" );
                return true;
            }
        };
        
        
        p.setPosition ( 750f , 320f );
        
        p.setScale ( 5f );
        
        mCurrentScene.registerTouchArea( p );
        mCurrentScene.setTouchAreaBindingOnActionDownEnabled(true);
        mCurrentScene.attachChild( p );
        
        Sprite button = new CorePlayer ( this , "gfx/controller/" , 48 , 48 , TextureOptions.BILINEAR_PREMULTIPLYALPHA , "PS3_circle_48_48.png" , 48 , 48 ).getSprite ( );
        
        button.setPosition ( 890f , 460f );
        
        button.setScale ( 5f );
        
        mCurrentScene.registerTouchArea( button );
        mCurrentScene.setTouchAreaBindingOnActionDownEnabled(true);
        mCurrentScene.attachChild( button );
        
        
        
        return mCurrentScene;
    }
    
    /* --- extra code --- */

    // to change the current main scene
    public void setCurrentScene ( Scene scene )
    {
        mCurrentScene = scene;
        getEngine ( ).setScene ( mCurrentScene );
    }
}
