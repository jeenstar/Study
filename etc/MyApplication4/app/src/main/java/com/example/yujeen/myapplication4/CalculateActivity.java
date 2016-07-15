package com.example.yujeen.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by yujeen on 2016. 7. 15..
 */
public class CalculateActivity extends AppCompatActivity{

    private TextView title_name;
    private TextView window;
    private int count_dot=0;
    private String str="";
    private int[] id_Btn = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4
            ,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
            ,R.id.btn_plus,R.id.btn_minus,R.id.btn_multi,R.id.btn_div
            ,R.id.btn_dot,R.id.btn_delete,R.id.btn_ac,R.id.btn_cal};
    private Button[] btn = new Button[18];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        title_name = (TextView)findViewById(R.id.title_name);
        window = (TextView)findViewById(R.id.window);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        title_name.setText(name);

        for (int i = 0; i < btn.length; i++) {
            btn[i] = (Button)findViewById(id_Btn[i]);
        }

        for (int i = 0; i < btn.length; i++) {
            btn[i].setOnClickListener(listener);
        }


    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
          switch(view.getId()){
              case R.id.btn0:
                  str = str + "0";break;
              case R.id.btn1:
                  str = str + "1";break;
              case R.id.btn2:
                  str = str + "2";break;
              case R.id.btn3:
                  str = str + "3";break;
              case R.id.btn4:
                  str = str + "4";break;
              case R.id.btn5:
                  str = str + "5";break;
              case R.id.btn6:
                  str = str + "6";break;
              case R.id.btn7:
                  str = str + "7";break;
              case R.id.btn8:
                  str = str + "8";break;
              case R.id.btn9:
                  str = str + "9";break;
              case R.id.btn_dot:
                  if(count_dot==0) {
                      if(!str.substring(0).equals("")){
                        str = str + ".";
                        count_dot=1;
                      }else
                          Toast.makeText(CalculateActivity.this, "숫자 먼저!!"
                                  , Toast.LENGTH_SHORT).show();
                  }else{
                      Toast.makeText(CalculateActivity.this, ".은 한번만!!!"
                              , Toast.LENGTH_SHORT).show();
                  }break;
              case R.id.btn_delete:
                  try{
                      if(str.substring(str.length()-1).equals("."))
                          count_dot=0;
                      str = str.substring(0,str.length()-1);
                  }catch(Exception e){
                      Toast.makeText(CalculateActivity.this, "그만지워!!!"
                              , Toast.LENGTH_SHORT).show();
                  }
                  break;
              case R.id.btn_ac:
                  str="";
                  count_dot=0;
                  break;

          }
            window.setText(str);
        }
    };
}
