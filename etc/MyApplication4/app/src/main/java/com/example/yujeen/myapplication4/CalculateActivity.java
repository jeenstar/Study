package com.example.yujeen.myapplication4;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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

    private Button[] btn = new Button[18];

    private int[] id_Btn = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4
            ,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
            ,R.id.btn_plus,R.id.btn_minus,R.id.btn_multi,R.id.btn_div

            ,R.id.btn_dot,R.id.btn_delete,R.id.btn_ac,R.id.btn_cal};

    private String str="";
    private int count_dot=0;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub = menu.addSubMenu("color");
        sub.add(0,1,0,"red");
        sub.add(0,2,0,"orange");
        sub.add(0,3,0,"yellow");
        sub.add(0,4,0,"green");
        sub.add(0,5,0,"blue");
        sub.add(0,6,0,"purple");
        sub.add(0,7,0,"mint");
        sub.add(0,8,0,"pink");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_red);
                }

                window.setBackgroundResource(R.color.colorWindow_red);
                return true;
            case 2:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_orange);
                }
                window.setBackgroundResource(R.color.colorWindow_orange);
                return true;
            case 3:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_yellow);
                }
                window.setBackgroundResource(R.color.colorWindow_yellow);
                return true;
            case 4:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_green);
                }
                window.setBackgroundResource(R.color.colorWindow_green);
                return true;
            case 5:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_blue);
                }
                window.setBackgroundResource(R.color.colorWindow_blue);
                return true;
            case 6:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_purple);
                }
                window.setBackgroundResource(R.color.colorWindow_purple);
                return true;
            case 7:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_mint);
                }
                window.setBackgroundResource(R.color.colorWindow_mint);
                return true;
            case 8:
                for (int i = 0; i < btn.length; i++) {
                    if(i==15)
                        i=16;
                    btn[i].setBackgroundResource(R.color.colorButton_pink);
                }
                window.setBackgroundResource(R.color.colorWindow_pink);
                return true;


        }
        return false;
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
          switch(view.getId()){
              case R.id.btn0:
                  if(!str.substring(0).equals("0"))
                    str = str + "0";
                  else
                      Toast.makeText(CalculateActivity.this, "0 입력 안시켜줄거야!!"
                              , Toast.LENGTH_SHORT).show();
                  break;
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
              case R.id.btn_plus:


                  break;
              case R.id.btn_minus:


                  break;
              case R.id.btn_multi:


                  break;
              case R.id.btn_div:


                  break;
              case R.id.btn_cal:


                  break;
          }

            window.setText(str);
        }
    };
}
