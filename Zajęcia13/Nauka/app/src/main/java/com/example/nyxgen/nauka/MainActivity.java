package com.example.nyxgen.nauka;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;



public class MainActivity extends Activity implements SensorEventListener {

    private CustomView customView;
    private SensorManager mSensorManager;
    private MediaPlayer mp;
    Sensor accelerometer;
    Sensor magnetometer;
    float[] mGravity;
    float[] mGeomagnetic;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mp = MediaPlayer.create(this, R.raw.sound);
        super.onCreate(savedInstanceState);
        customView = new CustomView(this);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
        mp.stop();
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {  }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            mGravity = event.values;
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            mGeomagnetic = event.values;
        if (mGravity != null && mGeomagnetic != null) {
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
            if (success) {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);
                customView.setRoll(orientation[2]);
            }
        }
    }

    public void startButtonClick(View view)
    {
        setContentView(customView);
    }

    public void exitButtonClick(View view)
    {
        finish();
        System.exit(0);
    }

    public void settingsButtonClick(View view)
    {
        setContentView(R.layout.settings_layout);
    }
    public void backButtonClick(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void easyButtonClick(View view)
    {
        customView.game.setDifficulty(0);
    }
    public void mediumButtonClick(View view)
    {
        customView.game.setDifficulty(1);
    }
    public void hardButtonClick(View view)
    {
        customView.game.setDifficulty(2);
    }
    public void impossibleButtonClick(View view)
    {
        customView.game.setDifficulty(3);
    }
    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main);

    }
}

