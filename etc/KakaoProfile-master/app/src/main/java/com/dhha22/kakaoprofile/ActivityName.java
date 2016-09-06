package com.dhha22.kakaoprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dhha22.kakaoprofile.util.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yujeen on 2016. 8. 27..
 */
public class ActivityName extends AppCompatActivity{
    @BindView(R.id.edit_name) EditText editName;
    @BindView(R.id.text_size) TextView textSize;
    @BindView(R.id.btn_x) ImageButton btnX;
    private String inputStr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        inputStr = intent.getStringExtra("name");
        editName.setText(inputStr);
        editName.setSelection(editName.length());
        textSize.setText(String.valueOf(inputStr.length()));

        editName.addTextChangedListener(new TextWatcher() {
            String strCur;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {
                strCur = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(s.length()>20){
                    editName.setText(strCur);
                    editName.setSelection(editName.getText().length());
                    Toast.makeText(ActivityName.this, "이름은 20자 이하만 가능합니다.", Toast.LENGTH_SHORT).show();
                }

                else{

                    textSize.setText(String.valueOf(s.length()));
                }

                if(!textSize.getText().equals("0")){
                    btnX.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                textSize.setText("0");
                btnX.setVisibility(View.INVISIBLE);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.home){
            /*NavUtils.navigateUpFromSameTask(this);
            overridePendingTransition(R.anim.in_from_right,R.anim.out_to_right);
            Toast.makeText(ActivityName.this, "뒤로가기눌려쪙", Toast.LENGTH_SHORT).show();
            return true;*/

            Intent intent = new Intent();
            intent.putExtra("name",inputStr);
            //startActivityForResult(intent, Navigator.NAME_ACTIVITY);
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }
        if (id == R.id.button_check) {
            inputStr=editName.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("name",inputStr);
            //startActivityForResult(intent, Navigator.NAME_ACTIVITY);
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }
        //결과값받고싶으면 폴리절트
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void finish() {//피니쉬가 먼저 실행되어지고 그다음에 온백프레스드 뒤로가기버튼이 실행되는거야!
        Intent intent = new Intent();
        intent.putExtra("name",inputStr);
        setResult(RESULT_OK,intent);
        super.finish();
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_right);
        //인스턴트는 바뀐부분만 빌드해줘!그래서 실행에러난거야!
        // preference->build->instant들어가서 위에 세가지 떴던거 다 지워버려!
    }
}
