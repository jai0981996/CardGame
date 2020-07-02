package org.jai;


import java.util.*;

public class StartGame {
    //Current Playing deck of the game
    private Deck playingDeck;

    public Deck getPlayingDeck() {
        return playingDeck;
    }

    public void setPlayingDeck(Deck playingDeck) {
        this.playingDeck = playingDeck;
    }

    //Initialising the game
    public StartGame() {
        playingDeck=new Deck();
        //adding all 4 suits into the list
        List<Suit> listSuits= Arrays.asList(new Suit("spades"),new Suit("diamonds")
                ,new Suit("clubs"),new Suit("hearts"));
        for (Suit suit:listSuits) {
            //adding all the suits in the playing deck
            playingDeck.addCards(suit.takeCards(suit.totalNumberOfCards()));
        }

        System.out.println(printStartGameText());
    }

    //For shuffling the current deck with intensity provide in the parameter
    public void shuffleDeck(int rigorousRate){
        int swapTimes=0;
        Random random=new Random();
        System.out.println("");
        System.out.print("Shuffling >>>");
        while(swapTimes<rigorousRate){

            this.getPlayingDeck().shuffler(random.nextInt(20));
            swapTimes++;
            System.out.print(">");
        }
        System.out.println("Done ! ");
    }

    //Start game console text
    public static String printStartGameText(){
        return  "\n\n#################################################\n" +
                "############## Welcome To The Game ############## \n" +
                "##############        "+'\u2660' +'\u2764' +'\u2663' +'\u2666' +"         ############## \n" +
                "#################################################\n" +
                new Card(14,"spades").toString()+"\n" +getGameInstructions();
    }

    //Contains the game instruction
    public static String getGameInstructions(){
        return "\nYour Can Add Player by 'player-name' e.g. player-jai \n" +
                "To take a round of cards from the deck provide input 'play'\n" +
                "For showing the current card that all players have provide input 'show'\n" +
                "For finding the winner of the game provide input 'winner'\n" +
                "For shuffling the deck provide input 'shuffle'\n" +
                "To END the game provide input 'finish'";
    }

}
