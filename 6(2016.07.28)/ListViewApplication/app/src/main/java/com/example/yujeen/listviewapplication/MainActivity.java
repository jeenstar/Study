package com.example.yujeen.listviewapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.yujeen.listviewapplication.model.Content;
import com.example.yujeen.listviewapplication.view.SimpleListItemView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btn) Button btn;
    @BindView(R.id.list) ListView list;
    private MyArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn.setOnClickListener(this);

        ArrayList<String> arGeneral = new ArrayList<String>();
        arGeneral.add("안드로");
        arGeneral.add("로이드");
        arGeneral.add("안연두");

        adapter = new MyArrayAdapter(this);
        adapter.setData(arGeneral);

        list.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        Content content = new Content();
        Random random = new Random();
        String[] saveText = new String[content.outputNum];

        for (int i = 0; i < content.outputNum; i++) {
            saveText[i] = content.randomText[random.nextInt(content.randomText.length)];
            for (int j = 0; j < i; j++) {
                if(saveText[i].equals(saveText[j]))
                    i--;
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < content.outputNum; i++) {
            list.add(saveText[i]);
        }
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final SimpleListItemView v;
            if(convertView == null){
                v = new SimpleListItemView(context);
            }else{
                v = (SimpleListItemView)convertView;
            }
            v.setData(data.get(position));
            return v;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
        public void setData(List<String> data){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
}
