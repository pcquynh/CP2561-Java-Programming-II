package Assignment4;

import java.util.*;

/**
 * OneHundreds class
 * Assignment 4
 * CP2561 Winter 2022
 * @author Quynh
 */
public class OneHundreds {
    public static void main(String[] args) {
        // Ask the user for the number of players (a range of 2-4)
        System.out.println("How many players (2-4): ");
        Scanner sc = new Scanner(System.in);
        int numberOfPlayers = sc.nextInt();

        List<Player> playerList = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        // Create a new player object for each of the players, using a name that is input from the terminal.
        // The “hand” can be an empty LinkedList at this point.
        for (int i = 0; i < numberOfPlayers ; i++) {
            System.out.println("Enter player name: ");
            String name = sc.next();
            Player player = new Player(name,new LinkedList<Card>());
            playerList.add(player);
            // A “score” HashMap should be created, with player name as the “key” and a mapped
            // integer that represents wins. Wins can be zero initially.
            scoreMap.put(name, 0);
        }
        // Generate a new deck for the game
        CardDeck cardDeck = new CardDeck();
        ArrayList<Card> deck = cardDeck.generateDeck();
        // Shuffle the deck
        cardDeck.shuffleDeck(deck);
        // “Deal” cards to each player.
        dealCard(deck, playerList);

        // Get the number of card in one hand
        int totalCardInHand = playerList.get(0).getHand().size();
        for (int i = 0; i < totalCardInHand ; i++) {
            // each player lays their first card
            displayPlayersFirstCard(playerList);
            // Update score
            updateWinnerScore(playerList, scoreMap);
            // Discard cards from each round from the hand
            discardCardFromHand(playerList);
        }

        // Display remaining cards
        int cardsRemaining = cardDeck.cardsRemaining(deck);
        System.out.printf("There is %d cards remaining in the deck at the end of game.\n", cardsRemaining);
        cardDeck.printDeck(deck, System.out);
        // Display the final score and final winner(s)
        System.out.println("The final scores are: ");
        System.out.println(scoreMap);
        int finalMaxScore = getFinalMaxScore(scoreMap);
        List<String> finalWinners = getFinalWinner(scoreMap, finalMaxScore);
        printFinalResult(finalMaxScore, finalWinners);
    }

    /**
     * Method that deal card for each player
     * @param deck an arraylist of cards represents deck
     * @param playerList list of player
     */
    public static void dealCard(ArrayList<Card> deck, List<Player> playerList){
        while (deck.size() >= playerList.size()){
            for (int i = 0; i < playerList.size(); i++) {
                playerList.get(i).getHand().add(deck.get(0));
                deck.remove(0);
            }
        }
    }

    /**
     * Method that discard cards from the hand when played
     * @param playerList list of players
     */
    private static void discardCardFromHand(List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).getHand().removeFirst();
        }
    }

    /**
     * Method that displays first card of players in player list
     * @param playerList list of players
     */
    private static void displayPlayersFirstCard(List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).printHand();
        }
    }
    
    /**
     * Method that define winner player for each round
     * @param playerList a list of players
     * @return the winner player
     */
    public static Player winnerPlayer(List<Player> playerList){
        Player winnerPlayer = playerList.get(0);
        for (int i = 1; i < playerList.size(); i++) {
            Card winnerCard = winnerPlayer.getHand().getFirst();
            Card playerCard = playerList.get(i).getHand().getFirst();
            if(!winnerCard.compareTo(playerCard))
                winnerPlayer = playerList.get(i);
        }
        return winnerPlayer;
    }


    /**
     * Method that update the winner score
     * @param playerList list of player
     * @param scoreMap score of players
     */
    private static void updateWinnerScore(List<Player> playerList, Map<String, Integer> scoreMap) {
        Player winnerPlayer = winnerPlayer(playerList);
        System.out.printf("Winner of this game is %s.\n\n", winnerPlayer.getName());
        Integer winnerScore = scoreMap.get(winnerPlayer.getName());
        winnerScore = winnerScore + 1;
        scoreMap.put(winnerPlayer.getName(), winnerScore);
    }


    /**
     * Method that get final max score
     * @param scoreMap a score hashmap
     * @return the max score
     */
    public static Integer getFinalMaxScore(Map<String, Integer> scoreMap){
        Set<String> playersName = scoreMap.keySet();
        int finalMaxScore = 0;
        for (String playerName: playersName
             ) {
            if(scoreMap.get(playerName) > finalMaxScore){
                finalMaxScore = scoreMap.get(playerName);
            };
        }
        return finalMaxScore;
    }

    /**
     * Method that get final winner
     * @param scoreMap a score hashmap
     * @param finalMaxScore final max score
     * @return a list of final winner
     */
    public static List<String> getFinalWinner(Map<String, Integer> scoreMap, int finalMaxScore){
        List<String> finalWinners = new ArrayList<>();
        Set<String> playersName = scoreMap.keySet();
        for (String playerName: playersName
        ) {
            if(scoreMap.get(playerName) == finalMaxScore){
                finalWinners.add(playerName);
            }
        }
        return finalWinners;
    }

    /**
     * Methods that print the final winner(s)
     * @param finalMaxScore the final max score
     * @param finalWinners the name of final winner(s)
     */
    private static void printFinalResult(int finalMaxScore, List<String> finalWinners) {
        String statement = "The final winner(s) is/are: ";
        for (int i = 0; i < finalWinners.size() ; i++) {
            if(i == finalWinners.size() -1){
                statement += finalWinners.get(i) + " with score of " + finalMaxScore;
            }else {
                statement += finalWinners.get(i) + " and ";
            }
        }
        System.out.println(statement);
    }
}
