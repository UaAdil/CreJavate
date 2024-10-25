package Modules.module8.practice7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Mediator {
    void sendMessage(String message, User user, String channel);
    void addUser(User user, String channel);
}

class ChatMediator implements Mediator {
    private Map<String, List<User>> channels = new HashMap<>();

    public void addUser(User user, String channel) {
        channels.putIfAbsent(channel, new ArrayList<>());
        channels.get(channel).add(user);
        System.out.println(user.getName() + " has joined channel: " + channel);
    }

    public void sendMessage(String message, User user, String channel) {
        if (channels.containsKey(channel)) {
            for (User u : channels.get(channel)) {
                if (u != user) {
                    u.receiveMessage(message);
                }
            }
        } else {
            System.out.println("Channel " + channel + " does not exist.");
        }
    }
}

// User interface
interface User {
    void sendMessage(String message, String channel);
    void receiveMessage(String message);
    String getName();
}

// Concrete User
class ChatUser implements User {
    private String name;
    private Mediator mediator;

    public ChatUser(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() { return name; }

    public void sendMessage(String message, String channel) {
        System.out.println(this.name + " sends: " + message + " to " + channel);
        mediator.sendMessage(message, this, channel);
    }

    public void receiveMessage(String message) {
        System.out.println(this.name + " received: " + message);
    }
}

public class ChatSystem {
    public static void main(String[] args) {
        Mediator mediator = new ChatMediator();

        User adil = new ChatUser(mediator, "Adil");
        User dimash = new ChatUser(mediator, "Dimash");
        User arlan = new ChatUser(mediator, "Arlan");

        mediator.addUser(adil, "General");
        mediator.addUser(dimash, "General");
        mediator.addUser(arlan, "General");

        adil.sendMessage("Hello guys!", "General");

        mediator.addUser(dimash, "Sports");
        dimash.sendMessage("Go team!", "Sports");
    }
}
