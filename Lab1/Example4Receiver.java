import java.net.*;
import java.io.*;
/**
* Exercise 4: Stream-mode socket using MyStreamSocket wrapper class
*/
public class Example4Receiver {
   // An application that accepts a connection and receives a message
   // using MyStreamSocket wrapper class.
   // Two command line arguments are expected, in order:
   // <port number for the the Server socket used in this process>
   // <message, a string, to send>
   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
            int portNo = Integer.parseInt(args[0]);
            String message = args[1];
            // instantiates a socket for accepting connection
            ServerSocket connectionSocket = new ServerSocket(portNo);
            System.out.println("now ready accept a connection on port: " + portNo);
            // wait to accept a connection request, at which
            // time a data socket is created
            Socket dataSocket = connectionSocket.accept();
            System.out.println("connection accepted, new data socket on port: " +
               dataSocket.getLocalPort());
            
            // Use MyStreamSocket wrapper
            MyStreamSocket mySocket = new MyStreamSocket(dataSocket);
            
            // send message using wrapper method
            mySocket.sendMessage(message);
            System.out.println("message sent");
            
            mySocket.close( );
            System.out.println("data socket closed");
            connectionSocket.close( );
            System.out.println("connection socket closed");
         } // end try
         catch (Exception ex) {
            ex.printStackTrace( );
         } //end catch
      } // end else
   } // end main
} // end class
