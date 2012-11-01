
package core.dev.thegame.coregame.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

public interface SceneBaseEvents
{
    
    public abstract boolean onSceneTouchEvent ( Scene pScene , TouchEvent pSceneTouchEvent );
    
    public abstract void onUpdateHandler ( float pSecondsElapsed );
    
}
