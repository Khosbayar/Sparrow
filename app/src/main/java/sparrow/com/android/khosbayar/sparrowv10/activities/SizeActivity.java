package sparrow.com.android.khosbayar.sparrowv10.activities;

/**
 * Created by khosbayar on 12/4/17.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import sparrow.com.android.khosbayar.sparrowv10.R;

public class SizeActivity extends Activity {

    ImageButton b_easy, b_normal, b_hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
        b_easy =  findViewById(R.id.mode_easy);
        b_normal =  findViewById(R.id.mode_normal);
        b_hard =  findViewById(R.id.mode_hard);
        b_easy.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(SizeActivity.this,
                        Level1Activity.class);
                SizeActivity.this.startActivity(intent);
                finish();
            }
        });
        b_normal.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(SizeActivity.this,
                        Level2Activity.class);
                SizeActivity.this.startActivity(intent);
                finish();
            }
        });
        b_hard.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(SizeActivity.this,
                        Level3Activity.class);
                SizeActivity.this.startActivity(intent);
                finish();
            }
        });

    }

}
