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

public class Level1Activity extends Activity {
    TextView tvUye;
    ImageButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);
        tvUye = findViewById(R.id.textsUyeEasy);
//        Typeface customType = Typeface.createFromAsset(getAssets(),
//                "fonts/Futuris-Bold.ttf");
//        tvUye.setTypeface(customType);
        btnOne = findViewById(R.id.level_one_easy);
        btnTwo = findViewById(R.id.level_two_easy);
        btnThree = findViewById(R.id.level_three_easy);
        btnFour = findViewById(R.id.level_four_easy);
        btnFive = findViewById(R.id.level_five_easy);
        btnSix = findViewById(R.id.level_six_easy);
        btnOne.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.1");
                intent.putExtra("shapeCircle", "15");
                intent.putExtra("shapeCross", "2");
                intent.putExtra("shapeSquare", "2");
                intent.putExtra("shapeRombo", "5");
                startActivity(intent);
                finish();
            }
        });
        btnTwo.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.2");
                intent.putExtra("shapeCircle", "12");
                intent.putExtra("shapeCross", "8");
                intent.putExtra("shapeSquare", "2");
                intent.putExtra("shapeRombo", "2");
                startActivity(intent);
                finish();
            }
        });
        btnThree.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.3");
                intent.putExtra("shapeCircle", "10");
                intent.putExtra("shapeCross", "7");
                intent.putExtra("shapeSquare", "4");
                intent.putExtra("shapeRombo", "3");
                startActivity(intent);
                finish();
            }
        });
        btnFour.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.4");
                intent.putExtra("shapeCircle", "9");
                intent.putExtra("shapeCross", "7");
                intent.putExtra("shapeSquare", "4");
                intent.putExtra("shapeRombo", "4");
                startActivity(intent);
                finish();
            }
        });
        btnFive.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.5");
                intent.putExtra("shapeCircle", "8");
                intent.putExtra("shapeCross", "8");
                intent.putExtra("shapeSquare", "4");
                intent.putExtra("shapeRombo", "4");
                startActivity(intent);
                finish();
            }
        });
        btnSix.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        Dashboard1Activity.class);
                intent.putExtra("uy", "1.6");
                intent.putExtra("shapeCircle", "6");
                intent.putExtra("shapeCross", "6");
                intent.putExtra("shapeSquare", "6");
                intent.putExtra("shapeRombo", "6");
                startActivity(intent);
                finish();
            }
        });
    }

}
