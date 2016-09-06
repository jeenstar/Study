package com.dhha22.kakaoprofile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dhha22.kakaoprofile.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DavidHa on 2016. 8. 25..
 */
public class ListItemView extends FrameLayout {
    @BindView(R.id.txt) TextView txt;
    private Context context;
    public ListItemView(Context context) {
        this(context, null);
    }

    public ListItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.list_item,this,true);
        ButterKnife.bind(this);
        this.context = context;
    }
    public void setData(String str){
        txt.setText(str);
    }
}
