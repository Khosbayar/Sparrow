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

public class NextmissionActivity extends Activity {
    TextView tv_bayarhurgii, tvNiitDaralt, txtDarsan;
    ImageButton b_next;
    String stage, clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextmission);
        tv_bayarhurgii =  findViewById(R.id.textsBayrHurgii);
        tvNiitDaralt =  findViewById(R.id.textsNiitdarsan);
        txtDarsan =  findViewById(R.id.txtDarsan);
//        Typeface customType = Typeface.createFromAsset(getAssets(),
//                "fonts/Futuris-Bold.ttf");
//        tv_bayarhurgii.setTypeface(customType);
//        tvNiitDaralt.setTypeface(customType);
//        txtDarsan.setTypeface(customType);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            clicked = extras.getString("darsan");
            stage = extras.getString("uyiintoo");
            txtDarsan.setText(clicked);
        }
        b_next =  findViewById(R.id.btn_next);
        b_next.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (stage.equals("1")) {
                    Intent intent = new Intent(getApplicationContext(),
                            Level1Activity.class);
                    startActivity(intent);
                    finish();
                }
//                if (stage.equals("2")) {
//                    Intent intent = new Intent(getApplicationContext(),
//                            Level2Activity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                if (stage.equals("3")) {
//                    Intent intent = new Intent(getApplicationContext(),
//                            Level3Activity.class);
//                    startActivity(intent);
//                    finish();
//                }
            }
        });
    }

}
