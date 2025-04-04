package com.example.androidproyectounivalle.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproyectounivalle.R;

public class MainActivity extends AppCompatActivity {

    public Button btnPantallaA;
    public TextView tvTitleA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    public void init(){
        btnPantallaA = findViewById(R.id.btnPantallaA);
        tvTitleA = findViewById(R.id.tvTitleA);
        btnPantallaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivityB();
            }
        });
    }

    public void goActivityB() {
        Intent intent = new Intent(MainActivity.this, PantallaB.class);
        startActivity(intent);
    }
}