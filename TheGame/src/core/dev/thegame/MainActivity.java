
package core.dev.thegame;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.Log;
import android.view.Display;
import core.dev.thegame.coregame.CorePlayer;
import core.dev.thegame.coregame.CoreText;

public class MainActivity extends SimpleBaseGameActivity
{
    
    static int               CAMERA_WIDTH  = 800;
    
    static int               CAMERA_HEIGHT = 480;
    
    /* --- Touch Axys --- */

    private static int       TOUCH_X;
    
    private static int       TOUCH_Y;
    
    private static FPSLogger FPS;
    
    public Camera            mCamera;
    
    // A reference to the current scene
    public Scene             mCurrentScene;
    
    CoreText                 Label;
    
    private static final int TEXT_AXYS     = 1;
    
    private static final int TEXT_FPS      = 2;
    
    private static final int TEXT_RUNT     = 3;
    
    private static int       FPS_COUNTER   = 0;
    
    private static float     RUNNING_TIME  = 0;
    
    CorePlayer               player_1;
    
    public EngineOptions onCreateEngineOptions ( )
    {
        
        final Display display = getWindowManager ( ).getDefaultDisplay ( );
        CAMERA_WIDTH = display.getWidth ( );
        CAMERA_HEIGHT = display.getHeight ( );
        
        mCamera = new Camera ( 0 , 0 , CAMERA_WIDTH , CAMERA_HEIGHT );
        
        return new EngineOptions ( true , ScreenOrientation.LANDSCAPE_SENSOR , new RatioResolutionPolicy (
                CAMERA_WIDTH , CAMERA_HEIGHT ) , mCamera );
        
    }
    
    @ Override
    protected void onCreateResources ( )
    {
        // TODO Auto-generated method stub
        Log.d ( "TheGame" , "CycleThread???" );
        
        player_1 = new CorePlayer ( this );
        
        player_1.onLoadResources ( mEngine );
        
    }
    
    @ Override
    protected Scene onCreateScene ( )
    {
        
        Log.d ( "TheGame" , "Creating a Pen" );
        
        Label = new CoreText ( this );
        
        FPS = new FPSLogger ( );
        
        mEngine.registerUpdateHandler ( new IUpdateHandler ( )
        {
            
            public void reset ( )
            {
                // TODO Auto-generated method stub
                
            }
            
            public void onUpdate ( float pSecondsElapsed )
            {
                // TODO Auto-generated method stub
                
                FPS_COUNTER = (int) FPS.getFPS ( );
                // RUNNING_TIME = pSecondsElapsed / 60 ;
            }
        } );
        
        mCurrentScene = new Scene ( );
        
        mCurrentScene.setBackground ( new Background ( 0f , 0f , 0f ) );
        
        Text text_for_axys = this.Label.getText ( "X :         \nY :          " , Label.NORMAL_FONT , 20 , 20 , 25 );
        
        text_for_axys.setTag ( TEXT_AXYS );
        
        mCurrentScene.attachChild ( text_for_axys );
        
        Text text_for_fps = this.Label.getText ( "FPS :    " , Label.NORMAL_FONT , 20 , CAMERA_HEIGHT - 100 , 25 );
        
        text_for_fps.setTag ( TEXT_FPS );
        
        mCurrentScene.attachChild ( text_for_fps );
        
        // Text text_for_running_time = this.Label.getText (
        // "RUNNING TIME :                      " , Label.NORMAL_FONT , 20 ,
        // CAMERA_HEIGHT - 200 , 25 );
        
        // text_for_running_time.setTag ( TEXT_RUNT );
        
        // mCurrentScene.attachChild ( text_for_running_time );
        
        mCurrentScene.setOnSceneTouchListener ( new IOnSceneTouchListener ( )
        {
            
            public boolean onSceneTouchEvent ( Scene pScene , TouchEvent pSceneTouchEvent )
            {
                // TODO Auto-generated method stub
                
                TOUCH_X = (int) pSceneTouchEvent.getX ( );
                
                TOUCH_Y = (int) pSceneTouchEvent.getY ( );
                
                Log.d ( "TheGame" , "X : " + TOUCH_X + "\nY : " + TOUCH_Y );
                
                return false;
            }
        } );
        
        mCurrentScene.registerUpdateHandler ( new TimerHandler ( 1 / 20.0f , true , new ITimerCallback ( )
        {
            
            public void onTimePassed ( final TimerHandler pTimerHandler )
            {
                
                ( (Text) mCurrentScene.getChildByTag ( TEXT_AXYS ) ).setText ( "X : " + TOUCH_X + "/" + CAMERA_WIDTH
                        + "\nY : " + TOUCH_Y + "/" + CAMERA_HEIGHT );
                
                ( (Text) mCurrentScene.getChildByTag ( TEXT_FPS ) ).setText ( "FPS : " + FPS_COUNTER );
                // ( (Text) mCurrentScene.getChildByTag ( TEXT_RUNT ) ).setText
                // ( "RUNNING TIME : "+RUNNING_TIME );
            }
        } ) );
        
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
