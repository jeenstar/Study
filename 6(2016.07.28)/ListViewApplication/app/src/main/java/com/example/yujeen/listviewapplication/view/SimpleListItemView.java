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
    private String[] image = {};
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
                .load("http://cfile219.uf.daum.net/image/240D0E48555A85D61D3C01")
                .into(imageView);
        textView.setText(str);
    }
}
