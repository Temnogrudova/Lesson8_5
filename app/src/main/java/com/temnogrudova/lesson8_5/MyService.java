package com.temnogrudova.lesson8_5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

  final String LOG_TAG = "myLogs";
  public void onCreate() {
    super.onCreate();
    Log.d(LOG_TAG, "MyService onCreate");
  }


  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(LOG_TAG, "MyService onStartCommand");

    int a = intent.getIntExtra("a", 0);
    int b = intent.getIntExtra("b", 0);
    getSum(a, b);

    return super.onStartCommand(intent, flags, startId);
  }


  public IBinder onBind(Intent intent) {
    Log.d(LOG_TAG, "MyService onBind");
    return new Binder();
  }

  public void onRebind(Intent intent) {
    super.onRebind(intent);
    Log.d(LOG_TAG, "MyService onRebind");
  }
  
  public boolean onUnbind(Intent intent) {
    Log.d(LOG_TAG, "MyService onUnbind");
    return super.onUnbind(intent);
  }
  
  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "MyService onDestroy");
  }



  void getSum(int a, int b) {
    int s = a+b;
    Intent intent = new Intent(MainActivity.BROADCAST_ACTION);
    intent.putExtra("res", s);
    sendBroadcast(intent);
  }

}