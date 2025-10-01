package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    


    //In this return int array, ordering is same with scores array. Winers get 1, loosers get 0.
    public int[] getWinners()
    {
        int[] highests= new int[scores.length];
        int highest=scores[0];
        for (int i = 1; i < highests.length; i++) {
            if(scores[i]>highest){
                highest=scores[i];
            }
        }
        for (int i = 0; i < highests.length; i++) {
            if(scores[i]==highest){
                highests[i]=1;
            }
            else{
                highests[i]=0;
            }
        }

        return highests;
    }
    
} // end class ScoreCard
