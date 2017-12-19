package com.example.android.iknowyourtouch;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.mapzen.speakerbox.Speakerbox;

import es.dmoral.toasty.Toasty;

import static es.dmoral.toasty.Toasty.info;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    //create a gesture detector
    GestureDetectorCompat gestureDetectorCompat;
    Speakerbox speakerbox;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate the gesture detector with the application context and an implementation of GestureDetector.OnGestureListener
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap listener
        gestureDetectorCompat.setOnDoubleTapListener(this);

        speakerbox = new Speakerbox(getApplication());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Toasty.info(this, "You double tapped me!", Toast.LENGTH_SHORT,true).show();
        speakerbox.play("You double tapped me");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Toasty.info(this, "You long pressed me!", Toast.LENGTH_SHORT,true).show();
        speakerbox.play("You long pressed me");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
