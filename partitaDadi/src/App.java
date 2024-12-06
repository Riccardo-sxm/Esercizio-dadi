import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        // dichiaro le variabili
        int dado1, dado2, dadopc1, dadopc2, sommadadi, sommadadipc, puntiUtente, puntiPC;
        boolean cont = true;
        double budgetTotale, budgetScommesso;
        budgetTotale = 100;

        while (cont) {
            System.out.println("Giochiamo a dadi! Il tuo budget è di " + budgetTotale + "euro");

            // assegno i valori di punteggio iniziali
            puntiPC = 0;
            puntiUtente = 0;

            do {
                System.out.println("Quanto vuoi puntare?");
                budgetScommesso = sc.nextDouble();
                if (budgetScommesso > budgetTotale) {  //controllo che l'importo inserito sia valido
                    System.out.println("Non puoi scommettere più del tuo budget!");

                } else if (budgetScommesso <= 0) {
                    System.out.println("Non puoi scommettere una somma minore o uguale a 0!");
                }
            } while (budgetScommesso > budgetTotale || budgetScommesso <= 0);
            System.out.println("----------------------------------------------------------");
            // creo il ciclo dei tre turni
            for (int turno = 0; turno < 3; turno++) {
                
                    dado1 = rnd.nextInt(6) + 1;
                    dado2 = rnd.nextInt(6) + 1;
                    sommadadi = dado1 + dado2;
                    System.out.println("Hai fatto: "+ dado1 + " e " + dado2 +" ("+ sommadadi + ")"); // faccio visualizzare la somma dei tiri dell'utente
                    dadopc1 = rnd.nextInt(6) + 1;
                    dadopc2 = rnd.nextInt(6) + 1;
                    sommadadipc = dadopc1 + dadopc2;
                    System.out.println("Il pc ha fatto: "+ dadopc1 + " e " + dadopc2 +" ("+ sommadadipc + ")"); // faccio visualizzare la somma dei tiri del pc

                    if (sommadadi == sommadadipc)
                        System.out.println("Hai pareggiato."); // in caso di pareggio il punteggio rimane invariato
                  
                    else {
                        if (sommadadi > sommadadipc) {
                            System.out.println("Hai vinto!");
                            puntiUtente = puntiUtente + 1; // in caso di vittoria aumenta il punteggio dell'utente
                        } else {
                            System.out.println("Il pc ha vinto.");
                            puntiPC = puntiPC + 1; // in caso di sconfitta aumenta il punteggio del PC
                        }
                    }          
                    System.out.println();                                  
                
            }
            
            System.out.println(puntiUtente + "-" + puntiPC);  // al di fuori del ciclo, stampo punteggio e risultato della partita
            if (puntiPC == puntiUtente) {
                System.out.println("E' un pareggio! Il tuo budget è rimasto invariato");
            } else {
                if (puntiUtente > puntiPC) {
                    System.out.println("Hai vinto la partita!");
                    budgetTotale = budgetTotale + budgetScommesso ;  //incremento il budget in caso di vincita
                    System.out.println("Bravo! Hai vinto " + budgetScommesso + " euro. Il tuo budget è di " + budgetTotale + " euro "); //
                } else {
                    System.out.println("Hai perso la partita!");
                    budgetTotale = budgetTotale - budgetScommesso;  //decremento il budget in caso di perdita
                    System.out.println("Mi dispiace! Hai perso " + budgetScommesso + " euro. Il tuo budget è di " + budgetTotale + " euro ");
                }
                System.out.println("----------------------------------------------------------");
            }

            if (budgetTotale <=0) {
                cont = false;
                System.out.println("Il tuo budget è esaurito!");
            } else {
            System.out.println("Vuoi continuare a giocare? (true/false)");
            cont = sc.nextBoolean();
        }
        System.out.println();
           
        }
        System.out.println("");
        System.out.println("Grazie per aver giocato con noi, alla prossima!");

        sc.close();
    }
}
