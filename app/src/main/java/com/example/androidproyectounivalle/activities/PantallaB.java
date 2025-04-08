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

public class PantallaB extends AppCompatActivity {

    public Button btnPantallaB;
    public TextView tvTitleB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_b);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        getParametro();
    }


    public void init(){
        tvTitleB = findViewById(R.id.tvTitleB);
        btnPantallaB = findViewById(R.id.btnPantallaB);
        btnPantallaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity();

            }
        });
    }

    public void goActivity() {
        Intent intent = new Intent(PantallaB.this, PantallaC.class);
        intent.putExtra("KEY-B", "Vengo de la pantalla B");
        startActivity(intent);
        finish();
    }

    public void getParametro(){
        String value = getIntent().getStringExtra("KEY-A");
        tvTitleB.setText(value);
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("RESULT_BACK", "Mensaje enviado desde PantallaB al presionar Atrás");

        setResult(RESULT_OK, resultIntent);

        super.onBackPressed();
    }

    private void enviarResultadoYVolver() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("RESULT_BACK", "Mensaje enviado desde el botón de PantallaB");
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
