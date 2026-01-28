import java.net.*;
import java.io.*;
/**
* Exercise 4: Stream-mode socket using MyStreamSocket wrapper class
*/
public class Example4Sender {
   // An application that requests a connection and
   // receives a message using MyStreamSocket wrapper class.
   // Two command line arguments are expected:
   //
   // <host name of the connection accceptor>
   // <port number of the connection accceptor>
   public static void main(String[] args) {
      if (args.length != 2)
         System.out.println
            ("This program requires two command line arguments");
      else {
         try {
            String acceptorHost = args[0];
            int acceptorPort = Integer.parseInt(args[1]);
            
            // Use MyStreamSocket wrapper
            MyStreamSocket mySocket = new MyStreamSocket(acceptorHost, acceptorPort);
            System.out.println("Connection request granted to port: " + acceptorPort);
            
            System.out.println("waiting to read");
            // receive message using wrapper method
            String message = mySocket.receiveMessage( );
            System.out.println("Message received:");
            System.out.println("\t" + message);
            
            mySocket.close( );
            System.out.println("data socket closed");
         } // end try
         catch (Exception ex) {
            ex.printStackTrace( );
         } //end catch
      } // end else
   } // end main
} // end class
