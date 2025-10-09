package cardgame;
public class Card {
public static final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs" };
public static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
public static final int NOOFCARDSINSUIT = 13;

private final int suit; // 0..3
private final int faceValue; // 0..12

public Card(int suit, int faceValue) {
if (suit < 0 || suit >= SUITS.length) suit = 0;
if (faceValue < 0 || faceValue >= NOOFCARDSINSUIT) faceValue = 0;
this.suit = suit;
this.faceValue = faceValue;
}


public int getSuit() { return suit; }

public int getFaceValue() { return faceValue; }

public String getSuitName() { return SUITS[suit]; }

public String getFaceName() { return FACES[faceValue]; }

public String toString() { return getFaceName() + " of " + getSuitName(); }
}

