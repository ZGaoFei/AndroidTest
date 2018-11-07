package com.example.zhaogaofei.androidtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextActivity extends AppCompatActivity {

    private EditText etOne;
    private EditText etTwo;
    private TextView tvSum;
    private Button btSum;
    private Button btSum2;

    public static void start(Context context) {
        Intent intent = new Intent(context, EditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        etOne = findViewById(R.id.et_one);
        etTwo = findViewById(R.id.et_two);
        tvSum = findViewById(R.id.tv_sum);
        btSum = findViewById(R.id.bt_sum);
        btSum2 = findViewById(R.id.bt_sum2);

        btSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = etOne.getText().toString().trim();
                String two = etTwo.getText().toString().trim();

                double oneInt = 0;
                if (!TextUtils.isEmpty(one)) {
                    oneInt = Double.parseDouble(one);
                }
                double twoInt = 0;
                if (!TextUtils.isEmpty(two)) {
                    twoInt = Double.parseDouble(two);
                }

                tvSum.setText((oneInt + twoInt) + "");
            }
        });

        btSum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = etOne.getText().toString().trim();
                String two = etTwo.getText().toString().trim();

                double oneInt = 0;
                if (!TextUtils.isEmpty(one)) {
                    oneInt = Double.parseDouble(one);
                }
                double twoInt = 0;
                if (!TextUtils.isEmpty(two)) {
                    twoInt = Double.parseDouble(two);
                }

                tvSum.setText((oneInt * twoInt) + "");
            }
        });
    }
}
