/**
 * Created by doetken on 30.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        Rechner r = new Rechner(3, 5);

        new Thread() {
            public void run() {
                r.setA(5);
                r.setB(8);
                r.rechne();
            }
        }.start();

        new Thread() {
            public void run() {
                r.setA(2);
                r.setB(7);
                r.rechne();
            }
        }.start();
    }
}
