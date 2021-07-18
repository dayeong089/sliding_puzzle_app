package eddu.skku.map.assig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class three extends AppCompatActivity {

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Intent intent = getIntent();

        Button shuffle = findViewById(R.id.shuffle);
        Button four = findViewById(R.id.four);
        ImageView picture = findViewById(R.id.sky1);

        BitmapDrawable drawable = (BitmapDrawable)picture.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        int num = 9;
        ImageButton button = findViewById(R.id.img1);
        ImageButton button1 = findViewById(R.id.img2);
        ImageButton button2 = findViewById(R.id.img3);
        ImageButton button3 = findViewById(R.id.img4);
        ImageButton button4 = findViewById(R.id.img5);
        ImageButton button5 = findViewById(R.id.img6);
        ImageButton button6 = findViewById(R.id.img7);
        ImageButton button7 = findViewById(R.id.img8);
        ImageButton button8 = findViewById(R.id.img9);

        int rows, cols;
        int chunkHeight, chunkWidth;

        ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(num);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = 3;
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;

        int yCoord = 0;
        for (int x = 0; x < rows; x++) {
            int xCoord = 0;
            for (int y = 0; y < cols; y++) {
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }

        button.setImageBitmap(chunkedImages.get(0));
        button1.setImageBitmap(chunkedImages.get(1));
        button2.setImageBitmap(chunkedImages.get(2));
        button3.setImageBitmap(chunkedImages.get(3));
        button4.setImageBitmap(chunkedImages.get(4));
        button5.setImageBitmap(chunkedImages.get(5));
        button6.setImageBitmap(chunkedImages.get(6));
        button7.setImageBitmap(chunkedImages.get(7));
        button8.setImageBitmap(chunkedImages.get(8));

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(three.this,four.class);
                startActivity(intent);
            }
        });

        int cnt=0;
        int[][] loca = new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                loca[i][j] = cnt;
                cnt++;
            }
        }

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] array = new int[9];
                for(int i=0; i<9; i++)
                {
                    array[i] = i;
                }

                int tmp, tmp2, rn1, rn2;
                for(int i=0; i<20; i++)
                {
                    rn1 = (int)(Math.random()*array.length);
                    tmp = array[rn1];
                    rn2 = (int)(Math.random()*array.length);
                    tmp2 = array[rn2];
                    array[rn1] = tmp2;
                    array[rn2] = tmp;
                 }

                int cnt = 0;
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        loca[i][j] = array[cnt];
                        cnt++;
                    }
                }

                button.setImageBitmap(chunkedImages.get(array[0]));
                button1.setImageBitmap(chunkedImages.get(array[1]));
                button2.setImageBitmap(chunkedImages.get(array[2]));
                button3.setImageBitmap(chunkedImages.get(array[3]));
                button4.setImageBitmap(chunkedImages.get(array[4]));
                button5.setImageBitmap(chunkedImages.get(array[5]));
                button6.setImageBitmap(chunkedImages.get(array[6]));
                button7.setImageBitmap(chunkedImages.get(array[7]));
                button8.setImageBitmap(chunkedImages.get(array[8]));
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[0][0];
                if(loca[0][1] == 8)
                {
                    button.setImageBitmap(chunkedImages.get(8));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][0];
                    loca[0][0] = loca[0][1];
                    loca[0][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][0] == 8)
                {
                    button.setImageBitmap(chunkedImages.get(8));
                    button3.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][0];
                    loca[0][0] = loca[1][0];
                    loca[1][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[0][1];
                if(loca[0][0] == 8)
                {
                    button1.setImageBitmap(chunkedImages.get(8));
                    button.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[0][0];
                    loca[0][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[0][2] == 8)
                {
                    button1.setImageBitmap(chunkedImages.get(8));
                    button2.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[0][2];
                    loca[0][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][1] == 8)
                {
                    button1.setImageBitmap(chunkedImages.get(8));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[1][1];
                    loca[1][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[0][2];
                if(loca[0][1] == 8)
                {
                    button2.setImageBitmap(chunkedImages.get(8));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][2];
                    loca[0][2] = loca[0][1];
                    loca[0][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][2] == 8)
                {
                    button2.setImageBitmap(chunkedImages.get(8));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][2];
                    loca[0][2] = loca[1][2];
                    loca[1][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[1][0];
                if(loca[0][0] == 8)
                {
                    button3.setImageBitmap(chunkedImages.get(8));
                    button.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[0][0];
                    loca[0][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[1][1] == 8)
                {
                    button3.setImageBitmap(chunkedImages.get(8));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[1][1];
                    loca[1][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[2][0] == 8)
                {
                    button3.setImageBitmap(chunkedImages.get(8));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[2][0];
                    loca[2][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[1][1];
                if(loca[0][1] == 8)
                {
                    button4.setImageBitmap(chunkedImages.get(8));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[0][1];
                    loca[0][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][0] == 8)
                {
                    button4.setImageBitmap(chunkedImages.get(8));
                    button3.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[1][0];
                    loca[1][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 8)
                {
                    button4.setImageBitmap(chunkedImages.get(8));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[2][1];
                    loca[2][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][2] == 8)
                {
                    button4.setImageBitmap(chunkedImages.get(8));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[1][2];
                    loca[1][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[1][2];
                if(loca[0][2] == 8)
                {
                    button5.setImageBitmap(chunkedImages.get(8));
                    button2.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[0][2];
                    loca[0][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][1] == 8)
                {
                    button5.setImageBitmap(chunkedImages.get(8));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[1][1];
                    loca[1][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 8)
                {
                    button5.setImageBitmap(chunkedImages.get(8));
                    button8.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[2][2];
                    loca[2][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][0];
                if(loca[1][0] == 8)
                {
                    button6.setImageBitmap(chunkedImages.get(8));
                    button3.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][0];
                    loca[2][0] = loca[1][0];
                    loca[1][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 8)
                {
                    button6.setImageBitmap(chunkedImages.get(8));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][0];
                    loca[2][0] = loca[2][1];
                    loca[2][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][1];
                if(loca[2][0] == 8)
                {
                    button7.setImageBitmap(chunkedImages.get(8));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[2][0];
                    loca[2][0] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][1] == 8)
                {
                    button7.setImageBitmap(chunkedImages.get(8));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[1][1];
                    loca[1][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 8)
                {
                    button7.setImageBitmap(chunkedImages.get(8));
                    button8.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[2][2];
                    loca[2][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][2];
                if(loca[1][2] == 8)
                {
                    button8.setImageBitmap(chunkedImages.get(8));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[1][2];
                    loca[1][2] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 8)
                {
                    button8.setImageBitmap(chunkedImages.get(8));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[2][1];
                    loca[2][1] = tmp;

                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[1][0] == 3) &&(loca[1][1] == 4) &&(loca[1][2] == 5) &&(loca[2][0] == 6) &&(loca[2][1] == 7) &&(loca[2][2] ==8))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("FINISH!");
        registerReceiver(br,filter);
    }

    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(br);
    }
}