package net.spacive.school.chatapp.model;

import java.util.UUID;

public abstract class IClient {

    private UUID uuid = null;

    public IClient() {
        uuid = UUID.randomUUID();
    }

    public UUID getId() {
        return uuid;
    }

    public abstract void sendMessage(String message);
    public abstract void setMessageListener(IMessageListener messageListener);
}
