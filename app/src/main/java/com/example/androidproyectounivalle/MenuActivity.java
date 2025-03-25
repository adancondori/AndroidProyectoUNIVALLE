package com.example.androidproyectounivalle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.card.MaterialCardView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializar cards
        MaterialCardView[] cards = new MaterialCardView[6];
        for (int i = 1; i <= 6; i++) {
            int cardId = getResources().getIdentifier("card" + i, "id", getPackageName());
            cards[i-1] = findViewById(cardId);
            cards[i-1].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        String title = "";

        int id = view.getId();
        if (id == R.id.card1) {
            title = "Opción 1";
        } else if (id == R.id.card2) {
            title = "Opción 2";
        } else if (id == R.id.card3) {
            title = "Opción 3";
        } else if (id == R.id.card4) {
            title = "Opción 4";
        } else if (id == R.id.card5) {
            title = "Opción 5";
        } else if (id == R.id.card6) {
            title = "Opción 6";
        }

        intent.putExtra("SCREEN_TITLE", title);
        startActivity(intent);
    }
}
