package joosung.threadhomework;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity3 extends AppCompatActivity {

    TextView mTextView = null;
    Button mButton = null;
    TestAsyncTask testAsyncTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadtest);

        mTextView = (TextView) findViewById(R.id.text);
        mButton = (Button) findViewById(R.id.btn);

        testAsyncTask = new TestAsyncTask();

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        testAsyncTask.execute();
                    }
                }
        );

    }

    private class TestAsyncTask extends AsyncTask<String, Integer, Integer>
    {
        @Override
        protected Integer doInBackground(String... strings) {

            try {
                Thread.sleep(5000);
                publishProgress();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
                mTextView.setText("UI Change - AsyncTask 사용 ( onPreExecute )");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

                mTextView.setText("UI Change - AsyncTask 사용 ( onProgressUpdate )");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            mTextView.setText("UI Change - AsyncTask 사용 ( onPostExecute )");
        }
    }

}
