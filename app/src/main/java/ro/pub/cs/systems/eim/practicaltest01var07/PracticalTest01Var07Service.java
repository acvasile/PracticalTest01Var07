package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;


public class PracticalTest01Var07Service extends Service
{
    class ProcessThread extends Thread
    {
        Context context;
        AtomicBoolean isRunning = new AtomicBoolean();
        Random random = new Random();
        private static final int SLEEP_TIME = 10000;
        private static final int RAND_BOUND = 100;

        ProcessThread(Context context)
        {
            this.context = context;
            this.isRunning.set(true);
        }

        @Override
        public void run()
        {
            while (isRunning.get())
            {
                Log.d("ServiceThread", "Hey im running.");
                sendMessage();
                sleep();
            }

        }

        private void sendMessage()
        {
            Intent intent = new Intent();
            intent.putExtra("a", random.nextInt(RAND_BOUND));
            intent.putExtra("b", random.nextInt(RAND_BOUND));
            intent.putExtra("c", random.nextInt(RAND_BOUND));
            intent.putExtra("d", random.nextInt(RAND_BOUND));
            intent.setAction("my.action");

            context.sendBroadcast(intent);
        }

        private void sleep() {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        public void stopThread() {
            isRunning.set(false);
        }
    }

    ProcessThread processThread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        processThread = new ProcessThread(this);
        processThread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processThread.stopThread();
    }
}
