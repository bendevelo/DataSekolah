package com.s.insertsekolah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout lin1,lin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Menu");

        lin1 = findViewById(R.id.linearLayout1);
        lin = findViewById(R.id.linearLayout);

        lin.setOnClickListener(view -> {
            Intent intent = new Intent(this, Register_Activity.class);
            startActivity(intent);

        });

        lin1.setOnClickListener(view -> {
            Intent intent = new Intent(this, Report_Activity.class);
            startActivity(intent);

        });

    }
}