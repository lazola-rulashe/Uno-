import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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
}
