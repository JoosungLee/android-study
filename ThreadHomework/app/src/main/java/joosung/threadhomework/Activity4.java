package joosung.threadhomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity4 extends AppCompatActivity {

    TextView mTextView = null;
    Button mButton= null;
    String switchState = null;
    String recordOfSwitch = "";
    Boolean boolSwitch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadsynctest);

        mTextView = (TextView) findViewById(R.id.synctext);
        mButton = (Button) findViewById(R.id.btn01);

        SyncSwitchThread thread1 = new SyncSwitchThread();
        SyncSwitchThread thread2 = new SyncSwitchThread();
        thread1.start();
        thread2.start();


        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mTextView.setText(recordOfSwitch);
//                        mTextView2.setText(switchOff);
                    }
                }
        );

    }

    class SyncSwitchThread extends Thread {
        public void run() {
            while(true) {

                SyncSwitch();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 스위치는 켜는중/끄는중 상태를 거쳐 켬/끄기상태로 진행된다.
    public synchronized void SyncSwitch() {

        if(boolSwitch){
            switchState = "SWITCH ON! --- 스위치켜는중 ";
        } else {
            switchState = "SWITCH OFF! --- 스위치끄는중 ";
        }

        recordOfSwitch += switchState;


        if(boolSwitch){
            switchState = "SWITCH ON! --- 스위치켜기완료 ";
            boolSwitch = false;
        } else {
            switchState = "SWITCH OFF! --- 스위치끄기완료 ";
            boolSwitch = true;
        }

        recordOfSwitch += switchState;


    }
}