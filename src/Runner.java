/**
 * Created by doetken on 30.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        Rechner r = new Rechner(3, 5);

        while (true) {
            new Thread() {
                public void run() {
                    r.setA(5);
                    r.setB(8);
                    if (r.rechne() != 13) {
                        System.out.println("1. Thread Falsch");
                        System.exit(0);
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    r.setA(2);
                    r.setB(7);
                    r.rechne();
                    if (r.rechne() != 9) {
                        System.out.println("2. Thread Falsch");
                        System.exit(0);
                    }
                }
            }.start();
        }
    }
}
