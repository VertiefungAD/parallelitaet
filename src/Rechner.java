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
    private boolean flag0 = false;
    private boolean flag1 = false;
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
//        Dekker:
        // if-Verzweigung unterscheidet nach den beiden Threads
        //turn wird auf die jeweilige threadNr gesetzt
        this.turn = threadNr;
        if (threadNr == 0) {
            // default: flags = false, wird nun true gesetzt
            this.flag0 = true;
            // Schleife wird begonnen, wenn der andere Thread bereits sein flag auf true gesetzt hat, sonst direkt Kritischer Bereich
            while (this.flag1) {
                // weitere Frage und Wartezeit nur, wenn der andere Thread nicht schon für diesen Thread das turn gesetzt hat
                if (this.turn != 0) {
                    // wenn noch nicht "gleich" frei, dann verzichtet dieser Thread erstmal
                    // auf die Anfrage an den kritischen Bereich
                    this.flag0 = false;
                    // ...und der Thread wartet bis der andere Thread turn auf die ID dieses Threads setzt
                    while (this.turn != 0) {
                    }
                    // nun hat ja der andere Thread den kritischen Bereich offensichtlich verlassen und dieser Thread
                    // meldet Anspruch mit flag=true
                    this.flag0 = true;
                }
            }
        } else {
            // siehe oben, aber mit anderem Thread
            this.flag1 = true;
            while (this.flag0) {
                if (this.turn != 1) {
                    this.flag1 = false;
                    while (this.turn != 1) {
                    }
                    this.flag1 = true;
                }
            }
        }

// todo: ggf. könnte man mit Hilfe des Stringbuilders die Verzweigung löschen und den flag-Namen mit .append zusammenbauen...
        // Dazu: this.turn=threadNr;
        // StringBuilder sb = new StringBuilder();
        // sb.append("flag");
        // sb.append(threadNr);
        // getestet = Variablenname nicht dynamisch baubar!!
        //sb = true;
        // this.turn = threadNr;
        //      while (this.flag1) {
        //       if (this.turn != 0) {
        //         this.flag0 = false;
        //             while (this.turn != 0) {
        //               }
        //                this.flag0 = true;
        //               }


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

        // if-Verzweigung, welcher Thread gerade den kritischen Bereich durchlaufen hat
        if (threadNr == 0) {
            // turn wird auf die jeweils andere threadID gesetzt
            this.turn = 1;
            // eigenes flag wird auf 0 gesetzt
            this.flag0 = false;
        } else {
            // siehe oben
            this.turn = 0;
            this.flag1 = false;
        }
        return erg;
    }
}
