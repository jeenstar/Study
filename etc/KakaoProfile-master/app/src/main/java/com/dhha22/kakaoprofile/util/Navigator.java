package com.dhha22.kakaoprofile.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.dhha22.kakaoprofile.ActivityGender;
import com.dhha22.kakaoprofile.ActivityName;
import com.dhha22.kakaoprofile.MainActivity;

/**
 * Created by yujeen on 2016. 8. 11..
 */
public class Navigator {//명시적 인텐트!! 내가 정해주는거!
    public static final int GENDER_ACTIVITY = 700;
    public static final int NAME_ACTIVITY = 800;

    //이걸 설정한 이유는 onActivityResult...어디로 이동하는지 알려주는거야!절대 겹치면 안됨!!!
    public static void goMain(Context context){//액티비티보다 컨텍스트를 써주는게 더 안전해!
                                              // 액티비티기능쓰고싶으면 타입캐스팅해!
        Intent intent = new Intent(context, MainActivity.class);//(context,class)
        context.startActivity(intent);
    }
    public static void goText(Context context,String input,int code){
        if(code==GENDER_ACTIVITY) {
            Intent intent = new Intent(context, ActivityGender.class);//Uri 고유주소
            intent.putExtra("gender", input);
            ((Activity) context).startActivityForResult(intent, GENDER_ACTIVITY);
        }
        else if(code==NAME_ACTIVITY){
            Intent intent = new Intent(context, ActivityName.class);//Uri 고유주소
            intent.putExtra("name", input);
            ((Activity) context).startActivityForResult(intent, NAME_ACTIVITY);
        }

    }
}
