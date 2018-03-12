package net.spacive.school.chatapp;

import net.spacive.school.chatapp.model.IClient;
import net.spacive.school.chatapp.model.SocketClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerApp {

    private static final int PORT_NUMBER = 8000;

    private Logger logger = Logger.getLogger(ServerApp.class.getName());

    public static void main(String[] args) {

        new ServerApp().runServer(PORT_NUMBER);
    }

    private void runServer(int portNumber) {
        logger.log(Level.INFO, "Starting server at port " + Integer.toString(portNumber));

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            List<IClient> clients = new ArrayList<>();

            while (true) {

                final IClient newClient = new SocketClient(
                        serverSocket.accept()
                );

                newClient.setMessageListener(message -> {
                    for (IClient client: clients) {
                        if (client.getId() != newClient.getId()) {
                            client.sendMessage(message);
                        }
                    }
                });

                clients.add(newClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}