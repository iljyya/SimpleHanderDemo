package com.iljyya.handerdemo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView show;
    public Handler showhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.show);
        StringBuffer text = new StringBuffer();
        text.append("text view: wait 3s");
        show.setText(text);
        showhandler = new Handler();
        new Thread_1().start();
        new Thread_2().start();

    }


    class Thread_1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showhandler.post(new Runnable() {
                @Override
                public void run() {
                    String line = "\n";
                    StringBuffer text = new StringBuffer(show.getText());
                    text.append(line).append("handler msg 2s thread 1");
                    show.setText(text);
                }

            });
        }
    }



    class Thread_2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showhandler.post(new Runnable() {
                @Override
                public void run() {
                    String line = "\n";
                    StringBuffer text = new StringBuffer(show.getText());
                    text.append(line).append("handler msg 3s thread 2");
                    show.setText(text);
                }

            });
        }
    }
}


