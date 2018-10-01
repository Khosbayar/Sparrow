package sparrow.com.android.khosbayar.sparrowv10.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;


public class RandomArray {
    Integer[][] mas;
    private int maxX = 0;
    private int maxY = 0;
    private Context context;

    public RandomArray(Context context) {
        this.context = context;
    }

    public void setValues(int maxX, int maxY, Integer shapeO, Integer shapeX, Integer shapeD, Integer shapeR) {
        mas = new Integer[6][4];
        if ((maxX * maxY) == (shapeX + shapeD + shapeO + shapeR)) {
            this.maxX = maxX;
            this.maxY = maxY;

            int countX = 0, countD = 0, countO = 0, countR = 0;
            int localValue;
            boolean accept = true;

            Random random = new Random();
            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    accept = true;
                    while (accept) {
                        localValue = random.nextInt(4);
                        if (localValue == 0 && countO < shapeO) {
                            mas[i][j] = localValue;
                            accept = false;
                            countO++;
                        } else if (localValue == 1 && countX < shapeX) {
                            mas[i][j] = localValue;
                            accept = false;
                            countX++;

                        } else if (localValue == 2 && countD < shapeD) {
                            mas[i][j] = localValue;
                            accept = false;
                            countD++;
                        } else if (localValue == 3 && countR < shapeR) {
                            mas[i][j] = localValue;
                            accept = false;
                            countR++;
                        }
                    }
                }
            }
        } else {
            Toast.makeText(context, "No, what are you doin? pal", Toast.LENGTH_SHORT).show();
        }

    }

    public void setValuesForNormal(int maxX, int maxY, Integer shapeO, Integer shapeX, Integer
            shapeD, Integer shapeR, Integer shapeS) {
        mas = new Integer[8][6];
        if ((maxX * maxY) == (shapeX + shapeD + shapeO + shapeR + shapeS)) {
            this.maxX = maxX;
            this.maxY = maxY;

            int countX = 0, countD = 0, countO = 0, countR = 0, countS = 0;
            int localValue;
            boolean accept = true;

            Random random = new Random();
            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    accept = true;
                    while (accept) {
                        localValue = random.nextInt(5);
                        if (localValue == 0 && countO < shapeO) {
                            mas[i][j] = localValue;
                            accept = false;
                            countO++;
                        } else if (localValue == 1 && countX < shapeX) {
                            mas[i][j] = localValue;
                            accept = false;
                            countX++;

                        } else if (localValue == 2 && countD < shapeD) {
                            mas[i][j] = localValue;
                            accept = false;
                            countD++;
                        } else if (localValue == 3 && countR < shapeR) {
                            mas[i][j] = localValue;
                            accept = false;
                            countR++;
                        } else if (localValue == 4 && countS < shapeS) {
                            mas[i][j] = localValue;
                            accept = false;
                            countS++;
                        }
                    }
                }
            }
        } else {
            Toast.makeText(context, "No, what are you doin? pal", Toast.LENGTH_SHORT).show();
        }
    }

    public void setValuesForLegend(int maxX, int maxY, Integer shapeO, Integer shapeX, Integer
            shapeD, Integer shapeR, Integer shapeS, Integer shapeH) {
        mas = new Integer[10][8];
        if ((maxX * maxY) == (shapeX + shapeD + shapeO + shapeR + shapeS + shapeH)) {
            this.maxX = maxX;
            this.maxY = maxY;

            int countX = 0, countD = 0, countO = 0, countR = 0, countS = 0, countH = 0;
            int localValue;
            boolean accept = true;

            Random random = new Random();
            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    accept = true;
                    while (accept) {
                        localValue = random.nextInt(6);
                        if (localValue == 0 && countO < shapeO) {
                            mas[i][j] = localValue;
                            accept = false;
                            countO++;
                        } else if (localValue == 1 && countX < shapeX) {
                            mas[i][j] = localValue;
                            accept = false;
                            countX++;

                        } else if (localValue == 2 && countD < shapeD) {
                            mas[i][j] = localValue;
                            accept = false;
                            countD++;
                        } else if (localValue == 3 && countR < shapeR) {
                            mas[i][j] = localValue;
                            accept = false;
                            countR++;
                        } else if (localValue == 4 && countS < shapeS) {
                            mas[i][j] = localValue;
                            accept = false;
                            countS++;
                        } else if (localValue == 5 && countH < shapeH) {
                            mas[i][j] = localValue;
                            accept = false;
                            countS++;
                        }
                    }
                }
            }
        } else {
            Toast.makeText(context, "No, what are you doin? pal", Toast.LENGTH_SHORT).show();
        }
    }

    public Integer[][] getMas() {
        return mas;
    }
}
