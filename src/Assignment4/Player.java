package Assignment4;

import java.util.LinkedList;

/**
 * Player class
 * Assignment 4
 * CP2561 Winter 2022
 * @author Quynh
 */
public class Player {
    private String name;
    private LinkedList<Card> hand;

    /**
     * Constructor creates a player object with a name and a hand
     * @param name (string) player first name
     * @param hand (linkedlist) represents card objects assigned to the player
     */
    public Player(String name, LinkedList<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    /**
     * Method that gets first name of player
     * @return first name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets first name of player
     * @param name first name to set to player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that gets hand of player
     * @return a linkedlist represents card objects assigned to the player
     */
    public LinkedList<Card> getHand() {
        return hand;
    }

    /**
     * Method that print the first card in player hand
     */
    public void printHand(){
        System.out.println(this.hand.getFirst());
    }
}
