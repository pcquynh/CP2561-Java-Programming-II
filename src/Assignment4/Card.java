package Assignment4;


/**
 * Card class
 * Assignment 4
 * CP2561 Winter 2022
 * @author Quynh
 */
public class Card {
    private final int value;
    private boolean wildcard;

    /**
     * Constructor creates a card object with a value and specified if it is a wild card
     * @param value (integer) the value of the card
     * @param wildcard (boolean) the wildcard status is true or false
     */
    public Card(int value, boolean wildcard) {
        this.value = value;
        this.wildcard = wildcard;
    }

    /**
     * Get the value of this card
     * @return (integer) value of this card
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the wildcard status
     * @return wildcard status
     */
    public boolean isWildcard() {
        return wildcard;
    }

    /**
     * Set the wildcard status
     * @param wildcard (boolean) wildcard status
     */
    public void setWildcard(boolean wildcard) {
        this.wildcard = wildcard;
    }

    /**
     * Method that compares two cards – consider both the value and the wildcard status.
     * @param card card object to compare
     * @return true if this card beats other card object, else return false
     */
    public Boolean compareTo(Card card){
        //TODO: use integer.compare function
        if (this.wildcard && card.wildcard){
            return this.value < card.value;
        }else if(this.wildcard){
            return true;
        }else if(card.wildcard){
            return false;
        }else{
            return this.value > card.value;
        }
    }


    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", wildcard=" + wildcard +
                '}';
    }
}
