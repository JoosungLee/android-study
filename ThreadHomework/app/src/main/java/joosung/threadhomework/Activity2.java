package joosung.threadhomework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity {

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

        mHandler = new Handler()
        {
            public void handleMessage(Message msg)
            {
                switch (msg.what)
                {
                    case REQUEST_UICHANGE:
                        mTextView.setText("UI Change - Handler의 handlerMessage를 구현");
                }
            }
        };

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        new Thread()
                        {
                            public void run() {

                                Message msg = Message.obtain(mHandler, REQUEST_UICHANGE);

                                mHandler.sendMessage(msg);
                            }
                        }.start();
                    }
                }
        );



    }

}
