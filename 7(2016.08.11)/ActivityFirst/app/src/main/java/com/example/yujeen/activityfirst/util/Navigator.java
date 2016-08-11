package com.example.yujeen.activityfirst.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.yujeen.activityfirst.MainActivity;
import com.example.yujeen.activityfirst.SubActivity;

/**
 * Created by yujeen on 2016. 8. 11..
 */
public class Navigator {//명시적 인텐트!! 내가 정해주는거!
    public static final int SUB_ACTIVITY = 700;
    //이걸 설정한 이유는 onActivityResult...어디로 이동하는지 알려주는거야!절대 겹치면 안됨!!!
    public static void goSub(Context context){//액티비티보다 컨텍스트를 써주는게 더 안전해!
                                              // 액티비티기능쓰고싶으면 타입캐스팅해!
        Intent intent = new Intent(context, SubActivity.class);//(context,class)
        context.startActivity(intent);
    }
    public static void goDial(Context context,String input){
        Intent intent = new Intent(context,SubActivity.class);//Uri 고유주소
        intent.putExtra("input",input);//객체는 못가고 자료형만 갈수있엉!!
        // implement serial어쩌구를 해주면 객체도 보낼수있어!리스트도보낼수있어
        ((Activity)context).startActivityForResult(intent,SUB_ACTIVITY);
        //여기서 서브액티비티 700코드를 보내주는거야
        //서브액티비티가 많아지면 메인에서 어디로 이동하는지 알수없기때문에 코드를 정해주고 startActivityForResult를 해줘!
        //넘어온 정보가 700에서 넘어온게 맞는지 확인해줄때..?!!!

        //디효니는 친절하다.

    }
}
