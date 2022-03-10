package com.example.gestureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static final String TAG = "Swipe Position";
    private  float x1, x2, y1, y2;
    private static int MIN_DISTANCE = 150;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initilize gestureDetector Object
        this.gestureDetector = new GestureDetector(MainActivity.this, this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);

        switch(event.getAction())
        {
            //start to swipe time gesture
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                // horizaontal swipe
                float valueX = x2 -x1;
                //vertical swipe
                float valueY = y2-y1;

                if(Math.abs(valueX) > MIN_DISTANCE)
                {
                    //detect left to right swipe
                    if (x2 > x1)
                    {
                        Toast.makeText(this, "Right Swipe", Toast.LENGTH_SHORT.show());

                    }
                    else
                    {
                        Toast.makeText(this, "Left Swipe", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(Math.abs(valueY)> MIN_DISTANCE)
                {
                    if (y2 > y1)
                    {
                        Toast.makeText(this, "Bottom Swipe", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(this, "Top Swipe", Toast.LENGTH_SHORT).show();
                    }
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScrollMERGECONFLCIT (MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    // comment to see the difference in merging

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}