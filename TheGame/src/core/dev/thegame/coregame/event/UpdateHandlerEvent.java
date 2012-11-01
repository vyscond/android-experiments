package core.dev.thegame.coregame.event;

import org.andengine.engine.handler.IUpdateHandler;

import core.dev.thegame.coregame.scene.SceneBaseEvents;



public class UpdateHandlerEvent implements IUpdateHandler
{
    private SceneBaseEvents baseObjectWithEvent;

    
    
    public UpdateHandlerEvent ( SceneBaseEvents baseSceneWithEvent )
    {
        super ( );
        this.baseObjectWithEvent = baseSceneWithEvent;
    }

    public void onUpdate ( float pSecondsElapsed )
    {
        // TODO Auto-generated method stub
        
        this.baseObjectWithEvent.onUpdateHandler ( pSecondsElapsed );
        
    }
    
    public void reset ( )
    {
        // TODO Auto-generated method stub
        
    }
    
}
