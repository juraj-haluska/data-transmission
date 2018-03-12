package net.spacive.school.chatapp;

import net.spacive.school.chatapp.model.IClient;
import net.spacive.school.chatapp.model.WebSocketClient;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public class SimpleWebSocketServer extends WebSocketServer {

    private HashMap<InetSocketAddress, IClient> connections = new HashMap<>();
    private List<IClient> clients;

    public SimpleWebSocketServer(InetSocketAddress address, List<IClient> clients) {
        super(address);
        this.clients = clients;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        IClient client = new WebSocketClient(conn);
        connections.put(conn.getRemoteSocketAddress(), client);
        client.setMessageListener(message -> {
            for (IClient c: clients) {
                if (c.getId() != client.getId()) {
                    c.sendMessage(message);
                }
            }
        });
        clients.add(client);
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        connections.get(conn.getRemoteSocketAddress()).getMessageListnerer().onMessageReceived(message);
    }

    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        System.out.println("received ByteBuffer from "	+ conn.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.err.println("an error occured on connection " + conn.getRemoteSocketAddress()  + ":" + ex);
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }
}
