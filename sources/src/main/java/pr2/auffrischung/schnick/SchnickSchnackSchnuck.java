package pr2.auffrischung.schnick;

import java.util.Scanner;
import java.util.Random;

public class SchnickSchnackSchnuck {

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
        return ' '; // Platzhalter, muss ersetzt werden
    }

    // Methode um den Zug des Computers zu bekommen
    public static int getComputerMove(Random random) {
        // TODO: Zufällige Auswahl für den Computer (Rock, Paper, Scissors)
        return 0; // Platzhalter, muss ersetzt werden
    }

    // Methode um das Ergebnis der Runde zu evaluieren
    public static int evaluateRound(char playerMove, int computerMove) {
        // TODO: Berechne das Ergebnis der Runde (1 = Spieler gewinnt, -1 = Computer gewinnt, 0 = Unentschieden)
        return 0; // Platzhalter, muss ersetzt werden
    }

    // Methode um das Ergebnis der Runde anzuzeigen
    public static void displayRoundResult(int round, char playerMove, int computerMove, int roundResult, int playerPoints, int computerPoints) {
        // TODO: Ausgabe des Ergebnisses der Runde
    }

    // Methode um den Endpunktestand anzuzeigen
    public static void displayFinalScore(int playerPoints, int computerPoints) {
        // TODO: Ausgabe des Endpunktestands
    }
}