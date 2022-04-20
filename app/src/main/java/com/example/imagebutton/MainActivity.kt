package com.example.imagebutton

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mojPrzycisk = findViewById<ImageButton>(R.id.imageButton)
        var kolorRed = findViewById<Button>(R.id.redbtn)
        var kolorGreen = findViewById<ToggleButton>(R.id.toggleButton)

        mojPrzycisk.setOnClickListener {
            mojPrzycisk.setImageResource(R.drawable.akita)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pies2)
        val bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.czerwony)
        val filterBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)

        kolorRed.setOnClickListener {
            val paint = Paint()
            paint.alpha = 100
            val canvas = Canvas(filterBitmap)
            canvas.drawARGB(0,0,0,0);
            canvas.drawBitmap(bitmapCzerwony, null, RectF(0f, 0f, bitmap.width.toFloat(), bitmap.height.toFloat()), paint)
            canvas.drawBitmap(bitmap, 0f, 0f, paint)
            mojPrzycisk.setImageBitmap(filterBitmap)
        }

        kolorGreen.setOnClickListener{
            if(kolorGreen.isChecked) {
                mojPrzycisk.setColorFilter(R.color.green)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.green))
            }
            else {
                mojPrzycisk.setColorFilter(null)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.green_dark))
            }
        }
    }
}