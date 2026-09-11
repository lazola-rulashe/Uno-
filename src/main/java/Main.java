import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        gameLogic sum = new gameLogic();

//        System.out.println(sum.getNumOfCards());
        System.out.println(sum.getNumberCards().toArray().length);
        System.out.println(sum.getWildCards().toArray().length);
        System.out.println(sum.getActionCards().toArray().length);

        System.out.println(sum.getWildCards());
        System.out.println(sum.getActionCards());


    }
}
