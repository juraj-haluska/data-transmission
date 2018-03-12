package net.spacive.school.chatapp.model;

import org.java_websocket.WebSocket;

public class WebSocketClient extends IClient {

    private WebSocket webSocket;
    private IMessageListener messageListener = null;

    public WebSocketClient(WebSocket socket) {
        super();
        this.webSocket = socket;
    }

    @Override
    public void sendMessage(String message) {
        if (webSocket != null) {
            webSocket.send(message);
        }
    }

    @Override
    public void setMessageListener(IMessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Override
    public IMessageListener getMessageListnerer() {
        return messageListener;
    }
}
