package sparrow.com.android.khosbayar.sparrowv10;

/**
 * Created by khosbayar on 12/4/17.
 */

import extras.Array;
import extras.DaraltNiit;
import extras.RandomArray;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Dashboard1Activity extends Activity {
    ImageButton[][] s = new ImageButton[6][4];
    Button b;
    Integer[][] n = new Integer[6][4];
    Boolean[][] check_clicked = new Boolean[6][4];
    ProgressBar pb;
    TextView tvUy, tvRound, tvDarsan, tvClicked, tvNiit, tvTotal;
    RandomArray r;
    DaraltNiit daraltNiit;
    int gloi, gloj;
    Array a;
    Integer NIIT = 0;
    Integer progressPerClick;
    Integer Clicked = 0;
    Animation animZoomIn, animZoomOut;
    Integer shapeCircle, shapeCross, shapeSquare, shapeRombo;
    String Stagenumber;
    Integer[][] ids = new Integer[][]{
            {R.id.s00, R.id.s01, R.id.s02, R.id.s03},
            {R.id.s10, R.id.s11, R.id.s12, R.id.s13},
            {R.id.s20, R.id.s21, R.id.s22, R.id.s23},
            {R.id.s30, R.id.s31, R.id.s32, R.id.s33},
            {R.id.s40, R.id.s41, R.id.s42, R.id.s43},
            {R.id.s50, R.id.s51, R.id.s52, R.id.s53}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_1);

        tvRound = (TextView) findViewById(R.id.textsUyiinToo);
        pb = (ProgressBar) findViewById(R.id.dashboardProgressBar1);
        tvClicked = (TextView) findViewById(R.id.textsDarsanToo);
        tvTotal = (TextView) findViewById(R.id.textsNiittoo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Stagenumber = extras.getString("uy");
            shapeCircle = Integer.parseInt(extras.getString("shapeCircle"));
            shapeCross = Integer.parseInt(extras.getString("shapeCross"));
            shapeSquare = Integer.parseInt(extras.getString("shapeSquare"));
            shapeRombo = Integer.parseInt(extras.getString("shapeRombo"));
        }else{
            finish();
        }
        tvRound.setText(Stagenumber);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                s[i][j] = (ImageButton) findViewById(ids[i][j]);
            }
        }
        Integer[][] local = new Integer[6][4];

        r = new RandomArray(this);
        daraltNiit = new DaraltNiit();
        r.setValues(6, 4, shapeCircle, shapeCross, shapeSquare, shapeRombo);

        n = r.getMas();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                local[i][j] = n[i][j];
                check_clicked[i][j] = new Boolean(false);
            }
        }

        daraltNiit.setArray2(local, 6, 4);
        daraltNiit.niitDaralt();
        NIIT = daraltNiit.getNiit() + 1;

        tvTotal.setText(NIIT.toString());
        tvClicked.setText("0");
        n = r.getMas();

        setBackground();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                final int indexi, indexj;
                indexi = i;
                indexj = j;
                s[indexi][indexj]
                        .setOnClickListener(new ImageButton.OnClickListener() {

                            @Override
                            public void onClick(View arg0) {
                                gloi = indexi;
                                gloj = indexj;
//								s[indexi][indexj].startAnimation(animZoomOut);
                                a = new Array();
                                a.setArray(n, 6, 4);
                                a.changeValue(indexi, indexj);

                                Clicked++;
                                progressPerClick = 100 * Clicked / NIIT;
                                pb.setProgress(progressPerClick);
                                tvClicked.setText("" + Clicked);
                                n = a.getArray();
                                check_clicked[indexi][indexj] = true;
                                if (Clicked > NIIT) {
                                    Intent intent = new Intent(
                                            getApplicationContext(),
                                            TryagainActivity.class);
                                    intent.putExtra("uyiintoo", "1");
                                    intent.putExtra("circle", shapeCircle);
                                    intent.putExtra("cross", shapeCross);
                                    intent.putExtra("square", shapeSquare);
                                    intent.putExtra("rombo", shapeRombo);
                                    intent.putExtra("uy", tvRound.getText());
                                    startActivity(intent);
                                    finish();
                                } else {
                                    if (a.checkFinish()) {
                                        Intent intent = new Intent(
                                                getApplicationContext(),
                                                NextmissionActivity.class);
                                        intent.putExtra("darsan",
                                                tvClicked.getText());
                                        intent.putExtra("uyiintoo", "1");
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                                s[indexi][indexj].setEnabled(false);
                                setBackground();
//                                setDisabled(indexi, indexj);

                            }
                        });
            }
        }

    }

    private void setBackground() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (n[i][j] == 0) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.circle);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.circle_clicked);
                    }

                }
                if (n[i][j] == 1) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.cross);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.cross_clicked);
                    }

                }
                if (n[i][j] == 2) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.square);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.square_clicked);

                    }

                }
                if (n[i][j] == 3) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.rombo);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.rombo_clicked);
                    }

                }
            }
        }
    }

    public void refreshGame(View view) {
    }

}
