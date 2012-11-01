package core.dev.thegame.coregame.joystick;

import org.andengine.entity.scene.ITouchArea;
import org.andengine.input.touch.TouchEvent;


public interface ButtonBaseEvents
{
    public abstract boolean ButtonTouched ( TouchEvent pSceneTouchEvent , ITouchArea pTouchArea , float pTouchAreaLocalX , float pTouchAreaLocalY );
}
