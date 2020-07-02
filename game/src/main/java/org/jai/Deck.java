package org.jai;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    //Top card of the deck
    private Card topCard;

    //Bottom card of the deck
    private Card lastCard;


    //Adding the list of cards to the bottom of the deck
    public void addCards(Card... cards){
        for (Card card:cards){
        if (card==null)
            return;
        card.setNextCard(null);
        card.setPreviousCard(null);
        if (null == lastCard) {
            lastCard = card;
            topCard = card;
        } else {
            card.setPreviousCard(lastCard);
            lastCard.setNextCard(card);
            lastCard=card;
        }
        }
    }

    //Returns the number of cards provided in the parameter from the top of the deck
    public Card[] takeCards(int numerOfCards){
       List<Card> cardList=new ArrayList<>();
        for(int i=0;i<numerOfCards;i++) {
           if (null == topCard) {
               System.out.println("Deck is Empty");
               cardList.add(topCard);
           } else {
               Card returningCard = null;
               try {
                   returningCard = (Card) topCard.clone();
               } catch (CloneNotSupportedException e) {
                   e.printStackTrace();
               }
               topCard = topCard.getNextCard();
               returningCard.setPreviousCard(null);
               returningCard.setNextCard(null);
               cardList.add(returningCard);
           }
       }
        return cardList.toArray(new Card[0]);

    }
    //Printing all the cards in the deck
    public void printDeck(){
        if (null==topCard)
            System.out.println("Deck is empty");
        else
            printCardList(topCard);
    }
    //recursive method for printing cards
    private void printCardList(Card card){
        if(null==card){
            return;}
        else{
            System.out.println(card);;
            printCardList(card.getNextCard());
        }
    }
    //To find the total number of cards present in the deck
    public int totalNumberOfCards(){
        int counter=0;
        if (null==topCard)
            return 0;
        else
            counter=countCards(topCard);
        return counter;
    }
    //For counting cards
    public int countCards(Card card){
        if(card==null){
            return 0;
        }else{
            return 1+countCards(card.getNextCard());
        }
    }

    //Shuffling the deck based on the number provided at method call
    public void shuffler(int number){


        try{
            Card[] sideCards=this.takeCards(number);
            for (Card transitCard:this.takeCards(number)){
            transitCard.setNextCard(null);
            this.addCards((Card) transitCard.clone());
        }
            this.addCards(sideCards);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }


    }

}
