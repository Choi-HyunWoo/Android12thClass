package com.example.administrator.android12thclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ex03Activity extends AppCompatActivity {

    ThreadAnimationView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03);

        imageView = (ThreadAnimationView) findViewById(R.id.imageView);

    }
}
