import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server implements Runnable {

    public static final int PORT = 5000;
    private final BufferedReader in;
    private final PrintStream out;
    private final String clientMachine;

    public Server(Socket socket) throws IOException {
        clientMachine = socket.getInetAddress().getHostName();
//        System.out.println("Connection from " + clientMachine);

        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        System.out.println("Waiting for players to enter the game...");
    }

    public void run() {
        try {
            String messageFromClient;
            while((messageFromClient = in.readLine()) != null) {
                System.out.println(messageFromClient);
                out.println("You have successfully entered the game!"); // messages going to client**
            }
        } catch(IOException ex) {
            System.out.println("Shutting down single client server...");
        } finally {
            closeQuietly();
        }
    }

    private void closeQuietly() {
        try { in.close(); out.close();
        } catch(IOException ex) {}
    }

    public String deal(ArrayList<String> player1Hand, ArrayList<String> player2Hand){
        DeckHandler deck = new DeckHandler();

        ArrayList<String> Deck = deck.getDeck();

        for (int i = 0; i < Deck.toArray().length; i++){
            player1Hand.add(Deck.get(i));
            Deck.remove(Deck.get(i));
            if(player1Hand.size() == 8) {
                break;
            }
        }

        for (int z = 0; z < Deck.toArray().length; z++){
            player2Hand.add(Deck.get(z));
            Deck.remove(Deck.get(z));
            if(player2Hand.size() == 8) {
                break;
            }
        }

        return "Cards have been dealt to each player!";
    }

}