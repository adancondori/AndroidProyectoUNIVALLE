package com.example.androidproyectounivalle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;

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
        Intent intent;
        String title = "";

        int id = view.getId();
        if (id == R.id.card1) {
            intent = new Intent(MenuActivity.this, DetailActivity.class);
            title = "Lista de Ejemplos";

            // Crear lista de ejemplo
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item("Ejemplo 1", "Descripción del ejemplo 1"));
            items.add(new Item("Ejemplo 2", "Descripción del ejemplo 2"));
            items.add(new Item("Ejemplo 3", "Descripción del ejemplo 3"));

            intent.putExtra("SCREEN_TITLE", title);
            intent.putExtra("ITEMS_LIST", items);
            startActivity(intent);
            return;
        } else if (id == R.id.card2) {
            title = "Opción 2";
            intent = new Intent(this, DetailActivity.class);
        } else if (id == R.id.card3) {
            title = "Opción 3";
            intent = new Intent(this, DetailActivity.class);
        } else if (id == R.id.card4) {
            title = "PEdro Perez";
            intent = new Intent(this, PantallaActivity.class);
        } else if (id == R.id.card5) {
            title = "Opción 5";
            intent = new Intent(this, DetailActivity.class);
        } else {
            title = "Opción 6";
            intent = new Intent(this, DetailActivity.class);
        }

        intent.putExtra("SCREEN_TITLE", title);
        startActivity(intent);
    }
}
