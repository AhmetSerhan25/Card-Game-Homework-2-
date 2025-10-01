package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Esma Karakaya
// date: 10/01/2025
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        Arraylist<Player> players = new ArrayList<Player>();
        Cards[] cardsOnTable = new Cards[NOOFCARDSINFULLPACK];
        roundNo = 0;
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // Todo
        return false;
    }
    
    public boolean isTurnOf( Player p)
    {
        // ToDo
        return false;
    }
    
    public boolean isGameOver()
    {
        // ToDo
        return false;
    }
    
    public int getScore( int playerNumber)
    {
        // ToDo
        return -1;
    }
    
    public String getName( int playerNumber)
    {
        boolean done = false;
        int index = 0;
        while(!done){
            int currentPlayerNumber = players.get(index).charAt(1);
            if(currentPlayerNumber == playerNumber){
                return players.getName(index);
            }
            index++;
            if(index > players.size()){
                done = true;
            }
        }
        return "Not yet implemented";
    }
    
    public int getRoundNo()
    {
        //ToDo
        return -1;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return -1;
    }
    
    public Player[] getWinners()
    {
        // ToDo
        return null;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}