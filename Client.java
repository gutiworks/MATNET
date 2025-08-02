import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public static void start() throws IOException{
        String host = "localhost";
        int port = 5000;

        Socket socket = new Socket(host, port);
        System.out.print("Connected to the server");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        //Listen messages
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("\nServer: " + msg);
                    System.out.println("You: ");
                }       
            } catch (Exception e) {
                System.out.println("Connection closed by the server");
            }
        } 
        ).start();

        //Main thread sends messages
        String line;
        System.out.println("You: ");
        while ((line = console.readLine()) != null) {
            out.println(line);
            System.out.print("You: ");
        }

        socket.close();
    }
}
