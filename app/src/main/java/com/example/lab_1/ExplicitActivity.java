package com.example.lab_1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ExplicitActivity extends AppCompatActivity {
    private EditText txtInput;
    private Button btnOtkazhi;
    private Button btnVoRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        init();
        addButtonEvents();
    }

    private void init() {
        txtInput = findViewById(R.id.txtInput);
        btnOtkazhi = findViewById(R.id.btnOtkazhi);
        btnVoRed = findViewById(R.id.btnVoRed);
    }

    private void addButtonEvents() {
        btnVoRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", txtInput.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnOtkazhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
