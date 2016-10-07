/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner {

    private int turn;
    private int a = 0;
    private int b = 0;
    private boolean flag0 = false;
    private boolean flag1 = false;
    private int erg = 0;


    public Rechner(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int rechne() {
        int erg = 0;
        erg = a + b;
        return erg;
    }

    public int rechnePlus(int a, int b, int threadNr) {

//        Dekker:

        if (threadNr == 0) {
            flag0 = true;
            turn = 0;
            while (flag1) {
                if (turn != 0) {
                    flag0 = false;
                    while (turn != 0) {
                    }
                    flag0 = true;
                }
            }
        } else {
            flag1 = true;
            turn = 1;
            while (flag0) {
                if (turn != 1) {
                    flag1 = false;
                    while (turn != 1) {
                    }
                    flag1 = true;
                }
            }
        }
//      Kritischer Bereich Beginn
        setA(a);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setB(b);
        erg = rechne();
        //      Kritischer Bereich Ende
        if (threadNr == 0) {
            turn = 1;
            flag0 = false;
        } else {
            turn = 0;
            flag1 = false;
        }
        return erg;
    }
}
