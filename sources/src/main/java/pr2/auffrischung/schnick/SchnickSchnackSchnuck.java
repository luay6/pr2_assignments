package pr2.auffrischung.schnick;

import java.util.Scanner;
import java.util.Random;

/**
 * Ein einfaches Schnick-Schnack-Schnuck-Spiel (Rock-Paper-Scissors),
 * das über drei Runden gegen den Computer gespielt wird.
 */
public class SchnickSchnackSchnuck {

    
    final static int PAPER = 3;
    
    final static int ROCK = 2;
    
    final static int SCISSOR = 1;
    
    final static int UNGUELTIG = 10;

    
    public static void main(String[] args) {
        int playerPoints = 0;
        int computerPoints = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int round = 1; round <= 3; round++) {
            char playerMove = getPlayerMove(round, scanner);
            int computerMove = getComputerMove(random);
            String playerMoveString = playerMovesToStrings(playerMove);
            String computerMoveString = computerMovementsToStrings(computerMove);

            int roundResult = evaluateRound(playerMove, computerMove);

            if (roundResult == 1) {
                playerPoints++;
            } else if (roundResult == -1) {
                computerPoints++;
            }

            displayRoundResult(round, playerMove, computerMove, roundResult,
                    playerPoints, computerPoints, playerMoveString, computerMoveString);
        }

        displayFinalScore(playerPoints, computerPoints);
        scanner.close();
    }

    /**
     * Liest den Zug des Spielers von der Konsole ein.
     * @param round aktuelle Rundennummer
     * @param scanner Scanner zum Einlesen der Eingabe
     * @return der eingegebene Zug ('r', 'p' oder 's')
     */
    public static char getPlayerMove(int round, Scanner scanner) {
        System.out.println();
        System.out.print("Runde " + round + ": Dein Zug ([r]ock, [p]aper, [s]cissors)? ");
        char playerMove = scanner.next().charAt(0);

        while (playerMove != 'r' && playerMove != 'p' && playerMove != 's') {
            System.err.println("Ungültige Eingabe, versuch es erneut!");
            System.out.print("Runde " + round + ": Dein Zug ([r]ock, [p]aper, [s]cissors)? ");
            playerMove = scanner.next().charAt(0);
        }

        return playerMove;
    }

    /**
     * Erzeugt einen zufälligen Zug für den Computer.
     * @param random Zufallszahlengenerator
     * @return der Zug des Computers als Integer (1–3)
     */
    public static int getComputerMove(Random random) {
        return random.nextInt(3) + 1;
    }

    /**
     * Wandelt den Spielzug des Spielers in eine String-Darstellung um.
     * @param playerMove Zeichen für den Spielzug des Spielers ('r', 'p', 's')
     * @return der entsprechende String ("ROCK", "PAPER", "SCISSORS")
     */
    public static String playerMovesToStrings(char playerMove) {
        switch (playerMove) {
            case 'r': return "ROCK";
            case 'p': return "PAPER";
            case 's': return "SCISSORS";
            default: return "Ungültig";
        }
    }

    /**
     * Wandelt den Spielzug des Computers in eine String-Darstellung um.
     * @param computerMove Zahl für den Zug des Computers (1–3)
     * @return der entsprechende String ("ROCK", "PAPER", "SCISSORS")
     */
    public static String computerMovementsToStrings(int computerMove) {
        switch (computerMove) {
            case ROCK: return "ROCK";
            case PAPER: return "PAPER";
            case SCISSOR: return "SCISSORS";
            default: return "Ungültig";
        }
    }

    /**
     * Bestimmt das Ergebnis einer Runde.
     * @param playerMove Zug des Spielers ('r', 'p', 's')
     * @param computerMove Zug des Computers (1–3)
     * @return 1 wenn Spieler gewinnt, -1 wenn Computer gewinnt, 0 bei Unentschieden
     */
    public static int evaluateRound(char playerMove, int computerMove) {
        int playerMoveInt;
        switch (playerMove) {
            case 'r': playerMoveInt = ROCK; break;
            case 'p': playerMoveInt = PAPER; break;
            case 's': playerMoveInt = SCISSOR; break;
            default: playerMoveInt = UNGUELTIG;
        }

        if (Math.abs(playerMoveInt - computerMove) == 1) {
            return (playerMoveInt > computerMove) ? 1 : -1;
        } else if (Math.abs(playerMoveInt - computerMove) == 2) {
            return (playerMoveInt > computerMove) ? -1 : 1;
        } else if (playerMoveInt - computerMove == 0) {
            return 0;
        } else {
            return UNGUELTIG;
        }
    }

    /**
     * Gibt das Ergebnis einer Runde auf der Konsole aus.
     * @param round aktuelle Rundennummer
     * @param playerMove Zug des Spielers
     * @param computerMove Zug des Computers
     * @param roundResult Ergebnis der Runde (1, 0, -1)
     * @param playerPoints aktueller Punktestand des Spielers
     * @param computerPoints aktueller Punktestand des Computers
     * @param playerMoveString String-Darstellung des Spielerzugs
     * @param computerMoveString String-Darstellung des Computerzugs
     */
    public static void displayRoundResult(int round, char playerMove, int computerMove, int roundResult,
                                          int playerPoints, int computerPoints,
                                          String playerMoveString, String computerMoveString) {

        if (roundResult == 1) {
            System.out.print("Du hast gewonnen: ");
        } else if (roundResult == -1) {
            System.out.print("Der Computer hat gewonnen - ");
        } else if (roundResult == 0) {
            System.out.print("Unentschieden - ");
        }

        System.out.println("Du: " + playerMoveString + ", Computer: " + computerMoveString +
                " - [" + playerPoints + ":" + computerPoints + "]");
    }

    /**
     * Zeigt den finalen Punktestand und das Gesamtergebnis an.
     * @param playerPoints Punkte des Spielers
     * @param computerPoints Punkte des Computers
     */
    public static void displayFinalScore(int playerPoints, int computerPoints) {
        System.out.println("Ergebnis - Du " + playerPoints + " Punkt(e), Computer " +
                computerPoints + " Punkt(e)");
        if (computerPoints < playerPoints)
            System.out.println("Du hast im Spiel gewonnen");
        else if (computerPoints > playerPoints)
            System.out.println("Computer hat im Spiel gewonnen");
        else
            System.out.println("Unentschieden");
    }
}