/**
 * Created by doetken on 30.09.2016.
 */
public class Runner {

    public static void main(String[] args) {
//  WICHTIG:    Beide Threads greifen auf die gleichen, weil global erzeugte Instanz des REchners zu
        final Rechner r = new Rechner(3, 5);
        new Thread() {
            public void run() {
                int erg;
                int counter1 = 0;
                while (true) {
        // Thread gibt beide Zahlen zur Berechnung und "seine" ID als integer mit
            // mehr Änderungen sind nicht erforderlich
                erg = r.rechnePlus(5, 7, 0);
                    counter1++;
                    if (erg != 12) {
                        System.out.println("1. Thread Falsch");
                        System.out.println(counter1);
                        System.exit(0);
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                int erg;
                int counter2 = 0;
                while (true) {
                    erg = r.rechnePlus(9, 1, 1);
                    counter2++;
                    if (erg != 10) {
                        System.out.println("2. Thread Falsch");
                        System.out.println(counter2);
                        System.exit(0);
                    }
                }
            }
        }.start();
    }
}

