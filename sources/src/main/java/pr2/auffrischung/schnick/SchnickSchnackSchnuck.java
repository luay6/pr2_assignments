package pr2.auffrischung.schnick;

import java.util.Scanner;
import java.util.Random;

public class SchnickSchnackSchnuck {
    final static int PAPER = 3;
    final static int ROCK = 2;
    final static int SCISSOR =1;
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
            char playerMove = getPlayerMove(round, scanner);
            
            // Computerzug generieren
            int computerMove = getComputerMove(random);
            
            String playerMoveString = playerMovesToStrings(playerMove);
            
            String computerMoveString = computerMovementsToStrings(computerMove);
            
            // Ergebnis der Runde auswerten
            int roundResult = evaluateRound(playerMove, computerMove);
            
            // Punktestand aktualisieren
            if (roundResult == 1) {
                playerPoints++;
            } else if (roundResult == -1) {
                computerPoints++;
            }
            
            // Runde auswerten und anzeigen
            displayRoundResult(round, playerMove, computerMove, roundResult, playerPoints, computerPoints, playerMoveString, computerMoveString);
        }
        
        // Endpunktestand anzeigen
        displayFinalScore(playerPoints, computerPoints);
    }

    // Methode um den Zug des Spielers zu erhalten
    public static char getPlayerMove(int round, Scanner scanner) {
        System.out.println();
        System.out.print("Runde " + round + ": Dein Zug ([r]ock, [p]aper, [s]cissors)? ");
        char playerMove = scanner.next().charAt(0);

        while (playerMove != 'r' & playerMove != 'p' & playerMove != 's') {
            System.err.println("Ungültige Eingabe, versuch es erneut!");
            System.out.print("Runde " + round + ": Dein Zug ([r]ock, [p]aper, [s]cissors)? ");
            playerMove = scanner.next().charAt(0);
        } 
            
            return playerMove;
    }

    // Methode um den Zug des Computers zu bekommen
    public static int getComputerMove(Random random) {
        
        int computerMove = random.nextInt(3)+1;
        return computerMove;
    }
    
    public static String playerMovesToStrings(char playerMove) {
        
        switch(playerMove) {
        case 'r' : return "ROCK";
        case 'p' : return "PAPER";
        case 's' : return "SCISSORS";
        default  : return "Ungültig";
        
        }  
    }
    
    public static String computerMovementsToStrings(int computerMove) {
        
        switch(computerMove) {
        case ROCK : return "ROCK";
        case PAPER : return "PAPER";
        case SCISSOR : return "SCISSORS";
        default: return "Ungültig";
        
        }
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
        if (Math.abs(playerMoveInt - computerMove) == 1) {
            if (playerMoveInt > computerMove)
            return 1;
            else
                return -1;
        }
        //Computer gewinn
        else if(Math.abs(playerMoveInt - computerMove) == 2) {
            if (playerMoveInt > computerMove)
                return -1;
                else
                    return 1;
            }
            
        //Unentschieden
        else if(playerMoveInt - computerMove == 0)
            return 0;
        else
            return UNGUELTIG;
    }
    
    

    // Methode um das Ergebnis der Runde anzuzeigen
    public static void displayRoundResult(int round, char playerMove, int computerMove, int roundResult, int playerPoints, int computerPoints
            , String playerMoveString, String computerMoveString) {
        
        
        if (roundResult == 1) {
            System.out.print("Du hast gewonnen: ");
        }
        else if (roundResult == -1) {
            System.out.print("Der Computer hat gewonnen - ");
        }
        else if (roundResult == 0) {
            System.out.print("Unentschieden - ");
        }
        
        System.out.println("Du: " + playerMoveString + ", Computer: " + computerMoveString + " - [" + playerPoints + ":" + computerPoints + "]");
        
        
        }

    // Methode um den Endpunktestand anzuzeigen
    public static void displayFinalScore(int playerPoints, int computerPoints) {
        System.out.println("Ergebnis - Du " + playerPoints + " Punkt(e), Computer " + computerPoints + "Punkt(e)");
        if(computerPoints < playerPoints)
            System.out.println("Du hast im Spiel gewonnen");
        else if(computerPoints > playerPoints)
            System.out.println("Computer hat im Spiel gewonnen");
        else
            System.out.println("Unentschieden");
        
    }
}