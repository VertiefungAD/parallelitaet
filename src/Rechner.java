/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner {

    private int turn;
    private int a = 0;
    private int b = 0;
    private boolean[] flag = {false, false};
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
        int ergRechne = 0;
        ergRechne = a + b;
        return ergRechne;
    }
//    public int enter_region(int a, int b, int threadNr) {
//        int other = 1 - threadNr;
//        turn = other;
//        flag[threadNr] = true;
//        while (flag[other] && turn == other) {
//        }
//        leave_region(threadNr);
//        return rechnePlus(a, b, threadNr);
//    }
//
////    public int rechnePlus(int a, int b, int threadNr) {
////
////        setA(a);
////        setB(b);
////        this.erg = rechne();
////        System.out.println(threadNr);
////        return this.erg;
////    }
//
//    public void leave_region(int process) {
//        flag[process] = false;
////        System.out.println(process + " " );
//    }


    public int enter_region(int a, int b, int threadNr) {
        int other = 1 - threadNr;
        turn = other;
        flag[threadNr] = true;
        while (flag[other] && turn == other) ;
        setA(a);
        setB(b);
        this.erg = rechne();
        switch (threadNr) {
            default:
                break;
            case 0: {
                if (this.erg != 12) {
                    System.out.println("1. Thread Falsch");
                    System.exit(0);
                }
                break;
            }
            case 1: {
                if (this.erg != 10) {
                    System.out.println("2. Thread Falsch");
                    System.exit(0);
                }
                break;
            }

        }
        System.out.println(threadNr + " fertig");
        flag[threadNr] = false;
        return this.erg;
    }
}
