package com.example.yujeen.optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//오른쪽위에 생성될 메뉴
        /*MenuItem item = menu.add(0,1,0,"짜장");

        menu.add(0,2,0,"짬뽕");

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);//xml파일 가져와서 뿌려줍니당, 메뉴랑 연결을 안시켜주면 뜨지않아!!

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.jjajang:
                Toast.makeText(this, "짜장은 맛있엉", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.jjambbong:
                Toast.makeText(this, "짬뽕은 매웡", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.udong:
                Toast.makeText(this, "우동은 뜨거웡", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mandoo:
                Toast.makeText(this, "만두도 뜨거웡", Toast.LENGTH_SHORT).show();
                return true;

        }
        return false;
    }
}
