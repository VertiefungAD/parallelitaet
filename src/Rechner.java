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
            this.flag0 = true;
            this.turn = 0;
            while (this.flag1) {
                if (this.turn != 0) {
                    this.flag0 = false;
                    while (this.turn != 0) {
                    }
                    this.flag0 = true;
                }
            }
        } else {
            this.flag1 = true;
            this.turn = 1;
            while (this.flag0) {
                if (this.turn != 1) {
                    this.flag1 = false;
                    while (this.turn != 1) {
                    }
                    this.flag1 = true;
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
            this.turn = 1;
            this.flag0 = false;
        } else {
            this.turn = 0;
            this.flag1 = false;
        }
        return erg;
    }
}
