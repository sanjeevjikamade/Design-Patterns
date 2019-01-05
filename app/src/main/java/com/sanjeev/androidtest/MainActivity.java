package com.sanjeev.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnChange = findViewById(R.id.btnClick);
        final EditText etText = findViewById(R.id.etText);
        final TextView txtChange = findViewById(R.id.txtChange);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtChange.setText(etText.getText().toString());
            }
        });
    }
}
