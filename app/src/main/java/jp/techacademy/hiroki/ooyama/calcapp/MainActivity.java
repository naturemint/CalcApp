package jp.techacademy.hiroki.ooyama.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str1 = mEditText1.getText().toString();
        String str2 = mEditText2.getText().toString();
        double x;
        double y;
        try {
            x = Double.parseDouble(str1);
        } catch(NumberFormatException e) {
            Toast.makeText(this, "数字を入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            y = Double.parseDouble(str2);
        } catch(NumberFormatException e) {
            Toast.makeText(this, "数字を入力してください", Toast.LENGTH_LONG).show();
            return;
        }
        double result = 0;
        if(v.getId() == R.id.button1) {
            result = x + y;
        } else if(v.getId() == R.id.button2) {
            result = x - y;
        } else if(v.getId() == R.id.button3) {
            result = x * y;
        } else if(v.getId() == R.id.button4) {
            try {
                result = x / y;
            } catch(ArithmeticException e) {
                Toast.makeText(this, "0以外の数字を入力してください", Toast.LENGTH_LONG).show();
                return;
            }
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE", result);
        startActivity(intent);
    }

}
