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

public class PantallaC extends AppCompatActivity {
    public Button btnPantallaC;
    public TextView tvTitleC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_c);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        getParametro();
    }

    public void init(){
        tvTitleC = findViewById(R.id.tvTitleC);
        btnPantallaC = findViewById(R.id.btnPantallaC);
        btnPantallaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity();
            }
        });
    }

    public void goActivity() {
        Intent intent = new Intent(PantallaC.this, PantallaD.class);
        intent.putExtra("KEY-C", "Vengo de la pantalla C");
        startActivity(intent);
        finish();
    }
    public void getParametro(){
        String value = getIntent().getStringExtra("KEY-B");
        tvTitleC.setText(value);
    }
}