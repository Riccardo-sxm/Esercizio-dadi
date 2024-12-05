import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        // dichiaro le variabili
        int dado1, dado2, dadopc1, dadopc2,
                risposta, sommadadi, sommadadipc, puntiUtente, puntiPC;
        boolean cont = true;
        

        while (cont) {
            System.out.println("Giochiamo a dadi!");

            // assegno i valori di punteggio iniziali
            puntiPC = 0;
            puntiUtente = 0;

            // creo il ciclo dei tre turni
            for (int turno = 0; turno < 3; turno++) {
                System.out.println("Vuoi tirare i dadi? 1)Sì 2)No"); // lascio decidere all'utente se tirare o meno i
                                                                     // dadi
                risposta = sc.nextInt();

                if (risposta == 1) { // se accetta iniziano i tiri per il turno
                    dado1 = rnd.nextInt(6) + 1;
                    dado2 = rnd.nextInt(6) + 1;
                    sommadadi = dado1 + dado2;
                    System.out.println("Hai fatto: " + sommadadi); // faccio visualizzare la somma dei suoi tiri
                    dadopc1 = rnd.nextInt(6) + 1;
                    dadopc2 = rnd.nextInt(6) + 1;
                    sommadadipc = dadopc1 + dadopc2;
                    System.out.println("Il pc ha fatto: " + sommadadipc); // faccio visualizzare la somma dei tiri del
                                                                          // pc
                    if (sommadadi == sommadadipc)
                        System.out.println("Hai pareggiato."); // pareggio
                    else {
                        if (sommadadi > sommadadipc) {
                            System.out.println("Hai vinto!");
                            puntiUtente = puntiUtente + 1; // nel caso di vittoria aumenta il tuo punteggio
                        } else {
                            System.out.println("Il pc ha vinto.");
                            puntiPC = puntiPC + 1; // nel caso di sconfitta aumenta il punteggio del PC
                        }
                    }
                }
            }
            // al di fuori del ciclo, stampo punteggio e risultato della partita
            System.out.println(puntiUtente + "-" + puntiPC);
            if (puntiPC == puntiUtente) {
                System.out.println("E' un pareggio!");
            } else {
                if (puntiUtente > puntiPC) {
                    System.out.println("Hai vinto la partita!");
                } else {
                    System.out.println("Hai perso la partita!");
                }
            }

            System.out.println("Vuoi continuare a giocare?");
            cont = sc.nextBoolean();
        }
        System.out.println("");
        System.out.println("Grazie per aver giocato con noi, alla prossima!");

        sc.close();
    }
}
