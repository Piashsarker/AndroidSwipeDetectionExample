package com.dcastalia.androidswipedetectionexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private LinearLayout layoutFullScreen;
    private Context context;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        layoutFullScreen = (LinearLayout) findViewById(R.id.layout_screen);
        gestureDetector=new GestureDetector(this,new OnSwipeListener(){

            @Override
            public boolean onSwipe(Direction direction) {
                if (direction==Direction.up){
                    //do your stuff
                    Log.d(TAG, "onSwipe: up");
                    Toast.makeText(context, "Swiping Up", Toast.LENGTH_SHORT).show();

                }

                if (direction==Direction.down){
                    //do your stuff
                    Log.d(TAG, "onSwipe: down");
                    Toast.makeText(context, "Swiping Down", Toast.LENGTH_SHORT).show();
                }
                if(direction==Direction.right){
                    Log.d(TAG, "onSwipe: Right");
                    Toast.makeText(context, "Swiping Right", Toast.LENGTH_SHORT).show();
                }
                if(direction==Direction.left){
                    Log.d(TAG, "onSwipe: Left");
                    Toast.makeText(context, "Swiping Left", Toast.LENGTH_SHORT).show();
                }
                return true;
            }


        });
        layoutFullScreen.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "onTouch: ");
        gestureDetector.onTouchEvent(event);
        return true;
    }
}
