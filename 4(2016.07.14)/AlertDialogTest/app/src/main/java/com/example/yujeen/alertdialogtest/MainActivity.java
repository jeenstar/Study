package com.example.yujeen.alertdialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView text;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button){
            // AlertDialog.Builder builder = new AlertDialog.Builder(this);//builder pattern
            //빌더의 생성자를 통해서 생성
            //밑의 메서드들은 다 builder로 반환!
            /*builder.setTitle("알립니다");
            builder.setMessage("대화상자를 열었습니다.");
            builder.setIcon(android.R.drawable.ic_delete);
            builder.show();*/
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_delete)
                    .setTitle("알립니다")
                    .setMessage("대화상자를 열었습니다.")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            text.setText("대화상자가 호출되었습니다");
                        }
                    })
                    .setNegativeButton("취소", /*new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            text.setText("위에 버튼을 눌러 대화상자를 호출하세요");
                        }
                    }*/null)
                    .setCancelable(false)//무조건 버튼을 눌러야만 창이 꺼짐!!중요한내용을 체크할때?쓰는것!
                    .show();
        }
    }

}
