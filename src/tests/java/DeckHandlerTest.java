import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void shouldReturnAllNumberCards(){

        //Total length of all number cards
        assertEquals(76, deck.getNumberCards().size());

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

    @Test
    public void shouldReturnAllActionCards(){

        //Tests length of all action cards
        assertEquals(24, deck.getActionCards().size());

        //Tests that all action cards are there for each colour
        int counts1 = 0;
        for(String action: deck.getActionCards()){
            if(action.contains("+2")){
                counts1++;
            }else if(action.contains("reverse")){
                counts1++;
            }else if(action.contains("skip")){
                counts1++;
            }
        }

        assertEquals(24, counts1);
    }

    @Test
    public void shouldReturnAllWildCards(){

        //Tests length of all the wild cards
        assertEquals(8, deck.getWildCards().size());

        //Tests the number "+4" wild cards there are
        int count4= 0;
        for(String wild4: deck.getWildCards()){
            if(wild4.contains("+4")){
                count4++;
            }
        }
        assertEquals(4, count4);

        //Tests the number of "wild" wild cards there are
        int countWild = 0;
        for(String wild: deck.getWildCards()){
            if(wild.contains("wild")){
                countWild++;
            }
        }

        assertEquals(4, countWild);


    }

    @Test
    public void shouldReturnLengthOfDeck(){
        //Resturns length of entire deck
        assertEquals(108, deck.getDeck().size());

    }



}
