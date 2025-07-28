import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Welcome to \n");

        System.out.println(" __  __    _   _____ _    _ _____ _____  ");
        System.out.println("|  \\/  |  / \\\\|_   _| \\\\ | | ____|_   _|");
        System.out.println("| |\\/| | / _ \\\\ | | |  \\\\| |  _|   | |  ");
        System.out.println("| |  | |/ ___ \\\\| | | |\\\\  | |___  | |  ");
        System.out.println("|_|  |_/_/   \\\\_\\_| |_| \\\\_|_____| |_|  ");
        System.out.println("                                      ");

        System.out.println("\n");
        
        System.out.println("Select mode: (1) Server  (2) Client");
        int choice = scanner.nextInt();

        if (choice == 1) {
            //ChatServer.start();
        } else {
            //ChatClient.start();
        }
    }
}