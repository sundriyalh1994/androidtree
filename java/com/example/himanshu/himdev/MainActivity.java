package com.example.himanshu.himdev;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity{ //implements View.OnClickListener can be used

//declaring member var
    private CrystalBall mCrystalBall = new CrystalBall();
    private TextView mAnswerlabel;
    private Button mGetAnswerButton;
    private ImageView mImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //assign to the member vars
        mCrystalBall.mAnswers [0] ="ONE";   //use of member variable of object mCrystalBall
        mAnswerlabel = (TextView)findViewById(R.id.textView1);
        mGetAnswerButton = (Button)findViewById(R.id.button1);
        mImage = (ImageView)findViewById(R.id.imageView);


        mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = mCrystalBall.getAnAnswer();  //use of member function of McrystalBall object

                mAnswerlabel.setText(action);

                makeAnimation();
                makeTextAnimation();
            }
        });
    }

    private void makeAnimation (){

        mImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable animationDrawable =(AnimationDrawable) mImage.getDrawable();
        if(animationDrawable.isRunning())
        {
            animationDrawable.stop();
        }
        animationDrawable.start();

    }
    //twean animation ->alpha animation
    private void makeTextAnimation(){
        AlphaAnimation alphaAnimation  = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        mAnswerlabel.setAnimation(alphaAnimation);


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
