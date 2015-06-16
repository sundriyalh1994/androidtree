package com.example.himanshu.himdev;

import java.util.Random;

/**
 * Created by himanshu on 15/6/15.
 */

public class CrystalBall {

//member variables
  public String[] mAnswers ={"one","two","three","four","five"};

//member function

            public String getAnAnswer()
    {
        String action = " ";

        // random values
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(mAnswers.length);

        // action= Integer.toString(randomNumber);  //used in code when randomNumber is to be converted to string;

        action= mAnswers[randomNumber];
        return  action;

    }
}
