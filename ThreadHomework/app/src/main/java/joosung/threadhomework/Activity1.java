package joosung.threadhomework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity1 extends AppCompatActivity {

    TextView mTextView = null;
    Button mButton = null;
    Handler mHandler = null;
    final int REQUEST_UICHANGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadtest);

        mTextView = (TextView) findViewById(R.id.text);
        mButton = (Button) findViewById(R.id.btn);

        mHandler = new Handler();

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        new Thread()
                        {
                            public void run() {
                                Runnable runnable = new Runnable() {
                                    public void run() {
                                        mTextView.setText("UI Change - Runnable 객체의 run()을 구현하여 핸들러로 메시지를 보냄");
                                    }
                                };


                                Message msg = Message.obtain(mHandler, runnable);

                                mHandler.sendMessage(msg);
                            }
                        }.start();

                    }
                }
        );



    }

}
