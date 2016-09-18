package joosung.threadhomework;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = (Button) findViewById(R.id.btn1);
        mButton2 = (Button) findViewById(R.id.btn2);
        mButton3 = (Button) findViewById(R.id.btn3);
        mButton4 = (Button) findViewById(R.id.btn4);
        mButton5 = (Button) findViewById(R.id.btn5);
        mButton6 = (Button) findViewById(R.id.btn6);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn1:
                Intent i = new Intent(MainActivity.this, Activity1.class);
                startActivity(i);

                break;

            case R.id.btn2:
                Intent i2 = new Intent(MainActivity.this, Activity2.class);
                startActivity(i2);

                break;

            case R.id.btn3:
                Intent i3 = new Intent(MainActivity.this, Activity3.class);
                startActivity(i3);

                break;

            case R.id.btn4:
                Intent i4 = new Intent(MainActivity.this, Activity4.class);
                startActivity(i4);

                break;

            case R.id.btn5:
                Intent i5 = new Intent(MainActivity.this, ImplicitIntentActivity.class);
                startActivity(i5);

                break;

            case R.id.btn6:
                Intent i6 = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(i6);

                break;
        }

    }
}
