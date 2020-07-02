package org.jai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    //This Flag will handle the end game functionality
    private static Boolean gameOverFlag=false;
    //List for storing players
    private static List<Player> players=new ArrayList<>();
    //Starting the game by creating start game instance
    private static StartGame startGame=new StartGame();

    public static void main( String[] args )
    {
        System.out.println( "Game Started "+'\u2660'+" : " );
        //shuffling the initial deck with 300 rigorousness
        startGame.shuffleDeck(300);
        Scanner sc=new Scanner(System.in);
        //this loop will ensure the the game inputs
        while (!gameOverFlag) {
            sysInput(sc.next());
             }

    }

    //Handles the actions according to the game input
    private static void sysInput(String input) {
        if(input.split("-")[0].equals("player")){
           addPlayer(input);
        }else if(input.equals("winner")){
            findWinner();
        }else if(input.equals("finish")){
            finishGame();
        }else if(input.equals("play")){
            playRound();
        }else if (input.equals("show")){
            if(players.size()==0){
                System.out.println("No cards on the table");
                return;
            }
            for (Player player:players){
                System.out.println(player);
            }
        }else if(input.equals("show-deck")){
            startGame.getPlayingDeck().printDeck();
        }else if(input.equals("shuffle")){
            startGame.shuffleDeck(300);
        }else if(input.equals("total")){
            System.out.println(startGame.getPlayingDeck().totalNumberOfCards());
        }else {
            System.out.println("Please Enter Valid Input \n Game Instructions :\n"+startGame.getGameInstructions());
        }



    }

    //For adding the player
    private static void addPlayer(String input) {
        try {
            System.out.println("  ==>"+input.split("-")[1]+"<== is new Player");
            players.add(new Player(input.split("-")[1]));
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Please add player name in right format i.e player-name");
        }
    }

    //Ending the game by changing the value of the gameover flag
    private static void finishGame() {
        gameOverFlag=true;
        System.out.println("###############################***Game Over***######################################");
        return;
    }

    //Finding the winner of the game
    private static void findWinner() {
        try {
            Player winner=players.get(0);
            List<Player> winners=new ArrayList<>();
            for(Player player:players){
                System.out.println("Name : "+player.getName()+" | score : "+player.getScore());
                if (player.getScore() > winner.getScore()) {
                    winner = player;
                    winners.clear();
                    winners.add(player);
                }else if(player.getScore() == winner.getScore()){
                    winners.add(player);
                }
            }

            System.out.print("We have "+winners.size()+" Winner of this game : ");
            for (Player player:winners){
            System.out.print("  => "+player.getName()+" <=  ");
            }
            System.out.println();
        }catch (IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Add some players and play the game first");
        }

    }


    //One Round of the game
    private static void playRound() {
        if(players.size()<2){
            System.out.println("Add more player to start playing");
        return;
        }
        Card transitCard;
        try{for (Player player:players){
            transitCard=startGame.getPlayingDeck().takeCards(1)[0];
            transitCard.setNextCard(null);
            startGame.getPlayingDeck().addCards((Card) transitCard.clone());
            player.setCard(transitCard);
        }
        System.out.println("New Card distributed");
        scorelogic();
        }
        catch (NullPointerException | CloneNotSupportedException e){
            System.out.println("Deck is Empty");
        }
    }

    //Scoring based on the card value for particular round
    private static void scorelogic() {
        try {
            int maxCardValue=0;
            Player roundWinner = players.get(0);
            for(Player player:players){
                if(maxCardValue<=player.getCard().getNumber()){
                    if (roundWinner.getCard().getNumber() == player.getCard().getNumber()) {
                        roundWinner = checkTheType(player, roundWinner);
                        maxCardValue=roundWinner.getCard().getNumber();
                        continue;
                    }
                    roundWinner=player;
                    maxCardValue=player.getCard().getNumber();
                }
            }
            roundWinner.setScore(1);
        }catch (IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Add players");
        }
    }

    //If number of card is same than checking the type of the card
    private static Player checkTheType(Player player, Player winner) {
        return player.getCard().getType()>winner.getCard().getType()?player:winner;
    }

}
