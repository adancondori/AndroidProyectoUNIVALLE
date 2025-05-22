package com.example.androidproyectounivalle.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingView extends View {

    public enum ShapeType {
        LINE, CIRCLE, SQUARE
    }

    private Path path;
    private Paint drawPaint, canvasPaint;
    private int paintColor = Color.BLACK;
    private Canvas drawCanvas;
    private android.graphics.Bitmap canvasBitmap;
    private boolean isEraser = false;
    private float startX, startY;
    private ShapeType shapeType = ShapeType.LINE;

    public DrawingView(Context context) {
        super(context);
        setupDrawing();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupDrawing();
    }

    private void setupDrawing() {
        path = new Path();
        drawPaint = new Paint();

        // Configurar propiedades del pincel
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(10);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = android.graphics.Bitmap.createBitmap(w, h, android.graphics.Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);

        // Dibujar la forma actual que se está creando
        if (isDrawingShape) {
            canvas.drawPath(path, drawPaint);
        }
    }

    private boolean isDrawingShape = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Guardar punto inicial
                startX = touchX;
                startY = touchY;

                // Iniciar un nuevo path
                path = new Path();
                path.moveTo(touchX, touchY);
                isDrawingShape = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (shapeType == ShapeType.LINE) {
                    // Para líneas seguimos el movimiento
                    path.reset();
                    path.moveTo(startX, startY);
                    path.lineTo(touchX, touchY);
                } else if (shapeType == ShapeType.CIRCLE) {
                    // Para círculos calculamos el radio
                    float radius = (float) Math.sqrt(Math.pow(touchX - startX, 2) + Math.pow(touchY - startY, 2));
                    path.reset();
                    path.addCircle(startX, startY, radius, Path.Direction.CW);
                } else if (shapeType == ShapeType.SQUARE) {
                    // Para cuadrados calculamos las esquinas
                    path.reset();
                    path.addRect(startX, startY, touchX, touchY, Path.Direction.CW);
                }
                break;
            case MotionEvent.ACTION_UP:
                // Dibujar la forma final en el canvas
                drawCanvas.drawPath(path, drawPaint);
                isDrawingShape = false;
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void setColor(int newColor) {
        paintColor = newColor;
        drawPaint.setColor(newColor);
        drawPaint.setXfermode(null);
        isEraser = false;
    }

    public void setEraser(boolean isEraser) {
        this.isEraser = isEraser;
        if (isEraser) {
            drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        } else {
            drawPaint.setXfermode(null);
            drawPaint.setColor(paintColor);
        }
    }

    public void clearCanvas() {
        drawCanvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void setShapeType(ShapeType type) {
        this.shapeType = type;
        isEraser = false;
        drawPaint.setXfermode(null);
        drawPaint.setColor(paintColor);
    }
}
