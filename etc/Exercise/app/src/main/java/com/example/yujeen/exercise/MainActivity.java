package com.example.yujeen.exercise;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);
        relativeLayout.setOnTouchListener(TouchListener);
    }
    class TouchListenerClass implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Snackbar.make(relativeLayout,"touchtouch",Snackbar.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
    TouchListenerClass TouchListener = new TouchListenerClass();
}
