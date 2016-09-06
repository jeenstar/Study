package com.dhha22.kakaoprofile;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dhha22.kakaoprofile.util.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yujeen on 2016. 8. 27..
 */
public class ActivityGender extends AppCompatActivity{
    @BindView(R.id.radio_m) RadioButton radioM;
    @BindView(R.id.radio_w) RadioButton radioW;
    @BindView(R.id.gender) RadioGroup gender;
    private String result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        result= intent.getStringExtra("gender");
        if(result.equals("남자")){
            radioM.setChecked(true);
        }
        else if(result.equals("여자")){
            radioW.setChecked(true);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.home){
            Intent intent = new Intent();
            intent.putExtra("gender",result);
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }
        if (id == R.id.button_check) {
            if(gender.getCheckedRadioButtonId()==radioM.getId()){
                result = "남자";
                Intent intent = new Intent();
                intent.putExtra("gender",result);
                setResult(RESULT_OK,intent);
                finish();

            }else if(gender.getCheckedRadioButtonId()==radioW.getId()){
                result="여자";
                Intent intent = new Intent();
                intent.putExtra("gender",result);
                setResult(RESULT_OK,intent);
                finish();

            }
            else{
                Toast.makeText(ActivityGender.this, "성별을 체크해주세요", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
    @Override
    public void finish() {//피니쉬가 먼저 실행되어지고 그다음에 온백프레스드 뒤로가기버튼이 실행되는거야!
        Intent intent = new Intent();
        intent.putExtra("gender",result);
        setResult(RESULT_OK,intent);
        super.finish();
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_right);
        //인스턴트는 바뀐부분만 빌드해줘!그래서 실행에러난거야!
        // preference->build->instant들어가서 위에 세가지 떴던거 다 지워버려!
    }
}
