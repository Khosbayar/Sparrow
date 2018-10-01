package sparrow.com.android.khosbayar.sparrowv10.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import sparrow.com.android.khosbayar.sparrowv10.R;

/**
 * Created by khosbayar on 12/4/17.
 */

public class IntroActivity extends Activity {
    TextView tv1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        tv1= findViewById(R.id.textsIntroZaawar);
    }
}
