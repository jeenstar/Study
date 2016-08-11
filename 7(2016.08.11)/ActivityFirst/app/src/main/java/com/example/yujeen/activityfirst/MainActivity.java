package com.example.yujeen.activityfirst;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yujeen.activityfirst.util.Navigator;

public class MainActivity extends Activity {
    private Button input_btn;
    //private Button dial;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*dial = (Button)findViewById(R.id.dial);
        dial.setOnClickListener(onClickListener);*/
        input = (EditText)findViewById(R.id.input);
        input_btn = (Button)findViewById(R.id.input_btn);
        input_btn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            /*if(view.getId()==R.id.btn){
                Navigator.goSub(MainActivity.this);
                *//*Intent intent = new Intent(MainActivity.this,SubActivity.class);//(context,class)
                startActivity(intent);*//**//*
                //메인액티비티위에 서브액티비티가 불려지는거야!!그래서 뒤로가기버튼을 누르면 메인액티비티가 뜨는거야!
                //액티비티가 많으면 많아질수록 느려져!안좋아안좋아!!!
                //그래서 액티비티 많이 만드는것보다 fragment가 좋아!!!
                //액션바(툴바)....액션바액티비티가 사라지고 앱컴팻액티비티가 생겼는데 이걸 쓰면 위에 툴바가 자동으로 생겨!
                //툴바없애고싶으면
                //1.extends Activity만 해!(앱컴팻액티비티에는 다양한 기능이 있어서 1번 방법을 쓰는건 좋지않아!)
                //2.[values]->[style]-><item name="android:windowActionBar">false</item>추가해*//*
            }*/
            /*if(view.getId() == R.id.dial){
                Navigator.goDial(MainActivity.this, "01037565713");
            }*/
            if(view.getId()==R.id.input_btn){
                String str;
                str = input.getText().toString();
                Navigator.goDial(MainActivity.this, str);
            }
        }
    };
}
