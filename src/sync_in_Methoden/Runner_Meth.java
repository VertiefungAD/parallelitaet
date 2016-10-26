package sync_in_Methoden;

/**
 * Created by doetken on 30.09.2016.
 */
public class Runner_Meth {

    public static void main(String[] args) {
//  WICHTIG:    Beide Threads greifen auf die gleichen, weil global erzeugte Instanz des Rechners zu
        final Rechner_Meth r = new Rechner_Meth(3, 5);


        new Thread() {
            public void run() {
                int counter1 = 1;
                while (counter1 < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.setA(5);
                    System.out.println("1 hat A gesetzt");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.setB(7);
                    System.out.println("1 hat B gesetzt");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.rechne();
                    System.out.println("1 hat gerechnet");
                    System.out.println("Anzahl 1: " + counter1);
                    counter1++;
                }
            }
        }.start();

        new Thread() {
            public void run() {
                int counter2 = 1;
                while (counter2 < 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.setA(4);
                    System.out.println("2 hat A gesetzt");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.setB(6);
                    System.out.println("2 hat B gesetzt");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    r.rechne();
                    System.out.println("2 hat gerechnet");
                    System.out.println("Anzahl 2: " + counter2);
                    counter2++;
                }
            }
        }.start();
    }
}