package com.example.yujeen.recyclerviews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.yujeen.recyclerviews.model.SampleModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //어댑터는 리스트를 가져와서 뿌리기만해줘!
    //리싸이클러뷰는 레이아웃매니저가 필요해 틀을 관리해주는 아이 내가 커스텀에서 바꿀수있어
    //크게 세가지로 나뉘어져 리니어, 그리드(네모네모네모일정), 스태거드그리드(뒤죽박죽 레이아웃)
    //http://dhha22.com/?p=169찹고
    //레이아웃매니저 설정 안해준면 실행이 안됨!!!!!
    //뷰홀더패턴: 리스트뷰는 재활용이 잘 되지않아!!뷰홀더를 이용하면 더 정확하게 성능이 뛰어나게 재활용할수잇어!!
    //연습많이해야해!!!

    private RecyclerView recyclerView;
    private SampleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SampleAdapter(this);//어댑터를 만들어
        recyclerView.setAdapter(adapter);//어댑터랑 리사이클러뷰랑 연결해
        adapter.setData(makeDummyData());
    }
    private List<SampleModel> makeDummyData(){
        List<SampleModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SampleModel sampleModel = new SampleModel();
            sampleModel.setText("유진유진" + i);
            list.add(sampleModel);
        }
        return list;

    }
    private class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.Holder> {
        private Context context;
        private List<SampleModel> list = new ArrayList<>();

        public SampleAdapter(Context context) {
            this.context = context;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {//첫작업이여서 객체를 만들어줘야해
            return new Holder(new SimpleListItemView(context));
            //뉴홀더는 생성자, 그리고 뉴심플리스트아이템뷰는 컨텍스트가 들어가도록 설정했기때문에 컨텍스트를 써줘야해
            //이걸하면 줄 1줄이 생성되는거야!
            //한번만 딱 호출이 되기때문에 재사용할수있게되는거야!
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            //데이터랑 뷰를 묶어주는 작업을 하니까 자주 호출되는 아이야
            //겟뷰랑 똑같다고생각해!
            //데이터는 리스트에 들어있어!!
            //뷰는 브이야
            holder.v.setData(list.get(position).getText());
            //리스트.겟포지션까지하면 샘플 모델을 불러오는거고 여기서 겟텍스트를 해줘서 텍스트를 가져와야해!


        }

        @Override
        public int getItemCount() {//보여주는 갯수야 이거 설정 안해주면 안보여줘
            return list.size();//중요해중요해
        }

        public void setData(List<SampleModel> data) {
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
        public class Holder extends RecyclerView.ViewHolder{//홀더는 리사이클러뷰의 뷰홀더를 상속받아!
            final SimpleListItemView v;
            public Holder(View itemView) {
                super(itemView);
                v = (SimpleListItemView)itemView;//아이템뷰는 뷰이기때문에 샘플리스트아이템뷰로 캐스팅해줘야해
            }
        }
    }
}
