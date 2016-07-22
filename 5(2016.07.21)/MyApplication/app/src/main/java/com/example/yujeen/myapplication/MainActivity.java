package com.example.yujeen.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout parentLayout;
    private Button btn;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        parentLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        edit = (EditText) findViewById(R.id.edit);
        btn.setOnClickListener(this);
    }

    public String cal(String str) {
        String sum;
        int index;
        index = str.indexOf('+');
        try{
        if (index != -1) {
            int num1 = Integer.parseInt(str.substring(0, index).trim());
            int num2 = Integer.parseInt(str.substring(index+1).trim());
            sum = "결과" + String.valueOf(num1 + num2);
        }else{
            sum = "+연산자만 입력하랬찌!!!";
        }}catch(Exception e){
            sum = "제대로 입력하세요!!";
        }
        return sum;
    }

    @Override
    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.btn) {
            str = edit.getText().toString();
            Snackbar.make(parentLayout, cal(str), Snackbar.LENGTH_SHORT).show();
        }

    }
}
