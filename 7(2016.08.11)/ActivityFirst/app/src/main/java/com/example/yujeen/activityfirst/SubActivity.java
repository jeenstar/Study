package com.example.yujeen.activityfirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by yujeen on 2016. 8. 11..
 */
public class SubActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {//@Nullable NUll값이 와도 안죽어!!!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String inputStr = intent.getStringExtra("input");
        text = (TextView)findViewById(R.id.text);
        text.setText(inputStr);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){//전단계로 고고
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in_from_right,R.anim.out_to_right);
        //인스턴트는 바뀐부분만 빌드해줘!그래서 실행에러난거야!
        // preference->build->instant들어가서 위에 세가지 떴던거 다 지워버려!
    }
}
