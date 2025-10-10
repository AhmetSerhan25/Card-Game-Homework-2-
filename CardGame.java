package cardgame;

import java.util.ArrayList;

// Cardgame
// author: Esma Karakaya
// date: 10.10.2025
public class CardGame {
    // properties
    Cards fullPack;
    ArrayList<Player> players;
    ScoreCard scoreCard;
    Cards[] cardsOnTable;
    int roundNo;
    int turnOfPlayer;

    // constructors
    public CardGame(Player p1, Player p2, Player p3, Player p4) {
        players = new ArrayList<Player>();
        this.scoreCard = new ScoreCard(4);
        this.roundNo = 1;
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        fullPack = new Cards(true);
        fullPack.shuffle();

        int cardsPerPlayer = 5;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player pl : players) {
                Card c = fullPack.getTopCard();
                if (c != null) {
                    pl.add(c);
                }
            }
        }
        this.turnOfPlayer = 0;
    }

    // methods
    public boolean playTurn(Player p, Card c) {
        if (players.get(turnOfPlayer).equals(p)) {
            turnOfPlayer = (turnOfPlayer + 1) % players.size();
            if (turnOfPlayer == 0) {
                roundNo++;
                scoreCard.update(turnOfPlayer, c.getFaceValue());
            }
            return true;
        } else {
            System.out.println("It's not " + p.getName() + "'s turn!");
            return false;
        }
    }

    public boolean isTurnOf(Player p) {
        return players.get(turnOfPlayer).equals(p);
    }

    public boolean isGameOver() {
        boolean gameOver = false;

        for (Player pl : players) {
            if (pl.playCard() == null) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    public int getScore(int playerNumber) {
        return scoreCard.getScore(playerNumber);
    }

    public String getName(int playerNumber) {
        if (playerNumber >= 0 && playerNumber < players.size()) {
            return players.get(playerNumber).getName();
        }
        return "Not yet implemented";
    }

    public int getRoundNo() {
        return roundNo;
    }

    public int getTurnOfPlayerNo() {
        return turnOfPlayer;
    }

    public Player[] getWinners() {
        int[] winnerScores = scoreCard.getWinners();

        int count = 0;
        for (int score : winnerScores) {
            if (score == 1)
                count++;
        }

        Player[] winners = new Player[count];

        int idx = 0;
        for (int i = 0; i < players.size(); i++) {
            if (winnerScores[i] == 1) {
                winners[idx] = players.get(i);
                idx++;
            }
        }

        return winners;
    }

    public String showScoreCard() {
        return scoreCard.toString();
    }
}

