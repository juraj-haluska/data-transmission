package net.spacive.school.chatapp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient extends IClient {

    private IMessageListener messageListener = null;
    private PrintWriter clientOut = null;

    public SocketClient(Socket socket) throws IOException {
        super();
        clientOut = new PrintWriter(socket.getOutputStream(), true);

        final BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );

        new Thread(() -> {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (messageListener != null) {
                        messageListener.onMessageReceived(inputLine);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void sendMessage(String message) {
        if (clientOut != null) {
            clientOut.println(message);
        }
    }

    @Override
    public void setMessageListener(IMessageListener messageListener) {
        this.messageListener = messageListener;
    }
}
