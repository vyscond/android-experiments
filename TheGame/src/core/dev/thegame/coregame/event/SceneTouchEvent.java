
package core.dev.thegame.coregame.event;

import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import core.dev.thegame.coregame.scene.SceneBaseEvents;


public class SceneTouchEvent implements IOnSceneTouchListener
{
    
    public boolean onSceneTouchEvent ( Scene pScene , TouchEvent pSceneTouchEvent )
    {
        // TODO Auto-generated method stub
                
        return ( (SceneBaseEvents) pScene ).onSceneTouchEvent ( pScene , pSceneTouchEvent );
        
    }
    
}
