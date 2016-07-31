package com.example.yujeen.listviewapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
    private ArrayList<String> arGeneral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        arGeneral = new ArrayList<String>();
        arGeneral.add("안드로");
        arGeneral.add("로이드");
        arGeneral.add("안연두");

        adapter = new MyArrayAdapter(this);
        //adapter.setData(arGeneral);

        list.setAdapter(adapter);
        btn.setOnClickListener(this);
        list.setOnItemLongClickListener(longClickListener);
    }
    int selectedPos = -1;
    AdapterView.OnItemLongClickListener longClickListener
            = new AdapterView.OnItemLongClickListener(){
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            selectedPos = position;
            final AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
            alert.setTitle("물어볼게 있어!!")
                    .setMessage(arGeneral.get(position)+" : 나 지울거야...??")
                    .setPositiveButton("지울거야", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "정말로 지우다니..힝..ㅠㅜ",
                                    Toast.LENGTH_SHORT).show();
                            arGeneral.remove(selectedPos);
                            adapter.notifyDataSetChanged();

                        }
                    })
                    .setNegativeButton("안지울거야", null)
                    .setCancelable(false)
                    .show();
            return false;
        }
    };
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
        public MyArrayAdapter(Context context) {
            this.context = context;
        }
        @Override
        public int getCount() {
            return arGeneral.size();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final SimpleListItemView v;
            if(convertView == null){
                v = new SimpleListItemView(context);
            }else{
                v = (SimpleListItemView)convertView;
            }
            v.setData(arGeneral.get(position));
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
            arGeneral.addAll(data);
            notifyDataSetChanged();
        }
    }
}
