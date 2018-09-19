package sparrow.com.android.khosbayar.sparrowv10;

import extras.Array;
import extras.RandomArray;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dashboard3Activity extends Activity {
    ImageButton[][] s = new ImageButton[10][8];
    Button b;
    Integer[][] n = new Integer[10][8];
    TextView tvUy, tvRound, tvDarsan, tvClicked, tvNiit, tvTotal;
    RandomArray r;
    Array a;
    Integer shapeCircle, shapeCross, shapeSquare, shapeRombo, shapeStar, shapeHeart;
    String Stagenumber;
    Integer[][] ids = new Integer[][]{
            {R.id.s00, R.id.s01, R.id.s02, R.id.s03, R.id.s04, R.id.s05, R.id.s06, R.id.s07},
            {R.id.s10, R.id.s11, R.id.s12, R.id.s13, R.id.s14, R.id.s15, R.id.s16, R.id.s17},
            {R.id.s20, R.id.s21, R.id.s22, R.id.s23, R.id.s24, R.id.s25, R.id.s26, R.id.s27},
            {R.id.s30, R.id.s31, R.id.s32, R.id.s33, R.id.s34, R.id.s35, R.id.s36, R.id.s37},
            {R.id.s40, R.id.s41, R.id.s42, R.id.s43, R.id.s44, R.id.s45, R.id.s46, R.id.s47},
            {R.id.s50, R.id.s51, R.id.s52, R.id.s53, R.id.s54, R.id.s55, R.id.s56, R.id.s57},
            {R.id.s60, R.id.s61, R.id.s62, R.id.s63, R.id.s64, R.id.s65, R.id.s66, R.id.s67},
            {R.id.s70, R.id.s71, R.id.s72, R.id.s73, R.id.s74, R.id.s75, R.id.s76, R.id.s77},
            {R.id.s80, R.id.s81, R.id.s82, R.id.s83, R.id.s84, R.id.s85, R.id.s86, R.id.s87},
            {R.id.s90, R.id.s91, R.id.s92, R.id.s93, R.id.s94, R.id.s95, R.id.s96, R.id.s97}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_3);
        tvUy = (TextView) findViewById(R.id.textsUy3);
        tvRound = (TextView) findViewById(R.id.textsUyiinToo3);
        tvDarsan = (TextView) findViewById(R.id.textsDarsan3);
        tvClicked = (TextView) findViewById(R.id.textsDarsanToo3);
        tvNiit = (TextView) findViewById(R.id.textsNiit3);
        tvTotal = (TextView) findViewById(R.id.textsNiittoo3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Stagenumber = extras.getString("uy");
            shapeCircle = Integer.parseInt(extras.getString("shapeCircle"));
            shapeCross = Integer.parseInt(extras.getString("shapeCross"));
            shapeSquare = Integer.parseInt(extras.getString("shapeSquare"));
            shapeRombo = Integer.parseInt(extras.getString("shapeRombo"));
            shapeStar = Integer.parseInt(extras.getString("shapeStar"));
            shapeHeart = Integer.parseInt(extras.getString("shapeHeart"));
        } else {
            finish();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                s[i][j] = (ImageButton) findViewById(ids[i][j]);
            }
        }
        r = new RandomArray(this);
        r.setValuesForLegend(10, 8, shapeCircle, shapeCross, shapeRombo, shapeSquare, shapeStar, shapeHeart);
        n = r.getMas();
        setBackground();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                final int indexi, indexj;
                indexi = i;
                indexj = j;
                s[indexi][indexj].setOnClickListener(new ImageButton.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        a = new Array();
                        a.setArray(n, 10, 8);
                        a.changeValue(indexi, indexj);
                        n = a.getArray();
                        setBackground();
                    }
                });
            }
        }

    }

    private void setBackground() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                if (n[i][j] == 0) {
                    s[i][j].setBackgroundResource(R.drawable.circle);
                } else if (n[i][j] == 1) {
                    s[i][j].setBackgroundResource(R.drawable.cross);
                } else if (n[i][j] == 2) {
                    s[i][j].setBackgroundResource(R.drawable.square);
                } else if (n[i][j] == 3) {
                    s[i][j].setBackgroundResource(R.drawable.rombo);
                } else if (n[i][j] == 4) {
                    s[i][j].setBackgroundResource(R.drawable.star);
                } else if (n[i][j] == 5) {
                    s[i][j].setBackgroundResource(R.drawable.heart);
                }
            }
        }
    }

    public void refreshGame(View view) {
    }
}
