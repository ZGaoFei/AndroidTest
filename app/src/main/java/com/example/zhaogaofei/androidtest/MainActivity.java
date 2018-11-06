package com.example.zhaogaofei.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button buttonOne;

    private int clickIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        buttonOne = findViewById(R.id.button_one);

        initData();
    }

    private void initData() {
        textView.setText("Main activity test!!!");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickIndex ++;
                // textView.setText("click index:" + clickIndex);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickIndex ++;
                textView.setText("click index:" + clickIndex);
            }
        });
    }
}
