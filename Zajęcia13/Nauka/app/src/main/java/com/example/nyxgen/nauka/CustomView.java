package com.example.nyxgen.nauka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;


public class CustomView extends View {

    protected Game game;
    private float roll;

    public CustomView(Context context) {
        super(context);
        game = new Game(context);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        this.setSystemUiVisibility(uiOptions);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        game.controlPlayer(50*roll, 0);
        game.controlBall();
        game.AI();
        game.draw(canvas);
        invalidate();
    }


    public void setRoll(float roll)
    {
        this.roll = roll;
    }
}