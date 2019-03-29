package ro.pub.cs.systems.eim.practicaltest01var07;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    TextView t00;
    TextView t01;
    TextView t10;
    TextView t11;

    int a;
    int b;
    int c;
    int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_sec);

        t00 = findViewById(R.id.At00);
        t01 = findViewById(R.id.At01);
        t10 = findViewById(R.id.At10);
        t11 = findViewById(R.id.At11);


    }
}
