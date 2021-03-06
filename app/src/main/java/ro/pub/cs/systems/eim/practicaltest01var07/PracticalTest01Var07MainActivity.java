package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    EditText t00;
    EditText t01;
    EditText t10;
    EditText t11;
    Button set;

    class ButLis implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.set:
                {
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    int d = 0;
                    try
                    {
                        a = Integer.parseInt(t00.getEditableText().toString());
                        b = Integer.parseInt(t01.getEditableText().toString());
                        c = Integer.parseInt(t10.getEditableText().toString());
                        d = Integer.parseInt(t11.getEditableText().toString());
                    }
                    catch (Exception ex)
                    {
                        return;
                    }
                    Intent intent = new Intent(PracticalTest01Var07MainActivity.this, PracticalTest01Var07SecondaryActivity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    intent.putExtra("d", d);
                    startActivity(intent);
                    break;
                }
            }
        }
    }

    MessageReceiver messageReceiver = new MessageReceiver();
    IntentFilter intentFilter = new IntentFilter();

    private static PracticalTest01Var07MainActivity activity;
    public static PracticalTest01Var07MainActivity getInstance()
    {
        return activity;
    }

    void restoreBundle(Bundle savedInstanceState)
    {
        if (savedInstanceState == null)
        {
            return;
        }

        if (savedInstanceState.containsKey("a"))
        {
            t00.setText(savedInstanceState.getString("a"));
        }
        if (savedInstanceState.containsKey("b"))
        {
            t01.setText(savedInstanceState.getString("b"));
        }
        if (savedInstanceState.containsKey("c"))
        {
            t10.setText(savedInstanceState.getString("c"));
        }
        if (savedInstanceState.containsKey("d"))
        {
            t11.setText(savedInstanceState.getString("d"));
        }
    }

    void setText(final String a, final String b, final String c, final String d)
    {
        PracticalTest01Var07MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                t00 = findViewById(R.id.t00);
                t01 = findViewById(R.id.t01);
                t10 = findViewById(R.id.t10);
                t11 = findViewById(R.id.t11);

                t00.setText(a);
                t01.setText(b);
                t10.setText(c);
                t11.setText(d);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_practical_test01_var07_main);

        t00 = findViewById(R.id.t00);
        t01 = findViewById(R.id.t01);
        t10 = findViewById(R.id.t10);
        t11 = findViewById(R.id.t11);

        restoreBundle(savedInstanceState);

        set = findViewById(R.id.set);
        ButLis butLis = new ButLis();
        set.setOnClickListener(butLis);

        intentFilter.addAction("my.action");

        Intent intent = new Intent(this, PracticalTest01Var07Service.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var07Service.class);
        stopService(intent);
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("a", t00.getEditableText().toString());
        outState.putString("b", t01.getEditableText().toString());
        outState.putString("c", t10.getEditableText().toString());
        outState.putString("d", t11.getEditableText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreBundle(savedInstanceState);
    }
}
