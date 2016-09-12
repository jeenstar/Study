package com.example.yujeen.fragmentstudy1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yujeen on 2016. 9. 8..
 */
public class SampleFragment4 extends Fragment {
    //inflate는 뷰가 반한된다
    private static final String TAG = "SampleFragment4";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_sample4,container,false);

        Log.d(TAG, "onCreateView: fragment4");
        return view;
    }


}
