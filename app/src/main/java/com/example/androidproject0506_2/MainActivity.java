package com.example.androidproject0506_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String r;
    EditText edit1, edit2;
    int [] btnNumid = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                        R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button[] btnNum = new Button[btnNumid.length];
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.TextResult);
        for (int i = 0; i < btnNum.length; i++) {
            final int index = i;
            btnNum[index] = findViewById(btnNumid[index]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                        edit1.setText(edit1.getText().toString() + btnNum[index].getText());
                    }
                    if (edit2.isFocused()) {
                        edit2.setText(edit2.getText().toString() + btnNum[index].getText());
                    }
                }
            });
        }
        Button btnplus = findViewById(R.id.btnplus);
        Button btnminus = findViewById(R.id.minus);
        Button btndivide = findViewById(R.id.divide);
        Button btnmultiply = findViewById(R.id.multiply);

        btnplus.setOnClickListener(btnListener);
        btnminus.setOnClickListener(btnListener);
        btnmultiply.setOnClickListener(btnListener);
        btndivide.setOnClickListener(btnListener);
    }
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(edit1.getText().toString());
                int num2 = Integer.parseInt(edit2.getText().toString());
                int result = 0;
                switch (view.getId()){
                    case R.id.btnplus:
                        result = num1 +num2;
                        break;
                    case R.id.minus:
                        result = num1 - num2;
                        break;
                    case R.id.multiply:
                        result = num1 * num2;
                        break;
                    case R.id.divide:
                        result = num1 / num2;
                        break;
                }
                textResult.setText("계산 결과 : " + result);
        }
    };
}