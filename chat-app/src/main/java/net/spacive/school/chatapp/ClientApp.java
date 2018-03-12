package net.spacive.school.chatapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientApp {

    private Logger logger = Logger.getLogger(ClientApp.class.getName());
    private static final int PORT_NUMBER = 8000;


    public static void main(String[] args) {

        new ClientApp().runClient(PORT_NUMBER);
    }

    private void runClient(int portNumber) {
        logger.log(Level.INFO, "Connecting client to port " + Integer.toString(portNumber));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        MessageReader reader;

        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host, portNumber);

            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader sockerReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            reader = new MessageReader(sockerReader, message -> System.out.println(message));
            new Thread(reader).start();

            // read user input
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                socketWriter.println(userInput);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
