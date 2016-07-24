package com.example.yujeen.exercise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyView vw;

    private LinearLayout drawWindow;

    private Button btn_color;
    private Button btn_size;
    private Button btn_clear;

    private Color select_color;
    private int select_size;

    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);

        setContentView(R.layout.activity_main);

        btn_color = (Button) findViewById(R.id.color);
        btn_size = (Button) findViewById(R.id.size);
        btn_clear = (Button) findViewById(R.id.clear);
        drawWindow = (LinearLayout) findViewById(R.id.drawWindow);
        drawWindow.addView(vw);
        arVertex = new ArrayList<Vertex>();

        btn_color.setOnClickListener(listener);
        btn_size.setOnClickListener(listener);
        btn_clear.setOnClickListener(listener);

    }

    public class Vertex {
        Vertex(float ax, float ay, boolean ad) {
            x = ax;
            y = ay;
            Draw = ad;
        }

        float x;
        float y;
        boolean Draw;
    }


    protected class MyView extends View {
        Paint mPaint;

        public MyView(Context context) {
            super(context);

            mPaint = new Paint();
            mPaint.setColor(Color.BLACK);
            mPaint.setStrokeWidth(3);
            mPaint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            for (int i = 0; i < arVertex.size(); i++) {
                if (arVertex.get(i).Draw) {
                    canvas.drawLine(arVertex.get(i - 1).x, arVertex.get(i - 1).y, arVertex.get(i).x,
                            arVertex.get(i).y, mPaint);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.color:
                    popupmenu_color();
                    break;
                case R.id.size:
                    popupmenu_size();
                    break;
                case R.id.clear:
                    arVertex.clear();
                    vw.invalidate();
                    break;
            }
        }
    };

    public void popupmenu_color() {
        PopupMenu menu_color = new PopupMenu(MainActivity.this, vw);
        menu_color.getMenuInflater().inflate(R.menu.mcolor, menu_color.getMenu());
        menu_color.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.color_red:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_red));
                        break;
                    case R.id.color_orange:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_orange));
                        break;
                    case R.id.color_yellow:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_yellow));
                        break;
                    case R.id.color_green:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_green));
                        break;
                    case R.id.color_blue:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_blue));
                        break;
                    case R.id.color_purple:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_purple));
                        break;
                    case R.id.color_pink:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_pink));
                        break;
                    case R.id.color_mint:
                        vw.mPaint.setColor(getResources().getColor(R.color.color_mint));
                        break;
                }
                return true;
            }
        });
        menu_color.show();
    }

    public void popupmenu_size() {
        PopupMenu menu_size = new PopupMenu(MainActivity.this, vw);
        menu_size.getMenuInflater().inflate(R.menu.msize, menu_size.getMenu());
        menu_size.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.size_1:
                        vw.mPaint.setStrokeWidth(1);
                        break;
                    case R.id.size_2:
                        vw.mPaint.setStrokeWidth(2);
                        break;
                    case R.id.size_3:
                        vw.mPaint.setStrokeWidth(3);
                        break;
                    case R.id.size_4:
                        vw.mPaint.setStrokeWidth(4);
                        break;
                    case R.id.size_5:
                        vw.mPaint.setStrokeWidth(5);
                        break;
                    case R.id.size_6:
                        vw.mPaint.setStrokeWidth(6);
                        break;
                    case R.id.size_7:
                        vw.mPaint.setStrokeWidth(7);
                        break;
                    case R.id.size_8:
                        vw.mPaint.setStrokeWidth(8);
                        break;
                    case R.id.size_9:
                        vw.mPaint.setStrokeWidth(9);
                        break;
                    case R.id.size_10:
                        vw.mPaint.setStrokeWidth(10);
                        break;
                    case R.id.size_11:
                        vw.mPaint.setStrokeWidth(11);
                        break;
                }
                return true;
            }
        });
        menu_size.show();
    }

}
