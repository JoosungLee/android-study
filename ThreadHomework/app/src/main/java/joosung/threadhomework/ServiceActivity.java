package joosung.threadhomework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ServiceActivity extends AppCompatActivity {

    Button mStartButton, mStopButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        mStartButton = (Button) findViewById(R.id.playbtn);
        mStopButton = (Button) findViewById(R.id.stopbtn);


        mStartButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ServiceActivity.this, ServiceClass.class);
                        startService(intent);
                    }
                }
        );

        mStopButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ServiceActivity.this, ServiceClass.class);
                        stopService(intent);
                    }
                }
        );

    }

}