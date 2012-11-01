
package core.dev.thegame.stages;

import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.Log;
import core.dev.thegame.MainActivity;
import core.dev.thegame.coregame.event.SceneTouchEvent;
import core.dev.thegame.coregame.event.UpdateHandlerEvent;
import core.dev.thegame.coregame.scene.SceneBaseEvents;
import core.dev.thegame.coregame.scene.BaseScene;
import core.dev.thegame.coregame.text.CoreTextFactory;

public class PhaseOne extends BaseScene implements SceneBaseEvents
{
    
    private final int TEXT_AXYS = 1;
    
    private Text      coordinatesText;
    
    public PhaseOne ( SimpleBaseGameActivity simpleBaseGameActivity )
    {
        super ( simpleBaseGameActivity );
        // TODO Auto-generated constructor stub
        
        setBackground ( new Background ( 0f , 0f , 0f ) );
        
        this.coordinatesText = ( new CoreTextFactory ( simpleBaseGameActivity ) ).getText ( "X :         \nY :          " , CoreTextFactory.NORMAL_FONT , 20 , 20 , 25 );
        
        this.coordinatesText.setTag ( TEXT_AXYS );
        
        attachChild ( this.coordinatesText );
        
        setOnSceneTouchListener ( new SceneTouchEvent ( ) );
        
        registerUpdateHandler ( new UpdateHandlerEvent ( this ) );
        
    }
    
    public boolean onSceneTouchEvent ( Scene pScene , TouchEvent pSceneTouchEvent )
    {
        this.setTouchX ( (int) pSceneTouchEvent.getX ( ) );
        
        this.setTouchY ( (int) pSceneTouchEvent.getY ( ) );
        
        Log.d ( "TheGame" , "X : " + this.getTouchX ( ) + "\nY : " + this.getTouchY ( ) );
        
        return false;
    }
    
    public void onUpdateHandler ( float pSecondsElapsed )

    {
        
        coordinatesText.setText ( "X : " + getTouchX ( ) + "/" + MainActivity.CAMERA_WIDTH + "\nY : " + getTouchY ( ) + "/" + MainActivity.CAMERA_HEIGHT );
    }
    
    public void addEntity( IEntity pEntity )
    {
        this.attachChild ( pEntity );
    }
}
