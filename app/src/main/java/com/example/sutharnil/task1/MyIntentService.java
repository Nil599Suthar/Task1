package com.example.sutharnil.task1;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {


    private static final String TAG=MyIntentService.class.getName();

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate "+Thread.currentThread().getName());

        Toast.makeText(this, "MyIntentService :  onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "MyIntentService :  onStartCommand", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags,startId);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"onHandle Thread= "+Thread.currentThread().getName());
        int sleep=intent.getIntExtra("sleep",1);
        int ctr=0;
        while (ctr<1000){
            Log.i(TAG,"sleeping Thread= "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctr++;
        }

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyIntentservice : onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"Destroy "+Thread.currentThread().getName());

        super.onDestroy();

    }
}
