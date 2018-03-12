package net.spacive.school.chatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {

        int portNumber = Integer.parseInt(args[0]);

        new Server().runServer(portNumber);
    }

    private void runServer(int portNumber) {
        logger.log(Level.INFO, "Starting server at port " + Integer.toString(portNumber));

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            List<Socket> clients = new ArrayList<>();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                new Thread(new ClientHandler(clients, clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}