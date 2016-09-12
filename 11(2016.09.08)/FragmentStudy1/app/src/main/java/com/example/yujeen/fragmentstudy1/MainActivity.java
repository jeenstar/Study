package com.example.yujeen.fragmentstudy1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //Activity는 FragmentActivity를 상속받지 않았기 때문에 액티비티를 써주면 프래그먼트매니저를 쓰지못해
    //AppCompatActivity는 프래그먼트액티비티를 상속받았기 때문에 괜찮아!!
    private static final String TAG = "MainActivity";
    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);



    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btn1){
                Log.d(TAG,"onCreate: create fragment1 manager");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new SampleFragment());
                //애드보다는 리플레이스! 기존의것이 있으면 확인을 해줘야해!이프문을써서! 그래서 리플레이스 해주는게 좋아
                fragmentTransaction.commit();
                Log.d(TAG, "onCreate: fragment1 commit");
            }
            else if(view.getId()==R.id.btn2){
                Log.d(TAG,"onCreate: create fragment2 manager");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new SampleFragment2());
                //애드보다는 리플레이스! 기존의것이 있으면 확인을 해줘야해!이프문을써서! 그래서 리플레이스 해주는게 좋아
                fragmentTransaction.commit();
                Log.d(TAG, "onCreate: fragment2 commit");
            }
            else if(view.getId()==R.id.btn3){
                Log.d(TAG,"onCreate: create fragment3 manager");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new SampleFragment3());
                //애드보다는 리플레이스! 기존의것이 있으면 확인을 해줘야해!이프문을써서! 그래서 리플레이스 해주는게 좋아
                fragmentTransaction.commit();
                Log.d(TAG, "onCreate: fragment3 commit");
            }
            else if(view.getId()==R.id.btn4){
                Log.d(TAG,"onCreate: create fragment4 manager");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, new SampleFragment4());
                //애드보다는 리플레이스! 기존의것이 있으면 확인을 해줘야해!이프문을써서! 그래서 리플레이스 해주는게 좋아
                fragmentTransaction.commit();
                Log.d(TAG, "onCreate: fragment4 commit");
            }

        }
    };

}
