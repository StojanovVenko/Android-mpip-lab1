package com.example.lab_1;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_FOR_EXPLICIT_ACTIVITY = 1;
    private static final int REQUEST_CODE_FOR_PICK_AN_IMAGE = 2;
    
    private Button btnStartExplicitActivity;
    private Button btnStartImplicitActivity;
    private Button btnShare;
    private Button btnSelectImage;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        initButtonEvents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // getting result from explicit activity
        if(requestCode == REQUEST_CODE_FOR_EXPLICIT_ACTIVITY) {
            if(resultCode == RESULT_OK) {
                txtResult.setText(data.getExtras().get("result").toString());
            }
        }
        // display the image in any app
        else if(requestCode == REQUEST_CODE_FOR_PICK_AN_IMAGE) {
            if (resultCode == RESULT_OK && data != null) {
                Uri selectedImg = data.getData();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(selectedImg, "image/*");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);

            }
        }
    }

    private void initVariables() {
        btnStartExplicitActivity = findViewById(R.id.btnStartExplicitActivity);
        btnStartImplicitActivity = findViewById(R.id.btnStartImplicitActivity);
        btnShare = findViewById(R.id.btnSpodeli);
        btnSelectImage = findViewById(R.id.btnSelecImage);
        txtResult = findViewById(R.id.txtResult);
    }

    private void initButtonEvents() {
        eventBtnExplicitActivity();
        eventBtnImplicitActivity();
        eventBtnShare();
        eventBtnPickPhoto();
    }

    private void eventBtnExplicitActivity() {
        btnStartExplicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ExplicitActivity.class), 1);
            }
        });
    }

    private void eventBtnImplicitActivity() {
        btnStartImplicitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(getResources().getString(R.string.IMPLICIT_ACTION_MPIP));
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void eventBtnShare() {
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TITLE, "MPiP Send Title");
                intent.putExtra(Intent.EXTRA_TEXT, " Content send from MainActivity");
                if(intent.resolveActivity(getPackageManager()) != null ){
                    Intent.createChooser(intent, "Share");
                    startActivity(intent);
                } else {
                    Log.e("Error", "Can't resolve for sharing content by btn2");
                }
            }
        });
    }

    private void eventBtnPickPhoto() {
        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickPhoto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivityForResult(pickPhoto , 2);

            }
        });
    }

}
