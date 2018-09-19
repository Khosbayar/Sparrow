package extras;

public class Array {
    private Integer[][] ara = new Integer[100][100];
    private int clickShape;
    private int maxX = 0;
    private int maxY = 0;
    private int click_count = 0;

    public Array() {

    }

    public void setArray(Integer[][] ar, int maxX, int maxY) {
        ara = ar;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Integer[][] getArray() {
        return ara;
    }

    // public void showValue()
    // {
    // for(int i=0;i<maxX;i++)
    // {
    // for(int j=0;j<maxY;j++)
    // {
    // System.out.print("  ["+i+"]["+j +"] = "+ara[i][j]);
    // }
    // System.out.println(" ");
    // }
    // }

    public boolean check(int x, int y) {
        if (ara[x][y] == clickShape && x >= 0 && y >= 0 && x < maxX && y < maxY)
            return true;
        else
            return false;
    }

    public int labirint(int x, int y) {
        if (clickShape == ara[x][y]) {
            if (ara[x][y] == 3) {
                ara[x][y] = 0;
            } else {
                ara[x][y] = ara[x][y] + 1;
            }

            if (x > 0) {
                if (check(x - 1, y))
                    labirint(x - 1, y);
            }
            if (x < maxX-1) {
                if (check(x + 1, y))
                    labirint(x + 1, y);
            }
            if (y < maxY-1) {
                if (check(x, y + 1))
                    labirint(x, y + 1);
            }
            if (y > 0) {
                if (check(x, y - 1))
                    labirint(x, y - 1);
            }
            return 0;
        } else {
            return 0;
        }

    }

    public void changeValue(int x, int y) {
        click_count= click_count + 1;
        clickShape = ara[x][y];
        labirint(x, y);

    }

    public int getClickCount()
    {
        return click_count;
    }

    public boolean checkFinish()
    {
        int check=0;
        int local=ara[0][0];
        for(int i=0;i<maxX;i++)
            for(int j=0;j<maxY;j++)
            {
                if(local==ara[i][j])
                    check++;
            }

        if(check == (maxX*maxY))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}
