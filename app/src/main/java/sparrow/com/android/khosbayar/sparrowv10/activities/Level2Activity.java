package sparrow.com.android.khosbayar.sparrowv10.activities;

/**
 * Created by khosbayar on 12/4/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import sparrow.com.android.khosbayar.sparrowv10.R;

public class Level2Activity extends Activity {
    TextView tvUye;
    ImageButton btn_level_one;
    ImageButton btn_level_two;
    ImageButton btn_level_three;
    ImageButton btn_level_four;
    ImageButton btn_level_five;
    ImageButton btn_level_six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_2);
        tvUye = findViewById(R.id.textsUyeNormal);
//        Typeface customType = Typeface.createFromAsset(getAssets(), "fonts/Futuris-Bold.ttf");
//        tvUye.setTypeface(customType);
        btn_level_one = findViewById(R.id.level_one_medium);
        btn_level_two = findViewById(R.id.level_two_medium);
        btn_level_three = findViewById(R.id.level_three_medium);
        btn_level_four = findViewById(R.id.level_four_medium);
        btn_level_five = findViewById(R.id.level_five_medium);
        btn_level_six = findViewById(R.id.level_six_medium);

        btn_level_one.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.1");
                intent.putExtra("shapeCircle", "20");
                intent.putExtra("shapeCross", "6");
                intent.putExtra("shapeSquare", "6");
                intent.putExtra("shapeRombo", "11");
                intent.putExtra("shapeStar", "5");
                startActivity(intent);
                finish();
            }
        });

        btn_level_two.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.2");
                intent.putExtra("shapeCircle", "15");
                intent.putExtra("shapeCross", "8");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "10");
                intent.putExtra("shapeStar", "5");
                startActivity(intent);
                finish();
            }
        });

        btn_level_three.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.3");
                intent.putExtra("shapeCircle", "15");
                intent.putExtra("shapeCross", "10");
                intent.putExtra("shapeSquare", "9");
                intent.putExtra("shapeRombo", "9");
                intent.putExtra("shapeStar", "5");
                startActivity(intent);
            }
        });

        btn_level_four.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.4");
                intent.putExtra("shapeCircle", "5");
                intent.putExtra("shapeCross", "10");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "10");
                intent.putExtra("shapeStar", "13");
                startActivity(intent);
                finish();

            }
        });

        btn_level_five.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.5");
                intent.putExtra("shapeCircle", "8");
                intent.putExtra("shapeCross", "11");
                intent.putExtra("shapeSquare", "11");
                intent.putExtra("shapeRombo", "11");
                intent.putExtra("shapeStar", "7");
                startActivity(intent);
                finish();
            }
        });

        btn_level_six.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard2Activity.class);
                intent.putExtra("uy", "2.6");
                intent.putExtra("shapeCircle", "9");
                intent.putExtra("shapeCross", "9");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "10");
                intent.putExtra("shapeStar", "10");
                startActivity(intent);
                finish();
            }
        });
    }

}
