package org.jai;

//Single card node
public class Card implements Cloneable{

    //Number that a card have
    private int number;

    //Type of card i.e spade,dimond .etc
    private int type;

    //Next card
    //end of the deck card will have null
    private Card nextCard;

    //Previous card
    //Front of the deck card will have null
    private Card previousCard;

    public Card getPreviousCard() {
        return previousCard;
    }

    public void setPreviousCard(Card previousCard) {
        this.previousCard = previousCard;
    }


    public Card(int number, String type) {
        this.number = number;
        this.setType(type);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(String type) {
        this.type = valueOfSymbol(type);
    }

    public Card getNextCard() {
        return nextCard;
    }

    public void setNextCard(Card nextCard) {
        this.nextCard = nextCard;
    }


    //For printing the graphical card
    @Override
    public String toString(){
        System.out.println("_______");
        System.out.println("|"+printValue(this.getNumber())+"    |");
        System.out.println("|  "+printSymbol(this.getType())+"  |");
        System.out.println("|    "+printValue(this.getNumber())+"|");
        System.out.println("|_____|");
        return "";
    }
    //printing the value of the card
    private String printValue(int number) {
        switch (number){
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
        }
        return String.valueOf(number);
    }
    //printing the symbol of the card
    private char printSymbol(int type) {
        switch (type) {
            case 4:
                return '\u2660';

            case 1:
                return '\u2666';

            case 2:
                return '\u2663';

            case 3:
                return '\u2764';

        }
        return '\u2764';
    }

    //converting the symbol provided to number for easy scoring
    private int valueOfSymbol(String type) {
        switch (type) {
            case "spades":
                return 4;

            case "diamonds":
                return 1;

            case "clubs":
                return 2;

            default:
                return 3;

        }
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
