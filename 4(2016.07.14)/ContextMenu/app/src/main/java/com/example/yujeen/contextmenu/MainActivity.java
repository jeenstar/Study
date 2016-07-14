package com.example.yujeen.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.text);
        registerForContextMenu(button);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v == button){
            menu.setHeaderTitle("텍스트 색상 변경");
            menu.add(0,1,0,"빨강");
            menu.add(0,2,0,"녹색");
            menu.add(0,3,0,"검정");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                text.setTextColor(Color.RED);
                return true;
            case 2:
                text.setTextColor(Color.GREEN);
                return true;
            case 3:
                text.setTextColor(Color.BLACK);
                return true;

        }
        return true;
    }
}
