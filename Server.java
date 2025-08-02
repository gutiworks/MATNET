import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void start() throws IOException{
       
        int port = 5001;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started");
        System.out.println("Waiting for a connection ...");

        //Listen for a connection
        Socket socket = serverSocket.accept();
        System.out.println("Connection established");
    
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Thread to listen for messages from client
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("\nClient: " + msg);
                    System.out.print("You: ");
                }
            } catch (IOException e) {
                System.out.println("Connection closed by client.");
            }
        }).start();

        // Main thread sends messages
        String line;
        System.out.print("You: ");
        while ((line = console.readLine()) != null) {
            out.println(line);
            System.out.print("You: ");
        }

        socket.close();
        serverSocket.close();
    }
}