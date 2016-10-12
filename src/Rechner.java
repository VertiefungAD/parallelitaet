/**
 * Created by doetken on 30.09.2016.
 */
public class Rechner {

    private int turn;
    private int a = 0;
    private int b = 0;
    //  zur Anwendung des Algorythmus notwendige Variablen werden als private Attribute deklariert
    // initialisiert werden die flags ("Zeichen, dass der Thread in den kritischen Bereich möchte") mit false,
    // dies ändert der jeweilige Thread, wenn er die Methode des Rechners aufruft
    private boolean[] flag = new boolean[2];
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

    //BETROFFENE METHODE:
    // Die Methode weiss, mit welchen Zahlen sie rechnen soll
    // und an Hand der threadNr welcher Thread (s. Runner) auf sie zugreift
    public int rechnePlus(int a, int b, int threadNr) {

        this.flag[0] = false;
        this.flag[1] = false;
//        Dekker:
        // if-Verzweigung unterscheidet nach den beiden Threads
        //turn wird auf die jeweilige threadNr gesetzt
        this.turn = threadNr;
        // default: flags = false, wird nun true gesetzt
        this.flag[threadNr] = true;
        // Schleife wird begonnen, wenn der andere Thread bereits sein flag auf true gesetzt hat, sonst direkt Kritischer Bereich
        while (this.flag[1 - threadNr]) {
            // weitere Frage und Wartezeit nur, wenn der andere Thread nicht schon für diesen Thread das turn gesetzt hat
            if (this.turn != threadNr) {
                // wenn noch nicht "gleich" frei, dann verzichtet dieser Thread erstmal
                // auf die Anfrage an den kritischen Bereich
                this.flag[threadNr] = false;
                // ...und der Thread wartet bis der andere Thread turn auf die ID dieses Threads setzt
                while (this.turn != threadNr) {
                }
                // nun hat ja der andere Thread den kritischen Bereich offensichtlich verlassen und dieser Thread
                // meldet Anspruch mit flag=true
                this.flag[threadNr] = true;
            }
        }
//      Kritischer Bereich Beginn
        setA(a);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setB(b);
        erg = rechne();
        //      Kritischer Bereich Ende

            this.turn = 1-threadNr;
            this.flag[threadNr] = false;

        return erg;
    }
}
