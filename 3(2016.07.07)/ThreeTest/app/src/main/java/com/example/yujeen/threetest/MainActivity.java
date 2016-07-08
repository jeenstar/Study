package com.example.yujeen.threetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText id;
    private EditText pw;
    private EditText rePw;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
        id = (EditText)findViewById(R.id.id);
        pw = (EditText)findViewById(R.id.pw);
        rePw = (EditText)findViewById(R.id.repassword);
        btn = (Button)findViewById(R.id.btn);

        text.setOnClickListener(listener);
        btn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(view.getLayoutParams());
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            params.width = btn.getWidth();
            params.height = btn.getHeight();

            //text가 눌렸을 경우
            if(view.getId() == R.id.text) {
                if (text.getText().toString().equals("로그인")) {
                    //text가 로그인일경우=회원가입 페이지에서 로그인 페이지로 변경될 때
                    toLogin(params);
                } else if (text.getText().toString().equals("회원가입")) {
                    //text가 회원가입일경우=로그인 페이지에서 회원가입 페이지로 변경될 때
                    toSignup(params);
                }
            }
            //btn이 눌렸을 경우
            else if(view.getId() == R.id.btn){
                String str="";
                //로그인버튼이 눌렸을 경우
                if (btn.getText().toString().equals("로그인")) {
                    if(!id.getText().toString().equals("")
                            && !pw.getText().toString().equals(""))
                        str = id.getText().toString()+"님께서 로그인하셨습니다.";
                    else
                        str="id와 pw를 다시 입력해주세요";
                }
                //회원가입버튼이 눌렸을 경우
                else if (btn.getText().toString().equals("회원가입")) {
                    if(!id.getText().toString().equals("") && !pw.getText().toString().equals("")
                            && !rePw.getText().toString().equals("")) {
                        if (pw.getText().toString().equals(rePw.getText().toString())) {
                            str = "회원가입이 완료되었습니다";
                            toLogin(params);
                        }
                        else
                            str="비밀번호를 확인해주세요";
                    }
                    else
                        str = "제대로 입력되었는지 확인해주세요";

                }
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
            id.setText("");
            pw.setText("");
            rePw.setText("");
        }

    };
    public void toLogin(RelativeLayout.LayoutParams params){//회원가입 페이지에서 로그인 페이지로 변경될 때
        text.setText("회원가입");
        rePw.setVisibility(View.INVISIBLE);
        btn.setText("로그인");
        params.addRule(RelativeLayout.BELOW,R.id.pw);
        btn.setLayoutParams(params);

    }
    public void toSignup(RelativeLayout.LayoutParams params){//로그인 페이지에서 회원가입 페이지로 변경될 때
        text.setText("로그인");
        rePw.setVisibility(View.VISIBLE);
        btn.setText("회원가입");
        params.addRule(RelativeLayout.BELOW,R.id.repassword);
        btn.setLayoutParams(params);
    }
}
