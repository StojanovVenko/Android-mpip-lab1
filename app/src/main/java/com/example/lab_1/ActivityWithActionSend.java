package com.example.lab_1;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityWithActionSend extends AppCompatActivity {
    private TextView txtTitle;
    private TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_action_send);

        txtTitle = findViewById(R.id.txtActionSendTitle);
        txtContent = findViewById(R.id.txtActionSendContent);

        txtTitle.setText(getIntent().getStringExtra(Intent.EXTRA_TITLE));
        txtContent.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
    }

}
