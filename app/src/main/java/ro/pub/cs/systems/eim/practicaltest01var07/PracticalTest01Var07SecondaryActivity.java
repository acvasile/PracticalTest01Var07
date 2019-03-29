package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    TextView t00;
    TextView t01;
    TextView t10;
    TextView t11;

    int a;
    int b;
    int c;
    int d;

    Button sum;
    Button prod;

    class ButLis implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sum: {
                    int sum = a + b + c + d;
                    Toast toast = Toast.makeText(PracticalTest01Var07SecondaryActivity.this, Integer.toString(sum), Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                case R.id.prod:
                {
                    int prod = a * b * c * d;
                    Toast toast = Toast.makeText(PracticalTest01Var07SecondaryActivity.this, Integer.toString(prod), Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_sec);

        t00 = findViewById(R.id.At00);
        t01 = findViewById(R.id.At01);
        t10 = findViewById(R.id.At10);
        t11 = findViewById(R.id.At11);

        Intent intent = getIntent();
        a = intent.getIntExtra("a", 0);
        b = intent.getIntExtra("b", 0);
        c = intent.getIntExtra("c", 0);
        d = intent.getIntExtra("d", 0);

        t00.setText(Integer.toString(a));
        t01.setText(Integer.toString(b));
        t10.setText(Integer.toString(c));
        t11.setText(Integer.toString(d));

        sum = findViewById(R.id.sum);
        prod = findViewById(R.id.prod);

        ButLis butLis = new ButLis();
        sum.setOnClickListener(butLis);
        prod.setOnClickListener(butLis);
    }
}
