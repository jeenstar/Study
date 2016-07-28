package com.example.yujeen.listviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yujeen.listviewtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yujeen on 2016. 7. 28..
 */
public class SimpleListItemView extends FrameLayout{
    @BindView(R.id.text) TextView textView;
    @BindView(R.id.image) ImageView imageView;
    private Context context;
    public SimpleListItemView(Context context) {
        this(context,null);//아래로
    }

    public SimpleListItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);//아래로
    }

    public SimpleListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//여기서 코드를 짜야해

        //setContentView랑 비슷
        //LayoutInflater은 따로 공부 해보ㅏ!!
        LayoutInflater.from(context).inflate(R.layout.simple_list_item, this, true);
        ButterKnife.bind(this);
        this.context = context;
    }
    public void setData(String str){
        Glide.with(context)
        .load("http://cfile219.uf.daum.net/image/240D0E48555A85D61D3C01")
        .into(imageView);
        textView.setText(str);
    }


}
