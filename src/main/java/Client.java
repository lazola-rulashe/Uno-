import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) {
        try (
                Socket socket = new Socket("Lazz", 5000);
                PrintStream out = new PrintStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
        )
        {
            out.println("Lazz has joined the game :)");
            out.flush();
            String messageFromServer = in.readLine();
            System.out.println(messageFromServer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
