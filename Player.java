package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Enis Kağan Uysal
// date:10.10.2025
public class Player {
    // properties
    String name;
    Cards hand;

    // constructors
    public Player(String name) {
        this.name = name;
        this.hand = new Cards();
    }

    // methods
    public String getName() {
        return name;
    }

    public void add(Card c) {
        hand.addTopCard(c);
    }

    public Card playCard() {
        return hand.getTopCard();
    }

} // end class Player
