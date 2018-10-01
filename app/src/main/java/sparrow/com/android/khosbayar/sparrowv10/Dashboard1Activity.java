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

public class Dashboard1Activity extends Activity {
    ImageButton[][] s = new ImageButton[6][4];
    Integer[][] n = new Integer[6][4];
    Integer[][] copyN = new Integer[6][4];
    boolean[][] check_clicked = new boolean[6][4];
    ProgressBar pb;
    TextView tvRound, tvClicked, tvTotal;
    RandomArray r;
    DaraltNiit daraltNiit;
    int gloi, gloj;
    Array a;
    Integer NIIT = 0;
    Integer progressPerClick;
    Integer Clicked = 0;
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

        tvRound = findViewById(R.id.textsUyiinToo);
        pb = findViewById(R.id.dashboardProgressBar1);
        tvClicked = findViewById(R.id.textsDarsanToo);
        tvTotal = findViewById(R.id.textsNiittoo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Stagenumber = extras.getString("uy");
            shapeCircle = Integer.parseInt(extras.getString("shapeCircle"));
            shapeCross = Integer.parseInt(extras.getString("shapeCross"));
            shapeSquare = Integer.parseInt(extras.getString("shapeSquare"));
            shapeRombo = Integer.parseInt(extras.getString("shapeRombo"));
        } else {
            finish();
        }
        tvRound.setText(Stagenumber);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                s[i][j] = findViewById(ids[i][j]);
            }
        }
        Integer[][] local = new Integer[6][4];

        r = new RandomArray(this);
        daraltNiit = new DaraltNiit();
        r.setValues(6, 4, shapeCircle, shapeCross, shapeSquare, shapeRombo);

        n = r.getMas();

//        local = n;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                local[i][j] = n[i][j];
                copyN[i][j] = n[i][j];
            }
        }

        daraltNiit.setArray2(local, 6, 4, 4);
        daraltNiit.niitDaralt();
        NIIT = daraltNiit.getNiit() + 1;

        tvTotal.setText(String.valueOf(NIIT));
        tvClicked.setText("0");

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
                                a = new Array();
                                a.setArray(n, 6, 4, 4);
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
                        Integer[][] newarr = copyN.clone();
                        for (int i = 0; i < 6; i++) {
                            for (int j = 0; j < 4; j++) {
                                n[i][j] = copyN[i][j];
                                s[i][j].setEnabled(true);
                            }
                        }
                        Clicked = 0;
                        progressPerClick = 100 * Clicked / NIIT;
                        pb.setProgress(progressPerClick);
                        tvClicked.setText("0");
                        check_clicked = new boolean[6][4];
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
