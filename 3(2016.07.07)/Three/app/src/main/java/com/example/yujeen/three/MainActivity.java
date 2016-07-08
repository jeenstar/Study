package com.example.yujeen.three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button appleBtn;
    private Button orangeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* btnOnClickListener onClickListener = new btnOnClickListener();*/

        appleBtn = (Button)findViewById(R.id.apple);//findViewById는 setContentView가 호출되고 난 뒤에만 사용가능
        orangeBtn = (Button)findViewById(R.id.orange);
        appleBtn.setOnClickListener(listener);
        orangeBtn.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = "";
            switch(view.getId()){
                case R.id.apple:
                    // Toast.makeText(MainActivity.this,"apple",Toast.LENGTH_SHORT).show();
                    str = "apple";
                    break;
                case R.id.orange:
                    //Toast.makeText(MainActivity.this,"orange",Toast.LENGTH_SHORT).show();
                    str = "orange";
                    break;
            }
            Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        }
    };
    /*class btnOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String str = "";
            switch(view.getId()){
                case R.id.apple:
                   // Toast.makeText(MainActivity.this,"apple",Toast.LENGTH_SHORT).show();
                    str = "apple";
                    break;
                case R.id.orange:
                    //Toast.makeText(MainActivity.this,"orange",Toast.LENGTH_SHORT).show();
                    str = "orange";
                    break;
            }
            Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        }
    }*/
}
