import java.io.*;
import java.net.*;

public class JavaClientObject {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 4444;

        try (
            Socket socket = new Socket(hostName, portNumber);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            // Send a string to the server using Java serialization
            String message = "hello, server";
            out.writeObject(message);

            // Receive a string from the server
            String str = (String) in.readObject();
            System.out.println("Received message from server: " + str);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}
