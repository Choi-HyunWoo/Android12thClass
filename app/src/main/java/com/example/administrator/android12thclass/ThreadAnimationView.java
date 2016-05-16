package com.example.administrator.android12thclass;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-05-16.
 */
public class ThreadAnimationView extends ImageView {
    int[] imageArray = { R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4 };

    boolean running = false;
    Handler handler = new Handler();        // UI 접근은 Main Thread만 가능하므로 Handler를 이용

    public ThreadAnimationView(Context context) {
        super(context);
        init(context);
    }

    public ThreadAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setStart () {
        running = true;
    }
    public void setStop () {
        running = false;
    }

    private void init( Context context ) {
        ImageThread thread = new ImageThread();
        thread.start();
    }

    class ImageThread extends Thread {
        int index = 0;


        public void run() {
            running = true;

            while(running) {

                /* Handler 사용 */
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setImageResource(imageArray[index]);
                        invalidate();
                    }
                });

                /*
                setImageResource(imageArray[index]);
                invalidate();
                */

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                index++;

                if (index > 3) {
                    index = 0;
                }

            }
        }
    }
}



