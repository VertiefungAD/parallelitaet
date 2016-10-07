/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner {
    int a = 0;
    int b = 0;
    private boolean blocked = false;
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

    public int rechnePlus(int a, int b) {
//          Methode kann nur genutzt werden, blocked=false
//        Aber: während dem setzen der Variable könnte ein anderer Thread eingreifen

        //        while (blocked) {
//        blocked = true;
//      Kritischer Bereich Beginn
        setA(a);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setB(b);
        erg = rechne();
        blocked = false;
//        }
        //      Kritischer Bereich Ende
        return erg;
    }

}
