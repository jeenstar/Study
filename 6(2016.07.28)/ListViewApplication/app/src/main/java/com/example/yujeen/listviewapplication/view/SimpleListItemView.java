package com.example.yujeen.listviewapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yujeen.listviewapplication.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yujeen on 2016. 7. 28..
 */
public class SimpleListItemView extends FrameLayout{
    @BindView(R.id.text) TextView textView;
    @BindView(R.id.image) CircleImageView imageView;
    private Context context;

    public SimpleListItemView(Context context) {
        this(context,null);
    }

    public SimpleListItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.simple_list_item,this,true);
        ButterKnife.bind(this);
        this.context = context;
    }
    public void setData(String str){
        Glide.with(context)
                .load(imgUrl(str))
                .into(imageView);
        textView.setText(str);
    }
    private String imgUrl(String str){
        if(str.equals("피카츄")){
            return "http://cfile219.uf.daum.net/image/240D0E48555A85D61D3C01";
        }else if(str.equals("파이리")) {
            return "http://cfile24.uf.tistory.com/image/2106534253C62E920DDDE8";
        }else if(str.equals("꼬부기")) {
            return "https://pbs.twimg.com/profile_images/644787063661850624/y-fz5HUy.jpg";
        }else if(str.equals("뽀로로")) {
            return "http://www.iconix.co.kr/img/images/bbororo_off.png";
        }else if(str.equals("루피")) {
            return "https://pbs.twimg.com/media/CfR3yrWUUAA3KZ5.jpg:large";
        }else if(str.equals("패티")) {
            return "https://live3.namuwikiusercontent.com/bd/bd45ab6f296f6df0bba48da02e0d33" +
                    "b22a2c4a31623f3def52a4c6082d33afa6.jpg";
        }else if(str.equals("도라에몽")) {
            return "http://cfile205.uf.daum.net/image/2230B14E541B8B0430D8F5";
        }
        return "http://www.econovill.com/news/photo/201601/278657_85141_1631.jpg";
    }
}
