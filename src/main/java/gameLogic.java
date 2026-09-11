import java.util.ArrayList;
import java.util.HashMap;

public class gameLogic {
//    public final String[] COLOURS = {"Red", "Blue", "Yellow", "Green"};
    public final int[] NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public final String[] WILD_CARDS = {"wild", "+4"};
    public final String[] ACTION_CARDS = {"+2", "reverse", "block","skip"};
    public ArrayList<String> deck = new ArrayList<>();
    public ArrayList<String> discard_pile = new ArrayList<>();

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
        }

        return numberCards;
    }

}