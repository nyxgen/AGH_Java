package com.example.nyxgen.nauka;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;


import java.util.Random;

public class Ball {
    private float positionX;
    private float positionY;
    private float radius;
    private Paint paint;
    private PointF speedMultiplier;
    private PointF velocity;

    public Ball(float leftX, float topY, float sizeX, PointF speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        this.positionX = leftX;
        this.positionY = topY;
        this.radius = sizeX;
        this.paint = new Paint();
        paint.setColor(Color.WHITE);
        this.setRandomVelocity();
    }

    public  void changePosition(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public  void changeColor(int a, int r, int g, int b)
    {
        paint.setARGB(a,r,g,b);
    }
    public Rect getRect()
    {
        return new Rect((int)(positionX-radius/2), (int)(positionY - radius/2),(int)(positionX+radius/2), (int)(positionY + radius/2));
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
    public float getRadius()
    {
        return this.radius;
    }
    public PointF getVelocity()
    {
        return velocity;
    }

    public void updatePosition()
    {
        this.positionX = positionX + velocity.x;
        this.positionY = positionY + velocity.y;
    }
    public void setVelocity(PointF velocity)
    {
        this.velocity = velocity;
    }

    public void setRandomVelocity()
    {
        Random generator = new Random();
        velocity = new PointF();
        boolean flipX = generator.nextBoolean();
        boolean flipY = generator.nextBoolean();
        velocity.x = generator.nextInt(21);
        if(flipX)
            velocity.x = -velocity.x;
        while(velocity.y < 20) {
            velocity.y = generator.nextInt(35);
        }
        if(flipY)
        {
            velocity.y = -velocity.y;
        }
        velocity.x *= speedMultiplier.x;
        velocity.x *= speedMultiplier.y;
    }

}
