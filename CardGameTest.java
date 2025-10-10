import java.util.Scanner;

// CardGameTest
// author: Ahmet Serhan Görükmez
// date: 2/10/2025
public class CardGameTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Start of CardGameTest\n");

        // CONSTANTS

        // VARIABLES
        Card c;
        Cards cards;
        ScoreCard scores;
        Player p1;
        Player p2;
        Player p3;
        Player p4;
        CardGame game;
        Player player;

        // PROGRAM CODE

        // test Card class
        c = new Card(1, 1);
        System.out.println(c);
        System.out.println();

        // test Cards class
        cards = new Cards(true);
        cards.addTopCard(c);
        //cards.testOnlyPrint(); // remove method after testing!

        System.out.println("Deck size after adding test card: " + cards.size());

        // test ScoreCard class
        scores = new ScoreCard(4);
        scores.update(3, 1);
        scores.update(1, 2);
        System.out.println("\n" + scores);

        // test Player class
        // ToDo
        player = new Player("John");
        System.out.println("\nTesting Player class...");
        player.add(c);
        System.out.println("Added card: " + c);
        Card played = player.playCard();
        System.out.println("Played card: " + played);
        System.out.println();

        // test CardGame class too?
        // Todo
        System.out.println("Testing CardGame class:");
        p1 = new Player("Chris");
        p2 = new Player("Lara");
        p3 = new Player("Mary");
        p4 = new Player("James");
        
        game = new CardGame(p1, p2, p3, p4);
        System.out.println("Game created with 4 players.");
        System.out.println("Round number: " + game.getRoundNo());
        System.out.println("Turn of player no: " + game.getTurnOfPlayerNo());
        System.out.println("ScoreCard:\n" + game.showScoreCard());
        System.out.println();
        
        // === Test isTurnOf() method ===
        System.out.println("Testing isTurnOf():");
        System.out.println("Is it " + p1.getName() + "'s turn? " + game.isTurnOf(p1));
        System.out.println();
        
        // === Test isGameOver() method ===
        System.out.println("Testing isGameOver():");
        boolean over = game.isGameOver();
        System.out.println("Game over? " + over);
        System.out.println();
        
        // === Test getWinners() ===
        System.out.println("Testing getWinners():");
        Player[] winners = game.getWinners();
        if (winners != null) {
            for (int i = 0; i < winners.length; i++) {
                if (winners[i] != null)
                    System.out.println("Winner: " + winners[i].getName());
            }
        } else {
            System.out.println("No winners yet.");
        }

        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.

        System.out.println("\nEnd of CardGameTest\n");
    }

} // end of class CardGameTest
 