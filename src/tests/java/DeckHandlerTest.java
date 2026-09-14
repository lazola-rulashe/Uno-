import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class DeckHandlerTest {

    DeckHandler deck = new DeckHandler();
    String[] ACTION_CARDS = {"+2", "reverse","skip"};
    String[] COLOURS = {"Red", "Blue", "Green", "Yellow"};
    String[] WILD_CARDS = {"+4 wild", "wild"};


    @Test
    public void shouldReturnTheFormatOfEachCardInTheDeck(){

        String numberCard = deck.getEachCard("4", "Red");
        String actionCard = deck.getEachCard("reverse", "Blue");

        assertEquals("4:Red", numberCard);
        assertEquals("reverse:Blue", actionCard);
        assertNotEquals(4+":red", numberCard);
        assertNotEquals("Reverse:red", actionCard);

    }

    @Test
    public void shouldReturnListOfNumberCards(){

        //Total length of all number cards
        assertEquals(76, deck.getNumberCards().toArray().length);

        //Tests the number of zeros there are
        int count = 0;
        for(String num: deck.getNumberCards()){
            if(num.contains("0")){
                count++;
            }
        }
        assertEquals(4, count);
        assertFalse(count < 4);
        assertFalse(count > 4);

        //Tests that there are two cards per colour from 1-9
        int counts = 0;

        for(String num: deck.getNumberCards()){
            if(num.contains("1")){
                counts++;
            }
            if(num.contains("2")){
                counts++;
            }if(num.contains("3")){
                counts++;
            }if(num.contains("4")){
                counts++;
            }if(num.contains("5")){
                counts++;
            }if(num.contains("6")){
                counts++;
            }if(num.contains("7")){
                counts++;
            }if(num.contains("8")){
                counts++;
            }if(num.contains("9")){
                counts++;
            }
        }
        assertEquals(72, counts);

    }
}
