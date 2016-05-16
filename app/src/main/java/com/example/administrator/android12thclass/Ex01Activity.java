package com.example.administrator.android12thclass;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ex01Activity extends AppCompatActivity {

    Button btn;
    TextView textView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);

        textView = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btn_thread);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestThread thread = new RequestThread();             // 스레드를 start해도 run() 메소드가 호출
                thread.start();
            }
        });
        btn = (Button) findViewById(R.id.btn_handler);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    private static final String TAG = "태그";

    class RequestThread extends Thread {
        public void run() {
            for (int i=0; i<100; i++) {
                println("#"+i+" : 호출됨");

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void println(String data) {
            Log.d(TAG, data);

            handler.post(new Runnable() {       // 핸들러 runnable
                @Override
                public void run() {
                    // 핸들러가 순서대로 처리할 일 (Main Thread에서 수행)
                }
            });
        }
    }


}
