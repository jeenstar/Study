package com.example.yujeen.recyclerviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by yujeen on 2016. 8. 18..
 */
public class SimpleListItemView extends FrameLayout{
    //심플리스트아이템뷰를 관리해줘
    //이렇게 만들어주면 엑셈엘에서 불러와서 스타일을 설정해줄수있어! 세개하는게 좋아!
    private TextView textView;
    public SimpleListItemView(Context context) {
        this(context,null);
    }

    public SimpleListItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.simple_list_item,this,true);
        //인플레이트를 쓰려면 꼭 컨텍스트를 써줘야해
        //.inflate의 반환형이 뷰야!그래서 뷰에 저장해주고 파인드뷰바이 아이디를 뷰.파인드바이아이디 해줘!!
        //프래그먼트?할때는 뷰에다 저장해서 해줘야하는데 여기서는 꼭 뷰를 붙이지 않아도 괜찮아!
        //이 부분은 셋컨텐트뷰랑 똑같아
        //첫번째는 가져올 엑스엠엘,두번째는 뷰그룹의 루트(엑셈엘 파일을 가져오는데 어디다 붙일지 설정하는건데
        // 우리는 여기다 붙일거기때문에 this를 써주는거야),그리고 붙일지 말지 트루폴스로 결정!!
        //레이아웃인플레이터..프롬...반환형이 레이아웃인플레이터
        //파인드뷰바이아이디는 셋컨텐트뷰로 뿌려진다음에 써줘야해!!
        setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        textView = (TextView)view.findViewById(R.id.text);
    }
    public void setData(String str){
        textView.setText(str);
    }
}
