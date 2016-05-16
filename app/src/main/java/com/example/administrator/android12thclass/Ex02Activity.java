package com.example.administrator.android12thclass;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Ex02Activity extends AppCompatActivity {

    Button btn;
    TextView textView;
    ProgressBar progressBar;
    BackgroundTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);

        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new BackgroundTask();
                task.execute(100);
            }
        });
    }

    int value;
    // Async Thask roqkfd
    class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            value = 0;
            progressBar.setProgress(value);
            textView.setText("중지됨");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            while (!isCancelled()) {
                value++;
                if (value >= 100) {
                    break;
                } else {
                    publishProgress(value);
                }

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }

}
