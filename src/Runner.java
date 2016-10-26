/**
 * Created by doetken on 30.09.2016.
 */
public class Runner {

    public static void main(String[] args) {
//  WICHTIG:    Beide Threads greifen auf die gleichen, weil global erzeugte Instanz des Rechners zu
        final Rechner r = new Rechner(3, 5);
        new Thread() {
            public void run() {
                synchronized (r) {
                    System.out.println(r.rechnePlus(5, 7));

//                int erg;
//                while (true) {
//                    erg = r.enter_region(5, 7, 0);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                synchronized (r) {
                    System.out.println(r.rechnePlus(4, 6));
//                int erg;
//                while (true) {
//                    erg = r.enter_region(4, 6, 1);
//                }
                }
            }
        }.start();
    }
}