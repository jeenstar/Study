package com.example.yujeen.viewpagerstudy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yujeen on 2016. 9. 8..
 */
public class SampleFragment extends Fragment {
    //inflate는 뷰가 반한된다
    private static final String TAG = "SampleFragment";

    private TextView textView;
    private String name;

    // 프래그먼트 특성이 디폴트밖에 못가!!!->비어있는 생성자! 전달하는 값이 없는거!
    public SampleFragment() {
    }

    public static SampleFragment newInstance(String str){//이걸 통해 데이터를 전달해
        SampleFragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        //데이터를 보내주는거
        bundle.putString("name",str);
        //인텐트 보내는거랑 똑같네! 이 번들은 뷰가 다 생성되면 가져와
        // 프래그먼트는 번들, 액티비티는 인텐트를 통해 값을 전달
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = getArguments().getString("name");//번들에 있는 값을 가져와주는거야 겟인텐트랑 똑같아;
        textView.setText(name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_sample,container,false);
        textView = (TextView)view.findViewById(R.id.text);

        Log.d(TAG, "onCreateView: fragment");
        return view;
    }


}
