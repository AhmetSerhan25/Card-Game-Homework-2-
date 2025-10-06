package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Esma Karakaya
// date: 
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
        players = new ArrayList<Player>();
        ScoreCard scoreCard = new ScoreCard(4);
        roundNo = 0;
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        if(p.playCard() == c){
            return true;
        }
        return false;
    }
    
    public boolean isTurnOf( Player p)
    {
        if(p.getName().equals(getName(getTurnOfPlayerNo()))){
            return true;
        }
        return false;
    }
    
    public boolean isGameOver()
    {
        boolean gameOver = false;

        for(Player pl : players){
            if(pl.playCard() == null){
                gameOver = true;
            }
        }
        return gameOver;
    }
    
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        boolean done = false;
        int index = 0;
        while(!done){
            int currentPlayerNumber = players.get(index).getName().charAt(1);
            if(currentPlayerNumber == playerNumber){
                return players.get(index).getName();
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
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        //if the player is winner than it have 1 for its index at int[] winnerArray
        int[] winnerScores = scoreCard.getWinners();
        Player[] winners;

        for(int index = 0; index < players.size(); index++){
            if(winnerScores[index] == 1){
                winners[index] = players.get(index);
            }
        }
        return winners;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
}
