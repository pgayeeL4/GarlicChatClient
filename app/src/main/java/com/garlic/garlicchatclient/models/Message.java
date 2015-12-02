package com.garlic.garlicchatclient.models;

/**
 * Created by Pratik on 11/29/2015
 */
public class Message {

    public enum MessageType {TYPE_ACTION, TYPE_MESSAGE, TYPE_LOG}

    private int mType;
    private String mUsername;
    private String mMessage;

    public Message(MessageType type, String username, String message) {
        this.mType = messageTypeSelector(type);
        this.mUsername = username;
        this.mMessage = message;
    }

    public static Message messageLog(String message) {
        return new Message(MessageType.TYPE_LOG, null, message);
    }

    public static Message messageAction(String username) {
        return new Message(MessageType.TYPE_ACTION, username, null);
    }

    public int getType() {
        return mType;
    }

    public void setType(MessageType type) {
        this.mType = messageTypeSelector(type);
    }

    public String getUsername() {
        return mUsername;
    };

    public String getMessage() {
        return mMessage;
    };

    private int messageTypeSelector(MessageType t) {
        switch (t) {
            case TYPE_MESSAGE:
                return 0;
            case TYPE_LOG:
                return 1;
            case TYPE_ACTION:
                return 2;
            default:
                return 0;
        }
    }

    public static MessageType typeFromInt(int i) {
        switch (i) {
            case 0:
                return MessageType.TYPE_MESSAGE;
            case 1:
                return MessageType.TYPE_LOG;
            case 2:
                return MessageType.TYPE_ACTION;
            default:
                return MessageType.TYPE_MESSAGE;
        }
    }

}
