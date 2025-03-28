package com.example.androidproyectounivalle;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String title = getIntent().getStringExtra("SCREEN_TITLE");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }

        TextView titleText = findViewById(R.id.titleText);
        titleText.setText(title);

        // Obtener la lista de items si existe
        ArrayList<Item> items = (ArrayList<Item>) getIntent().getSerializableExtra("ITEMS_LIST");
        if (items != null) {
            LinearLayout container = findViewById(R.id.container);
            for (Item item : items) {
                TextView itemView = new TextView(this);
                itemView.setPadding(32, 16, 32, 16);
                itemView.setText(String.format("%s\n%s", item.getName(), item.getDescription()));
                container.addView(itemView);
            }
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}
