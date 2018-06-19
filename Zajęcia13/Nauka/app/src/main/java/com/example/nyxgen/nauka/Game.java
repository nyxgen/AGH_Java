package com.example.nyxgen.nauka;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.Display;
import android.view.WindowManager;

public class Game {
    private GameBar playerOne;
    private GameBar playerTwo;
    private Ball ball;
    private Point defaultBallPosition;
    private float defaultBallSize;
    private Point defaultPlayerOnePosition;
    private Point defaultPlayerOneSize;
    private Point defaultPlayerTwoPosition;
    private Point defaultPlayerTwoSize;
    private PointF defaultBallSpeedMultiplier;
    private int difficulty = 0;
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    private Point windowSize = new Point();




    public Game(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getSize(windowSize);
        defaultPlayerOnePosition = new Point(windowSize.x/2,  windowSize.y-windowSize.x/50);
        defaultPlayerOneSize = new Point(windowSize.x/6, windowSize.x/25);
        defaultPlayerTwoPosition = new Point( windowSize.x/2,  0+windowSize.x/50);
        defaultPlayerTwoSize = new Point(windowSize.x/6, windowSize.x/25);
        playerOne = new GameBar(defaultPlayerOnePosition.x, defaultPlayerOnePosition.y, defaultPlayerOneSize.x, defaultPlayerOneSize.y);
        playerTwo = new GameBar(defaultPlayerTwoPosition.x,defaultPlayerTwoPosition.y, defaultPlayerTwoSize.x, defaultPlayerTwoSize.y);
        playerOne.changeColor(255, 0, 255, 0);
        playerTwo.changeColor(255, 255, 0, 0);
        defaultBallSpeedMultiplier = new PointF((float)(1000.0/windowSize.x), (float)(1000.0/windowSize.y));
        defaultBallPosition = new Point(windowSize.x/2, windowSize.y/2);
        defaultBallSize = windowSize.x/50;
        ball = new Ball(defaultBallPosition.x, defaultBallPosition.y, defaultBallSize, defaultBallSpeedMultiplier);

    }

    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        int textSize = 300;
        paint.setTextSize(textSize);
        paint.setColor(Color.WHITE);
        canvas.drawText(Integer.toString(playerOnePoints), windowSize.x/4-textSize/2, windowSize.y/2, paint);
        canvas.drawText(Integer.toString(playerTwoPoints), windowSize.x*3/4, windowSize.y/2, paint);
        canvas.drawRect(playerOne.getRect(), playerOne.getPaint());
        canvas.drawRect(playerTwo.getRect(), playerTwo.getPaint());
        canvas.drawCircle(ball.getRect().centerX(),ball.getRect().centerY(), ball.getRadius(), ball.getPaint());
    }
    public void controlPlayer(float x, float y)
    {
        playerOne.changePosition(playerOne.getPositionX()+ x, playerOne.getPositionY());
        if(playerOne.getPositionX() - playerOne.getSizeX()/2<0)
        {
            playerOne.changePosition(playerOne.getSizeX()/2, playerOne.getPositionY());
        }
        if(playerOne.getPositionX()+ playerOne.getSizeX()/2 > windowSize.x) {
            playerOne.changePosition(windowSize.x - playerOne.getSizeX()/2, playerOne.getPositionY());
        }
    }

    public void controlBall()
    {
        ball.updatePosition();
        if(ball.getPositionX() - ball.getRadius()<0)
        {
            ball.changePosition(ball.getRadius(), ball.getPositionY());
            ball.setVelocity(new PointF(-ball.getVelocity().x, ball.getVelocity().y));
        }
        if(ball.getPositionX()+ ball.getRadius()> windowSize.x) {
            ball.changePosition(windowSize.x - ball.getRadius(), ball.getPositionY());
            ball.setVelocity(new PointF(-ball.getVelocity().x, ball.getVelocity().y));
        }
        if(ball.getPositionY() + 2*ball.getRadius()<0)
        {
            ball.changePosition(defaultBallPosition.x, defaultBallPosition.y);
            ball.setRandomVelocity();
            playerOnePoints++;
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException i)
            {

            }
        }
        if(ball.getPositionY() - 2*ball.getRadius() > windowSize.y) {
            ball.changePosition(defaultBallPosition.x, defaultBallPosition.y);
            ball.setRandomVelocity();
            playerTwoPoints++;
            try{
                Thread.sleep(500);
            }
                catch (InterruptedException i)
                {

                }

        }
        if(collisionCheck(playerOne, ball))
        {
            float velocity = (float)(Math.pow(Math.pow(ball.getVelocity().x,2) + Math.pow(ball.getVelocity().y,2), 0.5));
            float angle = (float)Math.atan2(ball.getPositionY()-playerOne.getPositionY()-playerOne.getSizeY(), ball.getPositionX()-playerOne.getPositionX());
            float velocityX = (float)(1.1*Math.cos(angle)*velocity);
            float velocityY = (float)(1.1*Math.sin(angle)*velocity);
            ball.setVelocity(new PointF(velocityX, velocityY));
//            if(ball.getVelocity().y <= 15 * defaultBallSpeedMultiplier.y)
//            {
//                ball.changePosition(ball.getPositionX(), playerOne.getPositionY()-2*ball.getRadius());
//                ball.setVelocity(new PointF(ball.getVelocity().x,-16 * defaultBallSpeedMultiplier.y));
//
//            }
        }
        if(collisionCheck(playerTwo, ball))
        {
            float velocity = (float)(Math.pow(Math.pow(ball.getVelocity().x,2) + Math.pow(ball.getVelocity().y,2), 0.5));
            float angle = (float)Math.atan2(playerTwo.getPositionY() - ball.getPositionY(), ball.getPositionX()-playerTwo.getPositionX());
            float velocityX = (float)(1.1*Math.cos(angle)*velocity);
            float velocityY = (float)(-1.1*Math.sin(angle)*velocity);
            ball.setVelocity(new PointF(velocityX, velocityY));

//            if(Math.abs(ball.getVelocity().y)  <= 15 * defaultBallSpeedMultiplier.y)
//            {
//                ball.changePosition(ball.getPositionX(), playerTwo.getPositionY()+ ball.getRadius()+playerTwo.getSizeY()/2);
//                ball.setVelocity(new PointF(ball.getVelocity().x,16* defaultBallSpeedMultiplier.y));
//            }

        }

    }

    public boolean collisionCheck(GameBar bar, Ball ball)
    {
        if((bar.getPositionX() - bar.getSizeX()/2 < ball.getPositionX() + ball.getRadius())
                && (ball.getPositionX() - ball.getRadius() < bar.getPositionX()+bar.getSizeX()/2 )
                && (bar.getPositionY() < ball.getPositionY() + ball.getRadius())
                && (bar.getPositionY() + bar.getSizeY() > ball.getPositionY() - ball.getRadius()))
        {
            return true;
        }

        return false;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getPlayerOnePoints()
    {
        return playerOnePoints;
    }

    public int getPlayerTwoPoints()
    {
        return playerTwoPoints;
    }

    public void AI() {

        //EASY
        if(difficulty == 0) {
        float lim = 10;
        float delta = playerTwo.getPositionX() - ball.getPositionX();
        if(delta < 0)
        {
            if(delta > -lim)
            {
                playerTwo.changePosition(playerTwo.getPositionX()+delta, playerTwo.getPositionY());
            }
            else
            {
                playerTwo.changePosition(playerTwo.getPositionX()+lim, playerTwo.getPositionY());
            }
        }
        if(delta > 0)
        {
            if(delta < lim)
            {
                playerTwo.changePosition(playerTwo.getPositionX()+delta, playerTwo.getPositionY());
            }
            else
            {
                playerTwo.changePosition(playerTwo.getPositionX()-lim, playerTwo.getPositionY());
            }
        }
        }
        //MEDIUM
        if(difficulty == 1) {
            float lim = 20;
            float delta = playerTwo.getPositionX() - ball.getPositionX();
            if (delta < 0) {
                if (delta > -lim) {
                    playerTwo.changePosition(playerTwo.getPositionX() + delta, playerTwo.getPositionY());
                } else {
                    playerTwo.changePosition(playerTwo.getPositionX() + lim, playerTwo.getPositionY());
                }
            }
            if (delta > 0) {
                if (delta < lim) {
                    playerTwo.changePosition(playerTwo.getPositionX() + delta, playerTwo.getPositionY());
                } else {
                    playerTwo.changePosition(playerTwo.getPositionX() - lim, playerTwo.getPositionY());
                }
            }
        }


        //HARD
        if(difficulty == 2)
        {
        float lim = 30;
            float delta = playerTwo.getPositionX() - ball.getPositionX();
        if(delta < 0)
        {
            if(delta > -lim)
            {
                playerTwo.changePosition(playerTwo.getPositionX()+delta, playerTwo.getPositionY());
            }
            else
            {
                playerTwo.changePosition(playerTwo.getPositionX()+lim, playerTwo.getPositionY());
            }
        }
        if(delta > 0)
        {
            if(delta < lim)
            {
                playerTwo.changePosition(playerTwo.getPositionX()+delta, playerTwo.getPositionY());
            }
            else
            {
                playerTwo.changePosition(playerTwo.getPositionX()-lim, playerTwo.getPositionY());
            }
        }
    }

        //IMPOSSIBLE
        if(difficulty == 3)
        {
        float lim = 15;
        if(ball.getVelocity().y < 0) {
            float ballY = ball.getPositionY();
            float ballX = ball.getPositionX();
            float radius = ball.getRadius();
            float velocityX = ball.getVelocity().x;
            float velocityY = ball.getVelocity().y;
            while (ballY > 0) {
                ballX += velocityX;
                ballY += velocityY;
                if (ballX - radius < 0) {
                    velocityX = -velocityX;
                    ballX = radius;
                }
                if (ballX + radius > windowSize.x) {
                    velocityX = -velocityX;
                    ballX = windowSize.x - radius;
                }
            }
            float delta = playerTwo.getPositionX() - ballX;
            if (delta < 0) {
                if (delta > -lim) {
                    playerTwo.changePosition(playerTwo.getPositionX() + delta, playerTwo.getPositionY());
                } else {
                    playerTwo.changePosition(playerTwo.getPositionX() + lim, playerTwo.getPositionY());
                }
            }
            if (delta > 0) {
                if (delta < lim) {
                    playerTwo.changePosition(playerTwo.getPositionX() + delta, playerTwo.getPositionY());
                } else {
                    playerTwo.changePosition(playerTwo.getPositionX() - lim, playerTwo.getPositionY());
                }
            }
        }
        }
        if(playerTwo.getPositionX() - playerTwo.getSizeX()/2<0)
        {
            playerTwo.changePosition(playerTwo.getSizeX()/2, playerTwo.getPositionY());
        }
        if(playerTwo.getPositionX()+ playerTwo.getSizeX()/2 > windowSize.x) {
            playerTwo.changePosition(windowSize.x - playerTwo.getSizeX()/2, playerTwo.getPositionY());
        }

    }
}
