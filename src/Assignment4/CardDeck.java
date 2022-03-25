package Assignment4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * CardDeck class
 * Assignment 4
 * CP2561 Winter 2022
 * @author Quynh
 */
public class CardDeck {

    /**
     * Method that create 100 card objects, assign 4 cards at random to receive “wildcard” status,
     * the rest will be “normal” cards
     * @return an ArrayList of card objects,
     */
    public ArrayList<Card> generateDeck(){
        ArrayList<Card> cardDeck = new ArrayList<>();
        Random random = new Random();
        // Create 100 card objects
        for (int i = 1; i <= 100; i++) {
            Card newCard = new Card(i, false);
            cardDeck.add(newCard);
        }
        // Assign 4 cards at random to receive “wildcard” status
        ArrayList<Integer> indexWildCards = getRandomNonRepeatingIntegers(4,1,100);
        for (int i = 0; i< indexWildCards.size() ; i++) {
            int index = indexWildCards.get(i);
            cardDeck.get(index).setWildcard(true);
        }
        return cardDeck;
    }

    /**
     * Methods that get non-repeated random numbers and put them into an arraylist
     * @param size size of arraylist
     * @param min minimum number
     * @param max maximum number
     * @return an arraylist contains size random numbers between min and max number
     */
    public ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                          int max) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < size) {
            //Get Random numbers between range
            int randomNumber = random.nextInt(min, max+1);
            //Check for duplicate values
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    /**
     * Method that takes shuffles the deck by randomizing the order in the list
     * @param deck an ArrayList of card objects
     */
    public void shuffleDeck(ArrayList<Card> deck){
        Collections.shuffle(deck);
    }

    /**
     * Method that prints a representation of the Deck to the print stream.
     * @param deck a deck
     * @param printStream a print stream
     */
    public void printDeck(ArrayList<Card> deck, PrintStream printStream){
        for (int i = 0; i < deck.size() ; i++) {
            printStream.println(deck.get(i));
        }
    }

    /**
     * Method that returns the number of cards left in the deck
     * @param deck ArrayList parameter representing a deck
     * @return the number of cards left in the deck
     */
    public int cardsRemaining(ArrayList<Card> deck){
        return deck.size();
    }
}
