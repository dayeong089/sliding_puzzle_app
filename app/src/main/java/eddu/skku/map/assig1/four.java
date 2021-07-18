package eddu.skku.map.assig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class four extends AppCompatActivity {
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        Intent intent = getIntent();

        Button shuffle = findViewById(R.id.shuffle);
        Button three = findViewById(R.id.three);
        ImageView picture = findViewById(R.id.sky2);

        BitmapDrawable drawable = (BitmapDrawable)picture.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        int num = 16;
        ImageButton button = findViewById(R.id.img1);
        ImageButton button1 = findViewById(R.id.img2);
        ImageButton button2 = findViewById(R.id.img3);
        ImageButton button3 = findViewById(R.id.img4);
        ImageButton button4 = findViewById(R.id.img5);
        ImageButton button5 = findViewById(R.id.img6);
        ImageButton button6 = findViewById(R.id.img7);
        ImageButton button7 = findViewById(R.id.img8);
        ImageButton button8 = findViewById(R.id.img9);
        ImageButton button9 = findViewById(R.id.img10);
        ImageButton button10 = findViewById(R.id.img11);
        ImageButton button11 = findViewById(R.id.img12);
        ImageButton button12 = findViewById(R.id.img13);
        ImageButton button13 = findViewById(R.id.img14);
        ImageButton button14 = findViewById(R.id.img15);
        ImageButton button15 = findViewById(R.id.img16);


        int rows, cols;
        int chunkHeight, chunkWidth;

        ArrayList<Bitmap> chunkedImages = new ArrayList<Bitmap>(num);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = 4;
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
        button9.setImageBitmap(chunkedImages.get(9));
        button10.setImageBitmap(chunkedImages.get(10));
        button11.setImageBitmap(chunkedImages.get(11));
        button12.setImageBitmap(chunkedImages.get(12));
        button13.setImageBitmap(chunkedImages.get(13));
        button14.setImageBitmap(chunkedImages.get(14));
        button15.setImageBitmap(chunkedImages.get(15));

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(four.this,three.class);
                startActivity(intent);
            }
        });

        int cnt=0;
        int[][] loca = new int[4][4];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                loca[i][j] = cnt;
                cnt++;
            }
        }

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] array = new int[16];
                for(int i=0; i<16; i++)
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
                for(int i=0;i<4;i++)
                {
                    for(int j=0;j<4;j++)
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
                button9.setImageBitmap(chunkedImages.get(array[9]));
                button10.setImageBitmap(chunkedImages.get(array[10]));
                button11.setImageBitmap(chunkedImages.get(array[11]));
                button12.setImageBitmap(chunkedImages.get(array[12]));
                button13.setImageBitmap(chunkedImages.get(array[13]));
                button14.setImageBitmap(chunkedImages.get(array[14]));
                button15.setImageBitmap(chunkedImages.get(array[15]));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[0][0];
                if(loca[0][1] == 15)
                {
                    button.setImageBitmap(chunkedImages.get(15));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][0];
                    loca[0][0] = loca[0][1];
                    loca[0][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][0] == 15)
                {
                    button.setImageBitmap(chunkedImages.get(15));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][0];
                    loca[0][0] = loca[1][0];
                    loca[1][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                if(loca[0][0] == 15)
                {
                    button1.setImageBitmap(chunkedImages.get(15));
                    button.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[0][0];
                    loca[0][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[0][2] == 15)
                {
                    button1.setImageBitmap(chunkedImages.get(15));
                    button2.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[0][2];
                    loca[0][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][1] == 15)
                {
                    button1.setImageBitmap(chunkedImages.get(15));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][1];
                    loca[0][1] = loca[1][1];
                    loca[1][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                if(loca[0][1] == 15)
                {
                    button2.setImageBitmap(chunkedImages.get(15));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][2];
                    loca[0][2] = loca[0][1];
                    loca[0][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][2] == 15)
                {
                    button2.setImageBitmap(chunkedImages.get(15));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][2];
                    loca[0][2] = loca[1][2];
                    loca[1][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[0][3] == 15)
                {
                    button2.setImageBitmap(chunkedImages.get(15));
                    button3.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][2];
                    loca[0][2] = loca[0][3];
                    loca[0][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[0][3];
                if(loca[0][2] == 15)
                {
                    button3.setImageBitmap(chunkedImages.get(15));
                    button2.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][3];
                    loca[0][3] = loca[0][2];
                    loca[0][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][3] == 15)
                {
                    button3.setImageBitmap(chunkedImages.get(15));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[0][3];
                    loca[0][3] = loca[1][3];
                    loca[1][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[1][0];
                if(loca[0][0] == 15)
                {
                    button4.setImageBitmap(chunkedImages.get(15));
                    button.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[0][0];
                    loca[0][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[1][1] == 15)
                {
                    button4.setImageBitmap(chunkedImages.get(15));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[1][1];
                    loca[1][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[2][0] == 15)
                {
                    button4.setImageBitmap(chunkedImages.get(15));
                    button8.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][0];
                    loca[1][0] = loca[2][0];
                    loca[2][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[1][1];
                if(loca[0][1] == 15)
                {
                    button5.setImageBitmap(chunkedImages.get(15));
                    button1.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[0][1];
                    loca[0][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][0] == 15)
                {
                    button5.setImageBitmap(chunkedImages.get(15));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[1][0];
                    loca[1][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 15)
                {
                    button5.setImageBitmap(chunkedImages.get(15));
                    button9.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[2][1];
                    loca[2][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][2] == 15)
                {
                    button5.setImageBitmap(chunkedImages.get(15));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][1];
                    loca[1][1] = loca[1][2];
                    loca[1][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[1][2];
                if(loca[0][2] == 15)
                {
                    button6.setImageBitmap(chunkedImages.get(15));
                    button2.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[0][2];
                    loca[0][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][1] == 15)
                {
                    button6.setImageBitmap(chunkedImages.get(15));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[1][1];
                    loca[1][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 15)
                {
                    button6.setImageBitmap(chunkedImages.get(15));
                    button10.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[2][2];
                    loca[2][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][3] == 15)
                {
                    button6.setImageBitmap(chunkedImages.get(15));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][2];
                    loca[1][2] = loca[1][3];
                    loca[1][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[1][3];
                if(loca[0][3] == 15)
                {
                    button7.setImageBitmap(chunkedImages.get(15));
                    button3.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][3];
                    loca[1][3] = loca[0][3];
                    loca[0][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[1][2] == 15)
                {
                    button7.setImageBitmap(chunkedImages.get(15));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][3];
                    loca[1][3] = loca[1][2];
                    loca[1][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][3] == 15)
                {
                    button7.setImageBitmap(chunkedImages.get(15));
                    button11.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[1][3];
                    loca[1][3] = loca[2][3];
                    loca[2][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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
                int now = loca[2][0];
                if(loca[1][0] == 15)
                {
                    button8.setImageBitmap(chunkedImages.get(15));
                    button4.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][0];
                    loca[2][0] = loca[1][0];
                    loca[1][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[2][1] == 15)
                {
                    button8.setImageBitmap(chunkedImages.get(15));
                    button9.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][0];
                    loca[2][0] = loca[2][1];
                    loca[2][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                if(loca[3][0] == 15)
                {
                    button8.setImageBitmap(chunkedImages.get(15));
                    button12.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][0];
                    loca[2][0] = loca[3][0];
                    loca[3][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][1];
                if(loca[1][1] == 15)
                {
                    button9.setImageBitmap(chunkedImages.get(15));
                    button5.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[1][1];
                    loca[1][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][0] == 15)
                {
                    button9.setImageBitmap(chunkedImages.get(15));
                    button8.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[2][0];
                    loca[2][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][1] == 15)
                {
                    button9.setImageBitmap(chunkedImages.get(15));
                    button13.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[3][1];
                    loca[3][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 15)
                {
                    button9.setImageBitmap(chunkedImages.get(15));
                    button10.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][1];
                    loca[2][1] = loca[2][2];
                    loca[2][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][2];
                if(loca[1][2] == 15)
                {
                    button10.setImageBitmap(chunkedImages.get(15));
                    button6.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[1][2];
                    loca[1][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 15)
                {
                    button10.setImageBitmap(chunkedImages.get(15));
                    button9.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[2][1];
                    loca[2][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][2] == 15)
                {
                    button10.setImageBitmap(chunkedImages.get(15));
                    button14.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[3][2];
                    loca[3][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][3] == 15)
                {
                    button10.setImageBitmap(chunkedImages.get(15));
                    button11.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][2];
                    loca[2][2] = loca[2][3];
                    loca[2][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[2][3];
                if(loca[1][3] == 15)
                {
                    button11.setImageBitmap(chunkedImages.get(15));
                    button7.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][3];
                    loca[2][3] = loca[1][3];
                    loca[1][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 15)
                {
                    button11.setImageBitmap(chunkedImages.get(15));
                    button10.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][3];
                    loca[2][3] = loca[2][2];
                    loca[2][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][3] == 15)
                {
                    button11.setImageBitmap(chunkedImages.get(15));
                    button15.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[2][3];
                    loca[2][3] = loca[3][3];
                    loca[3][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[3][0];
                if(loca[2][0] == 15)
                {
                    button12.setImageBitmap(chunkedImages.get(15));
                    button8.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][0];
                    loca[3][0] = loca[2][0];
                    loca[2][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][1] == 15)
                {
                    button12.setImageBitmap(chunkedImages.get(15));
                    button13.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][0];
                    loca[3][0] = loca[3][1];
                    loca[3][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[3][1];
                if(loca[3][0] == 15)
                {
                    button13.setImageBitmap(chunkedImages.get(15));
                    button12.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][1];
                    loca[3][1] = loca[3][0];
                    loca[3][0] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][1] == 15)
                {
                    button13.setImageBitmap(chunkedImages.get(15));
                    button9.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][1];
                    loca[3][1] = loca[2][1];
                    loca[2][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][2] == 15)
                {
                    button13.setImageBitmap(chunkedImages.get(15));
                    button14.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][1];
                    loca[3][1] = loca[3][2];
                    loca[3][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[3][2];
                if(loca[3][1] == 15)
                {
                    button14.setImageBitmap(chunkedImages.get(15));
                    button13.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][2];
                    loca[3][2] = loca[3][1];
                    loca[3][1] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][2] == 15)
                {
                    button14.setImageBitmap(chunkedImages.get(15));
                    button10.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][2];
                    loca[3][2] = loca[2][2];
                    loca[2][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[3][3] == 15)
                {
                    button14.setImageBitmap(chunkedImages.get(15));
                    button15.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][2];
                    loca[3][2] = loca[3][3];
                    loca[3][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }
            }
        });


        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = loca[3][3];
                if(loca[3][2] == 15)
                {
                    button15.setImageBitmap(chunkedImages.get(15));
                    button14.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][3];
                    loca[3][3] = loca[3][2];
                    loca[3][2] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
                    {
                        Intent intent = new Intent("FINISH!") ;
                        sendBroadcast(intent);
                    }
                }

                else if(loca[2][3] == 15)
                {
                    button15.setImageBitmap(chunkedImages.get(15));
                    button11.setImageBitmap(chunkedImages.get(now));
                    int tmp = loca[3][3];
                    loca[3][3] = loca[2][3];
                    loca[2][3] = tmp;
                    if((loca[0][0] == 0) && (loca[0][1] == 1) &&(loca[0][2] == 2) &&(loca[0][3] == 3)&&(loca[1][0] == 4) &&(loca[1][1] == 5) &&(loca[1][2] == 6) &&(loca[1][3] == 7)&&(loca[2][0] == 8) &&(loca[2][1] == 9) &&(loca[2][2] ==10)&&(loca[2][3] ==11)&&(loca[3][0] ==12)&&(loca[3][1] ==13)&&(loca[3][2] ==14)&&(loca[3][3] ==15))
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