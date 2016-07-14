package com.example.yujeen.threetest2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private EditText color;
    private EditText size;
    private Button btn;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.text);
        color = (EditText)findViewById(R.id.color);
        size = (EditText)findViewById(R.id.size);
        btn = (Button)findViewById(R.id.btn);
        result = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {


            /*
            String str = text.getText().toString();
            int num;
            try {
            num=Integer.parseInt(str);
            }catch(Exception e){
            Toast.makeText(MainActivity.this,"숫자입력하thㅔ여",Toast.LENGTH_SHORT).show();

            }


             */
            if(view.getId() == R.id.btn){
                String txt = text.getText().toString();
                String clr = color.getText().toString();
                String sz = size.getText().toString();

                if(txt.equals("") || clr.equals("") || sz.equals("")){
                    Toast.makeText(MainActivity.this, "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(clr.length() != 7 || clr.charAt(0) != '#'){
                    Toast.makeText(MainActivity.this, "#000000 RGB형식을 지켜주세요."
                            , Toast.LENGTH_SHORT).show();
                }
                else if(!Pattern.matches("^[0-9]*$",sz) || Integer.parseInt(sz) > 100){
                    Toast.makeText(MainActivity.this, "텍스트 사이즈는 100 이하입니다."
                            , Toast.LENGTH_SHORT).show();
                }
                else{
                    result.setText(txt);
                    result.setTextSize(Integer.parseInt(sz));
                    result.setTextColor(Color.parseColor(clr));
                }
            }
        }
    };

}
