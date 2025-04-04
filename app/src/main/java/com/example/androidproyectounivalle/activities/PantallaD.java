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

public class PantallaD extends AppCompatActivity {
    public Button btnPantallaD;
    public TextView tvTitleD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_d);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        getParametro();
    }


    public void init(){
        tvTitleD = findViewById(R.id.tvTitleD);
        btnPantallaD = findViewById(R.id.btnPantallaD);
        btnPantallaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void goActivity() {
//        Intent intent = new Intent(PantallaD.this, PantallaD.class);
//        startActivity(intent);
    }
    public void getParametro(){
        String value = getIntent().getStringExtra("KEY-C");
        tvTitleD.setText(value);
    }
}