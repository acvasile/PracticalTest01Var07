package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public class MessageReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("my.action"))
        {
            Log.d("MAIN", "Mesasge received.");


            PracticalTest01Var07MainActivity.getInstance().setText(
                    Integer.toString(intent.getIntExtra("a", 0)),
                    Integer.toString(intent.getIntExtra("b", 0)),
                    Integer.toString(intent.getIntExtra("c", 0)),
                    Integer.toString(intent.getIntExtra("d", 0))
            );
        }
    }
}