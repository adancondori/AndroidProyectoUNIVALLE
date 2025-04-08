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
    private static final int REQUEST_CODE = 1;
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
        tvTitleA = findViewById(R.id.tvTitleA);
        btnPantallaA = findViewById(R.id.btnPantallaA);
        btnPantallaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goActivity();
            }
        });
    }

    public void goActivity() {
        Intent intent = new Intent(MainActivity.this, PantallaB.class);
        intent.putExtra("KEY-A", "Vengo de la pantalla A");
//        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra("RESULT_BACK");
            tvTitleA.setText(result);
        }
    }
}
