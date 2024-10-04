package Modules.module3.practice2;

import java.util.ArrayList;
import java.util.List;
class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', role='" + role + "'}";
    }
}

class UserManager {
    private List<User> users;
    public UserManager() {
        users = new ArrayList<>();
    }
    public void addUser(String name, String email, String role) {
        User newUser = new User(name, email, role);
        users.add(newUser);
        System.out.println("User added: " + newUser);
    }
    public void removeUser(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
        System.out.println("User with email " + email + " removed.");
    }
    public void updateUser(String email, String newName, String newRole) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                user.setName(newName);
                user.setRole(newRole);
                System.out.println("User updated: " + user);
                return;
            }
        }
        System.out.println("User with email " + email + " not found.");
    }
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.addUser("Adil Khan", "adilkhan@gmail.com", "Admin");
        userManager.addUser("Spider Man", "spiderman@gmail.com", "User");

        System.out.println("\nList of users:");
        userManager.listUsers();

        System.out.println("\nUpdating user:");
        userManager.updateUser("spiderman@gmail.com", "Spidy", "Admin");

        System.out.println("\nRemoving user:");
        userManager.removeUser("adilkhan@gmail.com");

        System.out.println("\nList of users after removal:");
        userManager.listUsers();
    }
}
