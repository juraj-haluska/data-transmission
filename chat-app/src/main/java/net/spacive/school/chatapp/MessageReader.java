package net.spacive.school.chatapp;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageReader implements Runnable {

    public interface MessageListener {
        void onMessageReceived(String message);
    }

    private BufferedReader socketReader;
    private MessageListener messageListener;

    public MessageReader(BufferedReader sockerReader, MessageListener messageListener) {
        this.socketReader = sockerReader;
        this.messageListener = messageListener;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = socketReader.readLine();
                if (messageListener != null) {
                    messageListener.onMessageReceived(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
