package com.example.himanshu.himdev;

import android.content.Context;

import java.util.Random;

/**
 * Created by himanshu on 15/6/15.
 */

public class CrystalBall {

//member variables
  public static String[] mAnswers ={"one","two","three","four","five"};


//member function


            public static String getAnAnswer()   //when we static a member function an object is not equired then;
    {
        String action = " ";

        // random values
        Random random = new Random();  //object intanciation
        int randomNumber;
        randomNumber = random.nextInt(mAnswers.length);

        // action= Integer.toString(randomNumber);  //used in code when randomNumber is to be converted to string;

        action= mAnswers[randomNumber];
        return  action;

    }
}
