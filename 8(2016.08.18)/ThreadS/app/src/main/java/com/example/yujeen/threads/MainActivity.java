package com.example.yujeen.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //http://dhha22.com/?p=252
    private TextView textView;
    private Button button;
    private Button stopButton;
    private int number;
    private boolean pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);
        stopButton = (Button)findViewById(R.id.stop_button);
        number=0;
        final ThreadTest threadTest = new ThreadTest();
        threadTest.start();//스타트를 해줘야 런메소드가 호출되는거야 안하면 runnable이 안된다능!
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                textView.setText(String.valueOf(
                        /*increaseNumber(
                                Integer.parseInt(textView.getText().toString()))*/
                        number));
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    threadTest.sleep(100);
                }catch(Exception e){

                }

                pause = true;
                threadTest.interrupt();
            }
        });
    }

    private int increaseNumber(int number){
        return number+1;
    }

    public class ThreadTest extends Thread{
        @Override
        public void run() {
            super.run();//런안에 내가수행할 작업을 표시해줘야해
            while(!pause && !ThreadTest.currentThread().isInterrupted()){
                number=increaseNumber(number);
                try{
                    sleep(1000);//1초
                    //슬립은 스레드 안에있는건데 스레드를 상속받았기때문에 스레드.슬립으로 안하고 그냥 슬립만 쓸수있어!
                }catch (Exception e){

                }
                System.out.println("thread");
                System.out.println("thread state" +isInterrupted());
            }
        }
    }
}
