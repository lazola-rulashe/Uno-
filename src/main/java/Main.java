import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static ArrayList<String> discardPile = new ArrayList<>();
    public static ArrayList<String> player1Hand = new ArrayList<>();
    public static ArrayList<String> player2Hand = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        System.out.println("Welcome to UNO!");
        DeckHandler deck = new DeckHandler();

        ArrayList<String> action = deck.getActionCards();
        ArrayList<String> wild = deck.getWildCards();
        ArrayList<String> Deck = deck.getDeck();

        StringBuilder str = new StringBuilder();


        //The gets us the starter card
        for (int i = 0; i < Deck.toArray().length; i++){
            if(!(wild.contains(Deck.get(i)) || action.contains(Deck.get(i)))){
                str.append(Deck.get(i));
                discardPile.add(str.toString());
                Deck.remove(str.toString());
                break;
            }
        }

        System.out.println("Starter Card: " + discardPile);

        Play play = new Play();
//        ArrayList<String> player1Deal = play.deal();
//        ArrayList<String> player2Deal = play.deal();
//        System.out.println("Cards have been dealt!");
//        System.out.println(player1Deal);
//        System.out.println(player2Deal);
//        System.out.println(deck.getDeck().size());
        System.out.println(play.deal());
        System.out.println(deck.getDeck().size());


    }
}
