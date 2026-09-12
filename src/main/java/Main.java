import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static ArrayList<String> discardPile = new ArrayList<>();


    public static void main(String[] args) throws ClassNotFoundException, IOException {

        System.out.println("Welcome to UNO!");
        DeckHandler deck = new DeckHandler();

        ArrayList<String> action = deck.getActionCards();
        ArrayList<String> wild = deck.getWildCards();
        ArrayList<String> Deck = deck.getDeck();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < Deck.toArray().length; i++){
            if(!(wild.contains(Deck.get(i)) || action.contains(Deck.get(i)))){
                str.append(Deck.get(i));
                discardPile.add(str.toString());
                Deck.remove(str.toString());
                break;
            }
        }

    }
}
