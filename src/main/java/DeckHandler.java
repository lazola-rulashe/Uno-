import java.util.ArrayList;
import java.util.Collections;

public class DeckHandler {
    public final int[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public final String[] ACTION_CARDS = {"+2", "reverse","skip"};
    public ArrayList<String> deck = new ArrayList<>();

    public DeckHandler(){
    }

    public String getEachCard(String name, String colour){
        return name + ":" + colour;
    }

    public ArrayList<String> getNumberCards(){
        ArrayList<String> numberCards = new ArrayList<>();

        for (int num : NUMBERS) {
            numberCards.add(getEachCard(String.valueOf(num), "Red"));
            numberCards.add(getEachCard(String.valueOf(num), "Blue"));
            numberCards.add(getEachCard(String.valueOf(num), "Yellow"));
            numberCards.add(getEachCard(String.valueOf(num), "Green"));

            numberCards.add(getEachCard(String.valueOf(num), "Red"));
            numberCards.add(getEachCard(String.valueOf(num), "Blue"));
            numberCards.add(getEachCard(String.valueOf(num), "Yellow"));
            numberCards.add(getEachCard(String.valueOf(num), "Green"));

        }

        numberCards.add(getEachCard(String.valueOf(0), "Red"));
        numberCards.add(getEachCard(String.valueOf(0), "Blue"));
        numberCards.add(getEachCard(String.valueOf(0), "Yellow"));
        numberCards.add(getEachCard(String.valueOf(0), "Green"));

        return numberCards;
    }

    public ArrayList<String> getActionCards(){
        ArrayList<String> actionCards= new ArrayList<>();

        for (String action: ACTION_CARDS){
            actionCards.add(getEachCard(action, "Red"));
            actionCards.add(getEachCard(action, "Blue"));
            actionCards.add(getEachCard(action, "Yellow"));
            actionCards.add(getEachCard(action, "Green"));

            actionCards.add(getEachCard(action, "Red"));
            actionCards.add(getEachCard(action, "Blue"));
            actionCards.add(getEachCard(action, "Yellow"));
            actionCards.add(getEachCard(action, "Green"));

        }
        return actionCards;

    }

    public ArrayList<String> getWildCards(){
        ArrayList<String> wildCards = new ArrayList<>();

        wildCards.add("Wild");
        wildCards.add("+4 wild");
        wildCards.add("Wild");
        wildCards.add("+4 wild");
        wildCards.add("Wild");
        wildCards.add("+4 wild");
        wildCards.add("Wild");
        wildCards.add("+4 wild");

        return wildCards;
    }

    public ArrayList<String> getDeck(){
        this.deck.addAll(getNumberCards());
        this.deck.addAll(getActionCards());
        this.deck.addAll(getWildCards());

        Collections.shuffle(this.deck);

        return this.deck;
    }

    public int getNumOfCards(){
        return getDeck().toArray().length;
    }





}