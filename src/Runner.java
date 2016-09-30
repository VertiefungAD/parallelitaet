/**
 * Created by doetken on 30.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        Rechner r = new Rechner(3, 5);
        new Thread() {
            public void run() {
                int erg =0;
                int counter1 = 0;
                while (true) {
                    erg=r.rechnePlus(5,7);
                    counter1++;
                    if (erg != 13) {
                        System.out.println("1. Thread Falsch");
                        System.out.println(counter1);
                        System.exit(0);
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                int erg = 0;
                int counter2 = 0;
                while (true) {
                    erg=r.rechnePlus(9,1);
                    counter2++;
                    if (erg != 9) {
                        System.out.println("2. Thread Falsch");
                        System.out.println(counter2);
                        System.exit(0);
                    }
                }
            }
        }.start();
    }
}

