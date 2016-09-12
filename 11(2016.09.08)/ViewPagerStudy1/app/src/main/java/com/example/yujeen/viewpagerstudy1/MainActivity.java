package com.example.yujeen.viewpagerstudy1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Adapter adapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new Adapter(getSupportFragmentManager());//프래그먼트는 매니저가 꼭 필요해!
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }

    private class Adapter extends FragmentStatePagerAdapter{
        private List<String> list = Arrays.asList("Soom T", "Ulzzang Ki", "Red Jh", "David Ha");
        public Adapter(FragmentManager fm) {
        super(fm);
    }
        @Override
        public Fragment getItem(int position) {

            return SampleFragment.newInstance(list.get(position));
        }

        @Override
        public int getCount() {
            return list.size();
        }


    }
}
