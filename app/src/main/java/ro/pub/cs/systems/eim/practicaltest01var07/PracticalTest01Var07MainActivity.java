package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        t00 = findViewById(R.id.t00);
        t01 = findViewById(R.id.t01);
        t10 = findViewById(R.id.t10);
        t11 = findViewById(R.id.t11);

        set = findViewById(R.id.set);
        ButLis butLis = new ButLis();
        set.setOnClickListener(butLis);
    }
}
