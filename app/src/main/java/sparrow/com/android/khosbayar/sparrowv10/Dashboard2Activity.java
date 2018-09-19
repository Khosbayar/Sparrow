package sparrow.com.android.khosbayar.sparrowv10;


import extras.Array;
import extras.RandomArray;
import sparrow.com.android.khosbayar.sparrowv10.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Dashboard2Activity extends Activity {
    ImageButton[][] s = new ImageButton[8][6];
    Button b;
    Integer[][] n = new Integer[8][6];
    TextView tvUy, tvRound, tvDarsan, tvClicked, tvNiit, tvTotal;
    ProgressBar pb;
    RandomArray r;
    Array a;
    Integer progressPerClick = 0, Clicked = 0;
    Integer shapeCircle, shapeCross, shapeSquare, shapeRombo, shapeStar;
    String Stagenumber;
    Integer[][] ids = new Integer[][]{
            {R.id.s00, R.id.s01, R.id.s02, R.id.s03, R.id.s04, R.id.s05},
            {R.id.s10, R.id.s11, R.id.s12, R.id.s13, R.id.s14, R.id.s15},
            {R.id.s20, R.id.s21, R.id.s22, R.id.s23, R.id.s24, R.id.s25},
            {R.id.s30, R.id.s31, R.id.s32, R.id.s33, R.id.s34, R.id.s35},
            {R.id.s40, R.id.s41, R.id.s42, R.id.s43, R.id.s44, R.id.s45},
            {R.id.s50, R.id.s51, R.id.s52, R.id.s53, R.id.s54, R.id.s55},
            {R.id.s60, R.id.s61, R.id.s62, R.id.s63, R.id.s64, R.id.s65},
            {R.id.s70, R.id.s71, R.id.s72, R.id.s73, R.id.s74, R.id.s75}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_2);
        pb = (ProgressBar) findViewById(R.id.dashboardProgressBar2);
        tvUy = (TextView) findViewById(R.id.textsUy2);
        tvRound = (TextView) findViewById(R.id.textsUyiinToo2);
        tvDarsan = (TextView) findViewById(R.id.textsDarsan2);
        tvClicked = (TextView) findViewById(R.id.textsDarsanToo2);
        tvNiit = (TextView) findViewById(R.id.textsNiit2);
        tvTotal = (TextView) findViewById(R.id.textsNiittoo2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Stagenumber = extras.getString("uy");
            shapeCircle = Integer.parseInt(extras.getString("shapeCircle"));
            shapeCross = Integer.parseInt(extras.getString("shapeCross"));
            shapeSquare = Integer.parseInt(extras.getString("shapeSquare"));
            shapeRombo = Integer.parseInt(extras.getString("shapeRombo"));
            shapeStar = Integer.parseInt(extras.getString("shapeStar"));
        } else {
            finish();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                s[i][j] = (ImageButton) findViewById(ids[i][j]);
            }
        }
        r = new RandomArray(this);
        r.setValuesForNormal(8, 6, shapeCircle, shapeCross, shapeRombo, shapeSquare, shapeStar);
        n = r.getMas();
        setBackground();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                final int indexi, indexj;
                indexi = i;
                indexj = j;
                s[indexi][indexj]
                        .setOnClickListener(new ImageButton.OnClickListener() {

                            @Override
                            public void onClick(View arg0) {
                                // TODO Auto-generated method stub
                                a = new Array();
                                a.setArray(n, 8, 6);
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
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
                }
            }
        }

    }

    public void refreshGame(View view) {
    }
}