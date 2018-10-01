package sparrow.com.android.khosbayar.sparrowv10;

import extras.Array;
import extras.DaraltNiit;
import extras.RandomArray;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Dashboard3Activity extends Activity {
    ImageButton[][] s = new ImageButton[10][8];
    Integer[][] n = new Integer[10][8];
    Integer[][] copyN = new Integer[10][8];
    boolean[][] check_clicked = new boolean[10][8];
    TextView tvUy, tvRound, tvDarsan, tvClicked, tvNiit, tvTotal;
    ProgressBar pb;
    RandomArray r;
    Array a;
    Integer NIIT = 0;
    int gloi, gloj;
    DaraltNiit daraltNiit;
    Integer progressPerClick = 0, Clicked = 0;
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
        pb = findViewById(R.id.dashboardProgressBar3);

        tvUy = findViewById(R.id.textsUy);
        tvRound = findViewById(R.id.textsUyiinToo);
        tvDarsan = findViewById(R.id.textsDarsan);
        tvClicked = findViewById(R.id.textsDarsanToo);
        tvNiit = findViewById(R.id.textsNiit);
        tvTotal = findViewById(R.id.textsNiittoo);

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
        tvRound.setText(Stagenumber);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                s[i][j] = findViewById(ids[i][j]);
            }
        }

        Integer[][] local = new Integer[10][8];

        r = new RandomArray(this);
        daraltNiit = new DaraltNiit();
        r.setValuesForLegend(10, 8, shapeCircle, shapeCross, shapeRombo, shapeSquare, shapeStar, shapeHeart);


        n = r.getMas();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                local[i][j] = n[i][j];
                copyN[i][j] = n[i][j];
            }
        }

        daraltNiit.setArray2(local, 10, 8, 6);
        daraltNiit.niitDaralt();
        NIIT = daraltNiit.getNiit() + 1;
        tvTotal.setText(String.valueOf(NIIT));
        tvClicked.setText("0");
        n = r.getMas();
        setBackground();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
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
                                a.setArray(n, 10, 8, 6);
                                a.changeValue(indexi, indexj);

                                Clicked++;
                                progressPerClick = 100 * Clicked / NIIT;
                                pb.setProgress(progressPerClick);
                                tvClicked.setText(String.valueOf(Clicked));
                                n = a.getArray();
                                check_clicked[indexi][indexj] = true;
                                if (Clicked > NIIT) {
                                    Intent intent = new Intent(
                                            getApplicationContext(),
                                            TryagainActivity.class);
                                    intent.putExtra("uyiintoo", "3");
                                    intent.putExtra("circle", shapeCircle);
                                    intent.putExtra("cross", shapeCross);
                                    intent.putExtra("square", shapeSquare);
                                    intent.putExtra("rombo", shapeRombo);
                                    intent.putExtra("star", shapeStar);
                                    intent.putExtra("heart", shapeHeart);

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
                                        intent.putExtra("uyiintoo", "3");
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                                s[indexi][indexj].setEnabled(false);
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
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.circle);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.circle_clicked);
                    }

                } else if (n[i][j] == 1) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.cross);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.cross_clicked);
                    }

                } else if (n[i][j] == 2) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.square);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.square_clicked);

                    }

                } else if (n[i][j] == 3) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.rombo);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.rombo_clicked);
                    }

                } else if (n[i][j] == 4) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.star);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.star_clicked);
                    }

                } else if (n[i][j] == 5) {
                    if (!check_clicked[i][j]) {
                        s[i][j].setBackgroundResource(R.drawable.heart);
                    } else {
                        s[i][j].setBackgroundResource(R.drawable.heart_clicked);
                    }

                }
            }
        }
    }

    public void refreshGame(View view) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Restart?")
                .setMessage("Are you want to restart the game?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 8; j++) {
                                n[i][j] = copyN[i][j];
                                s[i][j].setEnabled(true);
                            }
                        }
                        Clicked = 0;
                        progressPerClick = 100 * Clicked / NIIT;
                        pb.setProgress(progressPerClick);
                        tvClicked.setText("0");
                        check_clicked = new boolean[10][8];
                        setBackground();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(R.drawable.main_logo)
                .show();
    }
}
