package sparrow.com.android.khosbayar.sparrowv10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by khosbayar on 12/4/17.
 */

public class Level3Activity extends Activity {
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
        setContentView(R.layout.activity_level_3);
        tvUye = (TextView) findViewById(R.id.textsUyeHard);

        btn_level_one = findViewById(R.id.level_one_hard);
        btn_level_two = findViewById(R.id.level_two_hard);
        btn_level_three = findViewById(R.id.level_three_hard);
        btn_level_four = findViewById(R.id.level_four_hard);
        btn_level_five = findViewById(R.id.level_five_hard);
        btn_level_six = findViewById(R.id.level_six_hard);

        btn_level_one.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.1");
                intent.putExtra("shapeCircle", "20");
                intent.putExtra("shapeCross", "14");
                intent.putExtra("shapeSquare", "14");
                intent.putExtra("shapeRombo", "16");
                intent.putExtra("shapeStar", "8");
                intent.putExtra("shapeHeart", "8");
                startActivity(intent);
                finish();
            }
        });

        btn_level_two.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.2");
                intent.putExtra("shapeCircle", "19");
                intent.putExtra("shapeCross", "15");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "16");
                intent.putExtra("shapeStar", "12");
                intent.putExtra("shapeHeart", "8");
                startActivity(intent);
                finish();
            }
        });

        btn_level_three.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.3");
                intent.putExtra("shapeCircle", "20");
                intent.putExtra("shapeCross", "10");
                intent.putExtra("shapeSquare", "12");
                intent.putExtra("shapeRombo", "12");
                intent.putExtra("shapeStar", "14");
                intent.putExtra("shapeHeart", "12");
                startActivity(intent);
                finish();
            }
        });

        btn_level_four.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.4");
                intent.putExtra("shapeCircle", "16");
                intent.putExtra("shapeCross", "10");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "16");
                intent.putExtra("shapeStar", "15");
                intent.putExtra("shapeHeart", "13");
                startActivity(intent);
                finish();
            }
        });

        btn_level_five.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.5");
                intent.putExtra("shapeCircle", "10");
                intent.putExtra("shapeCross", "15");
                intent.putExtra("shapeSquare", "10");
                intent.putExtra("shapeRombo", "15");
                intent.putExtra("shapeStar", "15");
                intent.putExtra("shapeHeart", "15");
                startActivity(intent);
                finish();
            }
        });

        btn_level_six.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), Dashboard3Activity.class);
                intent.putExtra("uy", "3.6");
                intent.putExtra("shapeCircle", "14");
                intent.putExtra("shapeCross", "13");
                intent.putExtra("shapeSquare", "14");
                intent.putExtra("shapeRombo", "13");
                intent.putExtra("shapeStar", "13");
                intent.putExtra("shapeHeart", "13");
                startActivity(intent);
                finish();
            }
        });
    }
}
