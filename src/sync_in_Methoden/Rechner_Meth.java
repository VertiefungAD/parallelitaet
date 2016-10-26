package sync_in_Methoden;

/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner_Meth {
    private int a = 0;
    private int b = 0;
    private int erg = 0;
    private Object test = new Object();

    public Rechner_Meth(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        synchronized (test) {
            this.a = a;
            System.out.println("Jetzt ist a: " + a);
        }
    }

    public void setB(int b) {
        synchronized (test) {
            this.b = b;
            System.out.println("Jetzt ist b: " + b);
        }
    }

    public int rechne() {
        synchronized (test) {
            int ergRechne = 0;
            ergRechne = a + b;
            System.out.println("Jetzt ist erg: " + ergRechne);
            return ergRechne;
        }
    }

    public int rechnePlus(int a, int b) {
        int ergebnis = 0;

        setA(a);
        setB(b);

        ergebnis = rechne();
        return ergebnis;
    }
}