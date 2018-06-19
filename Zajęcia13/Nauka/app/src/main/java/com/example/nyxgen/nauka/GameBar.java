package com.example.nyxgen.nauka;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameBar {

    private float positionX;
    private float positionY;
    private float sizeX;
    private float sizeY;
    private Paint paint;


    public GameBar(float leftX, float topY, float sizeX, float sizeY) {
        this.positionX = leftX;
        this.positionY = topY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    public  void changePosition(float positionX, float positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public  void changeColor(int a, int r, int g, int b)
    {
        paint.setARGB(a,r,g,b);
    }
    public Rect getRect()
    {
        return new Rect((int)(positionX-sizeX/2), (int)(positionY), (int)(positionX+sizeX/2), (int)(positionY + sizeY));
    }
    public Paint getPaint()
    {
        return this.paint;
    }
    public float getPositionX()
    {
        return this.positionX;
    }
    public float getPositionY()
    {
        return this.positionY;
    }
    public float getSizeX()
    {
        return  sizeX;
    }
    public float getSizeY()
    {
        return  sizeY;
    }

}
