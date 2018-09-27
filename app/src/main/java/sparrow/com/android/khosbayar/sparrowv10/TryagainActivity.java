package sparrow.com.android.khosbayar.sparrowv10;

/**
 * Created by khosbayar on 12/4/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TryagainActivity extends Activity {
    TextView tv_daralt;
    ImageButton btn_retry, btn_chooselevel;
    String stage, stageNumber;
    Integer shapeCircle, shapeCross, shapeSquare, shapeRombo, shapeStar, shapeHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tryagain);
        tv_daralt = findViewById(R.id.textsDaraltHetersen);
//        Typeface customType  = Typeface.createFromAsset(getAssets(),
//                "fonts/Futuris-Bold.ttf");
//        tv_daralt.setTypeface(customType);
        btn_retry = findViewById(R.id.btn_retry);
        btn_chooselevel = findViewById(R.id.btn_chooselevel);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            stage = extras.getString("uyiintoo");
            stageNumber = extras.getString("uy");
            shapeCircle = extras.getInt("circle");
            shapeCross = extras.getInt("cross");
            shapeSquare = extras.getInt("square");
            shapeRombo = extras.getInt("rombo");
            shapeStar = extras.getInt("star");
            shapeHeart = extras.getInt("heart");

        }
        btn_retry.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (stage.equals("1")) {
                    Intent intent = new Intent(getApplicationContext(),
                            Dashboard1Activity.class);
                    intent.putExtra("uy", stageNumber);
                    intent.putExtra("shapeCircle", shapeCircle.toString());
                    intent.putExtra("shapeCross", shapeCross.toString());
                    intent.putExtra("shapeSquare", shapeSquare.toString());
                    intent.putExtra("shapeRombo", shapeRombo.toString());
                    startActivity(intent);
                    finish();
                }
                if (stage.equals("2")) {
                    Intent intent = new Intent(getApplicationContext(),
                            Dashboard2Activity.class);
                    intent.putExtra("uy", stageNumber);
                    intent.putExtra("shapeCircle", shapeCircle.toString());
                    intent.putExtra("shapeCross", shapeCross.toString());
                    intent.putExtra("shapeSquare", shapeSquare.toString());
                    intent.putExtra("shapeRombo", shapeRombo.toString());
                    intent.putExtra("shapeStar", shapeStar.toString());
                    startActivity(intent);
                    finish();
                }
                if (stage.equals("3")) {
                    Intent intent = new Intent(getApplicationContext(),
                            Dashboard3Activity.class);
                    intent.putExtra("uy", stageNumber);
                    intent.putExtra("shapeCircle", shapeCircle.toString());
                    intent.putExtra("shapeCross", shapeCross.toString());
                    intent.putExtra("shapeSquare", shapeSquare.toString());
                    intent.putExtra("shapeRombo", shapeRombo.toString());
                    intent.putExtra("shapeStar", shapeStar.toString());
                    intent.putExtra("shapeHeart", shapeHeart.toString());
                    startActivity(intent);
                    finish();
                }

            }
        });
        btn_chooselevel.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (stage.equals("1")) {
                    Intent intent = new Intent(TryagainActivity.this,
                            Level1Activity.class);
                    TryagainActivity.this.startActivity(intent);
                    finish();
                }
                if (stage.equals("2")) {
                    Intent intent = new Intent(TryagainActivity.this,
                            Level2Activity.class);
                    TryagainActivity.this.startActivity(intent);
                    finish();
                }
                if (stage.equals("3")) {
                    Intent intent = new Intent(TryagainActivity.this,
                            Level3Activity.class);
                    TryagainActivity.this.startActivity(intent);
                    finish();
                }
            }
        });
    }

}
