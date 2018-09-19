package extras;


public class DaraltNiit {


    private Integer[][] ara2 = new Integer[100][100];
    private int clickShape2;
    private int maxX = 0;
    private int maxY = 0;
    private int niit = 0;

    public DaraltNiit() {

    }

    public void setArray2(Integer[][] ar, int maxX, int maxY) {
        ara2 = ar;
        this.maxX = maxX;
        this.maxY = maxY;
    }



    public boolean check2(int x, int y) {
        if (ara2[x][y] == clickShape2 && x >= 0 && y >= 0 && x < maxX && y < maxY)
            return true;
        else
            return false;
    }

    public int labirint2(int x, int y) {
        if (clickShape2 == ara2[x][y]) {
            if (ara2[x][y] == 3) {
                ara2[x][y] = 0;
            } else {
                ara2[x][y] = ara2[x][y] + 1;
            }

            if (x > 0) {
                if (check2(x - 1, y))
                    labirint2(x - 1, y);
            }
            if (x < maxX-1) {
                if (check2(x + 1, y))
                    labirint2(x + 1, y);
            }
            if (y < maxY-1) {
                if (check2(x, y + 1))
                    labirint2(x, y + 1);
            }
            if (y > 0) {
                if (check2(x, y - 1))
                    labirint2(x, y - 1);
            }
            return 0;
        } else {
            return 0;
        }

    }


    public boolean checkFinish2()
    {
        int check=0;
        int local=ara2[0][0];
        for(int i=0;i<maxX;i++)
        {
            for(int j=0;j<maxY;j++)
            {
                if(local==ara2[i][j])
                    check++;
                else
                    break;
            }
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

    public void niitDaralt() {

        while(true)
        {
            clickShape2 = ara2[0][0];
            labirint2(0, 0);
            if(checkFinish2())
            {
                break;
            }
            else
            {
                niit++;
            }

        }
    }

    public int getNiit()
    {
        return niit;
    }



}
