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
        recibirParametro();
    }

    public void recibirParametro(){
        String value = getIntent().getStringExtra("KEY_PANTALLA_C");
        tvTitleD.setText(value);
    }

    public void init(){
        btnPantallaD = findViewById(R.id.btnPantallaD);
        tvTitleD = findViewById(R.id.tvTitleD);
        btnPantallaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                goActivityB();
            }
        });
    }

    public void goActivityB() {
//        Intent intent = new Intent(PantallaC.this, PantallaD.class);
//        intent.putExtra("KEY_PANTALLA_C", "Vengo de la pantalla C");
//        startActivity(intent);
//        finish();
    }
}