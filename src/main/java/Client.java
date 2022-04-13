import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8081;

        String message = "Serg";

        try (Socket clientSocket = new Socket(host, port)) {

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("now connected to " + clientSocket.getRemoteSocketAddress());

            // --- TO SERVER ---
            out.println(message);

            // --- FROM SERVER ---
            String resp = in.readLine(); // read server response
            System.out.println("Server response: " + resp); // show server response


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

