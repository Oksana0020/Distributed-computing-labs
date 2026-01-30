import java.io.*;
import java.net.*;

public class JavaClientText {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 4444;

        try (
            Socket socket = new Socket(hostName, portNumber);
            OutputStream outStream = socket.getOutputStream();
            PrintWriter socketOutput = new PrintWriter(new OutputStreamWriter(outStream), true);
            InputStream inStream = socket.getInputStream();
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(inStream))
        ) {
            // Send a string to the server (plain text)
            String message = "hello, server";
            socketOutput.println(message);

            // Receive a string from the server
            message = socketInput.readLine();
            System.out.println("Received message from server: " + message);
        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
        }
    }
}
