package com.example.administrator.android12thclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /** 160516 12주차

     Chapter 6 - 쓰레드 (DAY 23)

     * 1. 스레드 (Thread)
     * - 메인 스레드가 아닌 스레드에서는 UI 변경이 불가하다.
     *
     *
     * 2. 핸들러 (Handler)
     * - Runnable 사용
     *
     *
     * - 스레드 postDelayed 생략...
     * 3. 루퍼 (Looper) 생략...
     *
     *
     * 4. AsyncTask (Day 25 - 01)
     * - 쓰레드가 완전히 눈에 안보임
     *
     * 5. 쓰레드로 애니메이션 만들기 (Day 26-01)
     * 앞부분 쭉 생략...
     *
     *
     */

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_ex01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ex01Activity.class));
            }
        });

        btn = (Button) findViewById(R.id.btn_ex02);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ex02Activity.class));
            }
        });

        btn = (Button) findViewById(R.id.btn_ex03);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ex03Activity.class));
            }
        });


    }
}
