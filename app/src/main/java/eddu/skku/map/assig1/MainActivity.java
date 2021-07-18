package eddu.skku.map.assig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button shuffle = findViewById(R.id.shuffle);
        ImageView picture = findViewById(R.id.sky1);

        BitmapDrawable drawable = (BitmapDrawable)picture.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        int num = 9;
        ImageButton button1 = findViewById(R.id.img1);
        ImageButton button2 = findViewById(R.id.img2);
        ImageButton button3 = findViewById(R.id.img3);
        ImageButton button4 = findViewById(R.id.img4);
        ImageButton button5 = findViewById(R.id.img5);
        ImageButton button6 = findViewById(R.id.img6);
        ImageButton button7 = findViewById(R.id.img7);
        ImageButton button8 = findViewById(R.id.img8);
        ImageButton button9 = findViewById(R.id.img9);


        int rows, cols;
        int cH, cW;

        ArrayList<Bitmap> image_array = new ArrayList<Bitmap>(num);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = 3;
        cH = bitmap.getHeight()/rows;
        cW = bitmap.getWidth()/cols;

        int yCoord = 0;
        for (int x = 0; x < rows; x++) {
            int xCoord = 0;
            for (int y = 0; y < cols; y++) {
                image_array.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, cW, cH));
                xCoord += cW;
            }
            yCoord += cH;
        }

        button1.setImageBitmap(image_array.get(0));
        button2.setImageBitmap(image_array.get(1));
        button3.setImageBitmap(image_array.get(2));
        button4.setImageBitmap(image_array.get(3));
        button5.setImageBitmap(image_array.get(4));
        button6.setImageBitmap(image_array.get(5));
        button7.setImageBitmap(image_array.get(6));
        button8.setImageBitmap(image_array.get(7));
        button9.setImageBitmap(image_array.get(8));

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,three.class);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,four.class);
                startActivity(intent);
            }
        });


    }
}