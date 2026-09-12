import java.io.*;
import java.net.*;

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
        System.out.println("Waiting for clients...");
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
}