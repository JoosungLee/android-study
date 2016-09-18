package joosung.threadhomework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;
import android.os.Handler;

public class ServiceClass extends Service{

    boolean mQuit;

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "서비스 끝", 0).show();
        mQuit = true;
    }

    public int onStartCommand (Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        mQuit = false;
        NewsThread thread = new NewsThread(this, mHandler);
        thread.start();
        return START_STICKY;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    class NewsThread extends Thread {
        ServiceClass mParent;
        Handler mHandler;
        String[] arNews = {
                "test1 test1 test1",
                "test2 test2 test2",
                "test3 test3 test3",
                "test4 test4 test4",
                "test5 test5 test5",
                "test6 test6 test6",
                "test7 test7 test7",
        };
        public NewsThread(ServiceClass parent, Handler handler) {
            mParent = parent;
            mHandler = handler;
        }
        public void run() {
            for (int idx = 0;mQuit == false;idx++) {
                Message msg = new Message();
                msg.what = 0;
                msg.obj = arNews[idx % arNews.length];
                mHandler.sendMessage(msg);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                String news = (String)msg.obj;
                Toast.makeText(ServiceClass.this, news, 0).show();
            }
        }
    };
}