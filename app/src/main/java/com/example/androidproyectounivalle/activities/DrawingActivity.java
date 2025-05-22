package com.example.androidproyectounivalle.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.androidproyectounivalle.R;
import com.example.androidproyectounivalle.views.DrawingView;

public class DrawingActivity extends AppCompatActivity {

    private DrawingView drawingView;
    private ImageButton circleBtn, squareBtn, lineBtn, eraserBtn;
    private Button clearBtn, redBtn, blueBtn, greenBtn, blackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        // Inicializar el lienzo de dibujo
        drawingView = findViewById(R.id.drawing_view);

        // Botones de formas
        circleBtn = findViewById(R.id.circle_btn);
        squareBtn = findViewById(R.id.square_btn);
        lineBtn = findViewById(R.id.line_btn);
        eraserBtn = findViewById(R.id.eraser_btn);

        // Botones de colores y limpieza
        clearBtn = findViewById(R.id.clear_btn);
        redBtn = findViewById(R.id.red_btn);
        blueBtn = findViewById(R.id.blue_btn);
        greenBtn = findViewById(R.id.green_btn);
        blackBtn = findViewById(R.id.black_btn);

        // Configurar eventos para los botones de forma
        circleBtn.setOnClickListener(v -> drawingView.setShapeType(DrawingView.ShapeType.CIRCLE));
        squareBtn.setOnClickListener(v -> drawingView.setShapeType(DrawingView.ShapeType.SQUARE));
        lineBtn.setOnClickListener(v -> drawingView.setShapeType(DrawingView.ShapeType.LINE));
        eraserBtn.setOnClickListener(v -> drawingView.setEraser(true));

        // Configurar eventos para los botones de color
        redBtn.setOnClickListener(v -> {
            drawingView.setColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            drawingView.setEraser(false);
        });
        blueBtn.setOnClickListener(v -> {
            drawingView.setColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
            drawingView.setEraser(false);
        });
        greenBtn.setOnClickListener(v -> {
            drawingView.setColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
            drawingView.setEraser(false);
        });
        blackBtn.setOnClickListener(v -> {
            drawingView.setColor(ContextCompat.getColor(this, android.R.color.black));
            drawingView.setEraser(false);
        });

        // Configurar evento para botón de limpieza
        clearBtn.setOnClickListener(v -> drawingView.clearCanvas());
    }
}
