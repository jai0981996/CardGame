package org.jai;

public class Suit extends Deck{
    //Constructor to initiate the single suit
    public Suit(String type) {
        super();
        int cardValueCounter=2;
        while (cardValueCounter<=14)
        {
            super.addCards(new Card(cardValueCounter,type));
            cardValueCounter++;
        }
    }
}
