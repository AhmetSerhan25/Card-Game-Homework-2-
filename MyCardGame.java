import cardgame.*;
import java.util.Scanner;


// MyCardGame - provides a menu allowing any of the players to play their card,
//              an option to see the score card, and one to quit the game at any time.
//              When the game is over it dislays the winners.
// author: Ayşe Irmak Ceylan 
// date:
public class MyCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of MyCardGame\n");
        
        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        
        // VARIABLES
        Player     p1, p2, p3, p4;
        CardGame   game;
        int        selection;
        
        // PROGRAM CODE

        // create players...
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");
        p4 = new Player( "p4");
        
        // create game with the 4 players...
        game = new CardGame( p1, p2, p3, p4);
        
        // display menu, get and process selection, until exit
        do 
        {
            // display menu
            System.out.println();
            System.out.println( "MyCardGame   Round: " + game.getRoundNo() 
                                 + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
            System.out.println( MENU_SCORES  + " - Show scores" );
            
            // ask for and get selection
            System.out.println();
            System.out.print( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();
            
            // process selection
            if ( selection == MENU_PLAY_P1 )
                play( p1, game);
            
            else if ( selection == MENU_PLAY_P2 )
                play( p2, game);
            
            else if ( selection == MENU_PLAY_P3 )
                play( p3, game);
            
            else if ( selection == MENU_PLAY_P4 )
                play( p4, game);
            
            else if ( selection == MENU_SCORES )
                System.out.println( game.showScoreCard() );

            else if ( selection != MENU_EXIT)
                System.out.println( "Invalid selection! \n" );
            
        } while ( selection != MENU_EXIT);

        // display winners...
        if(game.isGameOver()) {
            Player[] winners = game.getWinners();
            System.out.println("\nGame over! Winners: ");
            for(Player winner : winners) {
                if(winner != null) {
                    System.out.println(winner.getName());
                }
            }
        }
        
        System.out.println( "\nEnd of MyCardGame\n" );   
        scan.close();
    }

    // get the card, c, that player p wants to play
    // pass c to the game, see if it accepted c from p
    // if game didn't accept the card, give c back to the player! 
    // return accepted.
    private static boolean play( Player p, CardGame game)
    {
        Card       c;
        boolean    accepted;
        
        // check it it's player' s turn
        if(!game.isTurnOf(p)) {
            System.out.println("It's not " + p.getName() + "'s turn! Current turn: Player " + game.getTurnOfPlayerNo() + 1);
            return false;
        }

        // player plays a card
        c = p.playCard();
        if(c == null) {
            System.out.println(p.getName() + " has no cards left!");
            return false;
        }

        // try to play the card in the game
        accepted = game.playTurn(p, c);

        if(!accepted) {
            // if not accepted, return card to player
            p.add(c);
            System.out.println("Invalid move! Card returned to " + p.getName());
        } else {
            System.out.println(p.getName() + "played: " + c);
        }

        return accepted;
    }
    
} // end class MyCardGame
