package net.spacive.school.chatapp;

import net.spacive.school.chatapp.model.IClient;
import net.spacive.school.chatapp.model.SocketClient;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerApp {

    private static final int PORT_NUMBER = 8000;
    private static final int PORT_NUMBER_WEB = 8887;

    private Logger logger = Logger.getLogger(ServerApp.class.getName());

    public static void main(String[] args) {

        new ServerApp().runServer();
    }

    private void runServer() {

        List<IClient> clients = new ArrayList<>();

        new Thread(() -> {
            socketListener(clients);
        }).start();

        new Thread(() -> {
            webSocketListener(clients);
        }).start();

    }

    private void socketListener(List<IClient> clients) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            logger.log(Level.INFO, "Starting server at port " + Integer.toString(PORT_NUMBER));

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

    private void webSocketListener(List<IClient> clients) {

        String host = "localhost";

        WebSocketServer server = new SimpleWebSocketServer(
                new InetSocketAddress(host, PORT_NUMBER_WEB),
                clients
        );
        server.run();
    }
}