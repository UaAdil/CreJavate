package Modules.module8.hometask7;

import java.util.ArrayList;
import java.util.List;

interface IMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

class ChatRoom implements IMediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(message);
            }
        }
    }
}

abstract class User {
    protected IMediator mediator;
    protected String name;

    public User(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

class ChatUser extends User {
    public ChatUser(IMediator mediator, String name) {
        super(mediator, name);
    }

    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

public class ChatTest {
    public static void main(String[] args) {
        IMediator chatRoom = new ChatRoom();

        User adil = new ChatUser(chatRoom, "Adil");
        User akim = new ChatUser(chatRoom, "Akim");
        User gercen = new ChatUser(chatRoom, "Gercen");

        chatRoom.addUser(adil);
        chatRoom.addUser(akim);
        chatRoom.addUser(gercen);

        gercen.send("Hello students! What's up");
    }
}
