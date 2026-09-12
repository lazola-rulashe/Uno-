import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static ArrayList<String> player1Hand = new ArrayList<>();
    public static ArrayList<String> player2Hand = new ArrayList<>();
    public static ArrayList<String> discardPile = new ArrayList<>();


    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ServerSocket s = new ServerSocket( Server.PORT);
        System.out.println("Welcome to UNO!");
        while(true) {
            try {
                Socket socket = s.accept();
//                System.out.println("Connection: " + socket.getInetAddress().getCanonicalHostName());

                Runnable r = new Server(socket);
                Thread task = new Thread(r);
                task.start();


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



            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }



//        System.out.println(discardPile);
//        System.out.println(Deck);
//        System.out.println(player1Hand);
//        System.out.println(player2Hand);
//        System.out.println(Deck.size());





    }
}
