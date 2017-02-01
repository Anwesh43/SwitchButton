package com.anwesome.ui.switchbutton;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 02/02/17.
 */
public class SwitchButtonGroup {
    private List<String> actions = new ArrayList<>();
    private Activity activity;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int w,h;
    private List<SwitchButton> switchButtons = new ArrayList<>();
    public SwitchButtonGroup(Activity activity) {
        this.activity = activity;
        initDimensions();
    }
    private void initDimensions() {
        DisplayManager displayManager = (DisplayManager)activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display!=null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }
    }
    public void addAction(String action) {
        actions.add(action);
        switchButtons.add(new SwitchButton(activity,action));
    }
    public void resetAnimationOfButtons() {
        for(SwitchButton switchButton:switchButtons) {
            switchButton.reset();
        }
    }
    public void show(int y) {
        int dimen = w/6;
        if(switchButtons.size()>0) {
            dimen = w/(switchButtons.size()+1);
        }
        int x = dimen/2;
        for(SwitchButton switchButton:switchButtons) {
            switchButton.setX(x);
            switchButton.setY(y);
            activity.addContentView(switchButton,new ViewGroup.LayoutParams(dimen,dimen/4));
            x+=dimen;
        }

    }
    private class SwitchButton extends View {
        private boolean isAnimated = false;
        private int rFill = 0,time = 0;
        private String action;
        public SwitchButton(Context context,String action) {
            super(context);
            this.action = action;
        }
        public void reset() {
            isAnimated = false;
            rFill = 0;
            postInvalidate();
        }
        public void onDraw(Canvas canvas) {
            int r= canvas.getHeight()/4;
            paint.setColor(Color.parseColor("#37474F"));
            canvas.drawRoundRect(new RectF(0,0,canvas.getWidth(),canvas.getHeight()),r,r,paint);
            paint.setColor(Color.parseColor("#990288D1"));
            canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,rFill,paint);
            if(isAnimated) {
                try {
                    if(rFill<canvas.getWidth()/2) {
                        rFill+=canvas.getWidth()/14;
                    }
                    else {
                        rFill = canvas.getWidth()/2-canvas.getWidth()/120;
                        isAnimated = false;
                    }
                    time++;
                    Thread.sleep(50);
                    invalidate();
                } catch (Exception ex) {

                }
            }
        }
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN && !isAnimated) {
                resetAnimationOfButtons();
                isAnimated = true;
                postInvalidate();
            }
            return true;
        }
    }
}
