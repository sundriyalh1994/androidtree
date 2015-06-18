package com.example.himanshu.himdev;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity { //implements View.OnClickListener can be used


    //declaring member var
   // private CrystalBall mCrystalBall = new CrystalBall();
    private TextView mAnswerlabel;

     private Button mGetAnswerButton;
    private ImageView mImage;
    private SensorManager mSensorManager;
    private Sensor mAcclerometer;
   private ShakeDetector mShakeDetector;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign to the member vars
       // mCrystalBall.mAnswers[0] = "ONE";   //use of member variable of object mCrystalBall
        CrystalBall.mAnswers[0]="won";
        mAnswerlabel = (TextView) findViewById(R.id.textView1);
        mImage = (ImageView) findViewById(R.id.imageView);
        //   mGetAnswerButton = (Button) findViewById(R.id.button1);

        //getting shake property
      mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAcclerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                callonshake();
            }
        });
       //use of button insted of shake
       mGetAnswerButton = (Button)findViewById(R.id.button);
        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callonshake();
            }
        });
        }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAcclerometer,
                SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);

    }

    private void callonshake() {
      //  String action = mCrystalBall.getAnAnswer();  //use of member function of McrystalBall object
        String action = CrystalBall.getAnAnswer();

        mAnswerlabel.setText(action);

        makeAnimation();
        makeTextAnimation();
        makesound();
    }

    private void makeAnimation() {

        mImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImage.getDrawable();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        animationDrawable.start();

    }

    //twean animation ->alpha animation
    private void makeTextAnimation() {
        AlphaAnimation alphaAnimation;
        alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        mAnswerlabel.setAnimation(alphaAnimation);


    }

    //making sound using MediaPlayer
    private void makesound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.cheerhooter01);       //static method
          //Toast toast = Toast.makeText(this,"hi",Toast.LENGTH_LONG);




        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//this code is when implements is used

    /*@Override
    public void onClick(View v) {
      //  @Override

        switch (v.getId()) {
            case R.id.button1:
            String action = mCrystalBall.getAnAnswer();

            mAnswerlabel.setText(action);
                default:System.out.print("wow");
        }
    }*/
}
