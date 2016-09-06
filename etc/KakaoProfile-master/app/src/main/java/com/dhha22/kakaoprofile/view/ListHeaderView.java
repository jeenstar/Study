package com.dhha22.kakaoprofile.view;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dhha22.kakaoprofile.MainActivity;
import com.dhha22.kakaoprofile.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DavidHa on 2016. 8. 25..
 */
public class ListHeaderView extends FrameLayout {
    private Context context;
    @BindView(R.id.phone_number_txt) TextView phoneNumber_txt;
    public ListHeaderView(Context context) {
        this(context, null);
    }

    public ListHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_header,this,true);
        ButterKnife.bind(this);
        this.context = context;


    }
    public void setData(String str){
        //phoneNumber_txt.setText(str);
        //notify
        try {
            phoneNumber_txt.setText(str);
        }catch(Exception e){
            Toast.makeText(context, "넘어온 번호는 "+str, Toast.LENGTH_SHORT).show();
        }

    }
}
