package net.spacive.school.chatapp;

import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;

public class ClientHandler implements Runnable {

    private Logger logger = Logger.getLogger(ClientHandler.class.getName());

    private List<Socket> clients;
    private Socket clientSocket;

    public ClientHandler(List<Socket> clients, Socket clientSocket) {
        this.clients = clients;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "client connected");

        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    )
            );

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                for (Socket client: clients) {
                    if (client != clientSocket) {
                        PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true);
                        clientOut.println(inputLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
