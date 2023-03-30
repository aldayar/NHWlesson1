package com.example.nhwlesson1;
import static android.Manifest.permission.CALL_PHONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView=findViewById(R.id.text_view);
        button=findViewById(R.id.call_btn);

        Intent intent =getIntent();
        phoneNumber=intent.getStringExtra("phone_number");
        textView.setText(phoneNumber);

        button.setOnClickListener(view -> {
            String phoneNumber=textView.getText().toString();
            Intent intent1=new Intent(Intent.ACTION_DIAL);
            intent1.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent1);
        });


    }
}