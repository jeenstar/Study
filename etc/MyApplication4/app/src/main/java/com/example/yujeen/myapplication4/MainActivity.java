package com.example.yujeen.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button btn_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.username);
        btn_input = (Button)findViewById(R.id.btn_input);

        btn_input.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btn_input){
                String str = name.getText().toString();
                if(str.equals(""))
                    Toast.makeText(MainActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, str + "'s Calculator start!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),CalculateActivity.class);
                    intent.putExtra("name",str);
                    startActivity(intent);

                }
            }
        }
    };
}
