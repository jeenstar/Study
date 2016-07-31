package com.example.yujeen.listviewapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yujeen.listviewapplication.R;
import com.example.yujeen.listviewapplication.model.Content;

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
        Content content = new Content();
        if(str.equals("피카츄")){
            return content.url_ElectricMouse;
        }else if(str.equals("파이리")) {
            return content.url_FireDinosaur;
        }else if(str.equals("꼬부기")) {
            return content.url_WaterTurtle;
        }else if(str.equals("뽀로로")) {
            return content.url_Pororo;
        }else if(str.equals("루피")) {
            return content.url_Loopy;
        }else if(str.equals("패티")) {
            return content.url_Petty;
        }else if(str.equals("도라에몽")) {
            return content.url_Doraemon;
        }else if(str.equals("잠만보")){
            return content.url_SleepingBear;
        }else if(str.equals("하동님")){
            return content.url_Hadong;
        }else if(str.equals("디효닝")){
            return content.url_Dhyoning;
        }else if(str.equals("숨언닝")){
            return content.url_SoomSis;
        }else if(str.equals("우영님")){
            return content.url_WooZero;
        }
        return content.url_Android;
    }
}
