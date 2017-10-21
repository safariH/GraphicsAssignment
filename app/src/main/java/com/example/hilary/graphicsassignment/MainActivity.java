package com.example.hilary.graphicsassignment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageView imgView = (ImageView) findViewById(R.id.imgView);

        // get screen width and height

        WindowManager wManager = getWindowManager();

        Display display = wManager.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();

        display.getMetrics(metrics);

        int screen_width = metrics.widthPixels;

        int screen_height = metrics.heightPixels;

        // Display images
        imgView.setImageBitmap(drawThings("#ff4455", screen_width, screen_height));

    }

    private Bitmap drawThings(String paintColor, int bgWidth, int bgHeight) {

        Paint paint = new Paint();

        paint.setTextSize(30);

        paint.setColor(Color.parseColor(paintColor));

        Shader gradient = new LinearGradient(0, 50, 0, 100, Color.RED, Color.BLUE, Shader.TileMode.REPEAT);

        Bitmap bitmapBackground = Bitmap.createBitmap(bgWidth, bgHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmapBackground);

        // Draw text

        canvas.drawText("Hilary's Drawings: ", 100, 30, paint);

        // Draw a line

        canvas.drawLine(100, 60, 500, 60, paint);

        // Draw a rectangle

        canvas.drawRect(new RectF(100, 70, 200, 200), paint);

        // Draw a oval

        canvas.drawOval(new RectF(100, 320, 300, 400), paint);

        // Draw a circle with gradient

        paint.setShader(gradient);

        canvas.drawCircle(100, 500, 100, paint);

        // Draw a arc with gradient and no fill

        paint.setStrokeWidth(3);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(new RectF(250, 500, 350, 650), 0, 180, false, paint);

        // Draw  circles with gradient
        paint.setShader(gradient);

        canvas.drawCircle(250, 750, 150, paint);
        canvas.drawCircle(150, 900, 150, paint);
        canvas.drawCircle(350, 900, 150, paint);

        return bitmapBackground;

    }

}