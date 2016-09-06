package com.dhha22.kakaoprofile;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dhha22.kakaoprofile.util.Navigator;
import com.dhha22.kakaoprofile.view.ListHeaderView;
import com.dhha22.kakaoprofile.view.ListItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.listview) ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<String> arGeneral;
    private String gender;

    //private static final int  = 816;
    //private static final String TAG = "MainActivity";태그
    //Log.i()아이 information  이 error  디  debug-어디서 어떤 부분이 실행되는지 알고싶을때   색깔이 다르게떠!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        arGeneral = new ArrayList<String>();//이름과 성별항목을 ArrayList를 이용하여 추가
        arGeneral.add("이름");
        arGeneral.add("성별");

        ListHeaderView header = new ListHeaderView(this);
        //View item = getLayoutInflater().inflate(R.layout.list_item,null,false);

        listView.addHeaderView(header);
        header.setData(getPhoneNumber());
        //listView.addFooterView(item);

        adapter = new ListViewAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onItemClickListener);


    }



    int selectedPos = -1;
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectedPos = position-1;
            if(selectedPos == 0){
                //Toast.makeText(MainActivity.this, "이름 변경창으로 슝슝", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(MainActivity.this, ActivityName.class);
                startActivityForResult(intent, Navigator.NAME_ACTIVITY);*/
                Navigator.goText(MainActivity.this, arGeneral.get(0).toString(),Navigator.NAME_ACTIVITY);
            }
            else if(selectedPos == 1) {
                //Toast.makeText(MainActivity.this, "성별 변경창으로 슝슝", Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(MainActivity.this, ActivityGender.class);
                startActivityForResult(intent,Navigator.GENDER_ACTIVITY);*/
                Navigator.goText(MainActivity.this, arGeneral.get(1).toString(), Navigator.GENDER_ACTIVITY);

                /*intent = getIntent();
                gender = intent.getStringExtra("gender");
                if(gender.equals("여자") || gender.equals("남자")){
                    arGeneral.set(0,gender);
                }*/

            }
        }
    } ;
    public String getPhoneNumber(){
        TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = telManager.getLine1Number();
        return phoneNumber;
    }
    private class ListViewAdapter extends BaseAdapter {
        private Context context;


        public ListViewAdapter(Context context) {
            this.context = context;


        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public int getCount() {
            return arGeneral.size();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ListItemView v;


            if(view == null){
                v = new ListItemView(context);
            }else {
                v = (ListItemView) view;
            }

            v.setData(arGeneral.get(i));

            return v;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == Navigator.NAME_ACTIVITY) {
                String result = data.getStringExtra("name");

                arGeneral.set(0,result);
                Toast.makeText(MainActivity.this, result + "값이 넘어와떠"+requestCode+"이건 리퀘스트코드", Toast.LENGTH_SHORT).show();
            }
            if(requestCode == Navigator.GENDER_ACTIVITY) {
                String result = data.getStringExtra("gender");
                Toast.makeText(MainActivity.this, result + "값이 넘어와떠"+requestCode+"이건 리퀘스트코드", Toast.LENGTH_SHORT).show();
                arGeneral.set(1,result);
            }

        }
    }
}
