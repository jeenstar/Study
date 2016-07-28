package com.example.yujeen.listviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.yujeen.listviewtest.view.SimpleListItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.button) Button btn;
    private MyArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn.setOnClickListener(this);
        ArrayList<String> arGeneral = new ArrayList<String>();
        arGeneral.add("김유신");
        arGeneral.add("이순신");
        arGeneral.add("강감찬");
        arGeneral.add("을지문덕");
/*
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                arGeneral);*/

        adapter = new MyArrayAdapter(this);
        adapter.setData(arGeneral);

        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        List<String> list = new ArrayList<>();
        list.add("추가된 아이템1");
        list.add("추가된 아이템2");
        list.add("추가된 아이템3");
        adapter.setData(list);
    }

    public class MyArrayAdapter extends BaseAdapter{
        private Context context;
        private List<String> data = new ArrayList<>();
        public MyArrayAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        //중요해중요해중요중요
       @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           final SimpleListItemView v;
           if(convertView == null){
               v = new SimpleListItemView(context);
           }else{
               //재사용해줘
               v = (SimpleListItemView)convertView;
           }
           v.setData(data.get(position));
           return v;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }
        public void setData(List<String> data){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
}
