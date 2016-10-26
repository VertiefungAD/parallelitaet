/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner {

    //    private int turn;
    private int a = 0;
    private int b = 0;
    //    private boolean[] flag = {false, false};
    private int erg = 0;
    final Object test = new Object();

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

        int ergRechne = 0;
        ergRechne = a + b;
        return ergRechne;

    }


    public int rechnePlus(int a, int b) {
        int ergebnis = 0;

        setA(a);
        setB(b);

        ergebnis = rechne();
        return ergebnis;
    }

}