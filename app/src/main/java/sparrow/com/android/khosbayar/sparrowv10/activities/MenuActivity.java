package sparrow.com.android.khosbayar.sparrowv10.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import sparrow.com.android.khosbayar.sparrowv10.R;

/**
 * Created by khosbayar on 12/4/17.
 */

public class MenuActivity extends Activity {
    ImageButton ib_Play, ib_Tops, ib_Intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ib_Play = findViewById(R.id.button_play);
        ib_Intro = findViewById(R.id.button_intro);
        ib_Play.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MenuActivity.this,
                        SizeActivity.class);
                MenuActivity.this.startActivity(intent);
            }
        });
        ib_Intro.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MenuActivity.this,
                        IntroActivity.class);
                MenuActivity.this.startActivity(intent);
            }
        });
    }
}
