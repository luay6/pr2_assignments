package pr2.auffrischung.schnick;

import java.util.Scanner;
import java.util.Random;

public class SchnickSchnackSchnuck {
    final static int PAPER = 1;
    final static int ROCK = 2;
    final static int SCISSOR =3;
    final static int UNGUELTIG = 10;
    public static void main(String[] args) {
        // Initialisieren der Spielvariablen
        int playerPoints = 0;
        int computerPoints = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Drei Runden spielen
        for (int round = 1; round <= 3; round++) {
            // Spieler eingeben lassen
            char playerMove = getPlayerMove(scanner);
            
            // Computerzug generieren
            int computerMove = getComputerMove(random);
            
            // Ergebnis der Runde auswerten
            int roundResult = evaluateRound(playerMove, computerMove);
            
            // Punktestand aktualisieren
            if (roundResult == 1) {
                playerPoints++;
            } else if (roundResult == -1) {
                computerPoints++;
            }
            
            // Runde auswerten und anzeigen
            displayRoundResult(round, playerMove, computerMove, roundResult, playerPoints, computerPoints);
        }
        
        // Endpunktestand anzeigen
        displayFinalScore(playerPoints, computerPoints);
    }

    // Methode um den Zug des Spielers zu erhalten
    public static char getPlayerMove(Scanner scanner) {
        // TODO: Implementiere Eingabeaufforderung und Rückgabe des Spielerzuges
        
        //Majd
        
        return ' '; // Platzhalter, muss ersetzt werden
    }

    // Methode um den Zug des Computers zu bekommen
    public static int getComputerMove(Random random) {
        // TODO: Zufällige Auswahl für den Computer (Rock, Paper, Scissors)
        
        //Majd
        
        return 0; // Platzhalter, muss ersetzt werden
    }

    // Methode um das Ergebnis der Runde zu evaluieren
    public static int evaluateRound(char playerMove, int computerMove) {
        int playerMoveInt;
        switch (playerMove) {
        case 'r' : playerMoveInt = ROCK;
        break;
        case 'p' : playerMoveInt = PAPER;
        break;
        case 's' : playerMoveInt = SCISSOR;
        break;
        default : playerMoveInt = UNGUELTIG;
        }
        //Player gewinn
        if (playerMoveInt - computerMove == 1)
            return 1;
        //Computer gewinn
        else if(playerMoveInt - computerMove ==2)
            return -1;
        //Unentschieden
        else if(playerMoveInt - computerMove == 0)
            return 0;
        else
            return UNGUELTIG;
    }

    // Methode um das Ergebnis der Runde anzuzeigen
    public static void displayRoundResult(int round, char playerMove, int computerMove, int roundResult, int playerPoints, int computerPoints) {
        
        //majd
        
        // TODO: Ausgabe des Ergebnisses der Runde
    }

    // Methode um den Endpunktestand anzuzeigen
    public static void displayFinalScore(int playerPoints, int computerPoints) {
        System.out.println("Ergebnis - Du " + playerPoints + "Punkt(e), Computer " + computerPoints + "Punkt(e)");
        if(computerPoints < playerPoints)
            System.out.println("Du hast im Spiel gewonnen");
        else if(computerPoints > playerPoints)
            System.out.println("Computer hat im Spiel gewonnen");
        else
            System.out.println("Unentschieden");
        
    }
}