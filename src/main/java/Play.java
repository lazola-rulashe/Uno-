import java.util.ArrayList;

public class Play {

    public ArrayList<String> deal(){
        ArrayList<String> playerHand = new ArrayList<>();
        DeckHandler deck = new DeckHandler();

        ArrayList<String> Deck = deck.getDeck();

        for (int i = 0; i < Deck.size(); i++){
            playerHand.add(Deck.get(i));
            if(playerHand.size() == 8) {
                break;
            }
        }

        for(String card: playerHand){
            Deck.remove(card);
        }
        return playerHand;
    }



}
