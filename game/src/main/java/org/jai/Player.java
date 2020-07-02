package org.jai;

public class Player {
    //Nmae of the player
    private String name;
    //Total score of the player
    private int score;
    //Current card player have
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    Player(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score =this.score+ score;
    }

    @Override
    public String toString() {
        System.out.println("Name='" + name + '\'' +
                ", Score=" + score +
                ", Card=");
        System.out.println(card);
        return "";
    }
}
