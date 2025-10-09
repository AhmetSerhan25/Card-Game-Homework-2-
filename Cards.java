import java.util.Random;

public class Cards {
public static final int NOOFCARDSINFULLPACK = 52;

private Card[] cards = new Card[NOOFCARDSINFULLPACK];
private int valid = 0; // number of cards in the collection

public Cards() { }

public Cards(boolean makeFullPack) {
if (makeFullPack) makeFullPack();
}


public int size() { return valid; }
public boolean isEmpty() { return valid == 0; }


public void clear() {
for (int i = 0; i < valid; i++) cards[i] = null;
valid = 0;
}

public void makeFullPack() {
clear();
for (int s = 0; s < Card.SUITS.length; s++) {
for (int f = 0; f < Card.NOOFCARDSINSUIT; f++) {
cards[valid] = new Card(s, f);
valid++;
}
}
}


public void addTop(Card c) {
if (valid >= cards.length) return;
cards[valid] = c;
valid++;
}


public Card dealTop() {
if (valid == 0) return null;
valid--;
Card c = cards[valid];
cards[valid] = null;
return c;
}


public Card get(int i) {
if (i < 0 || i >= valid) return null;
return cards[i];
}


public void shuffle() {
Random rnd = new Random();
for (int i = valid - 1; i > 0; i--) {
int j = rnd.nextInt(i + 1);
Card tmp = cards[i];
cards[i] = cards[j];
cards[j] = tmp;
}
}
}
