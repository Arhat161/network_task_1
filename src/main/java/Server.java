import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        int port = 8081;

        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("New connection accepted");

            String clientMessage = in.readLine();

            System.out.println("Client message: '" + clientMessage + "'");

            out.println(String.format("Your message: '%s', Your port: '%d'", clientMessage, clientSocket.getPort()));

        }
    }
}
