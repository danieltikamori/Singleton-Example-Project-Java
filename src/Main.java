import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {

    // Private constructor to prevent external instantiation (Singleton pattern)
    private UserManager() {}

    private static UserManager instance;

    // Static method to get the single instance of singleton.UserManager (Singleton pattern)
    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private final List<User> users = new ArrayList<>();

    public void addUser(String name) {
        int nextId = users.isEmpty() ? 1 : users.get(users.size() - 1).getId() + 1;
        users.add(new User(nextId, name));
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("There are no registered users.");
            return;
        }
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of users to register:");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

        for (int i = 1; i <= quantity; i++) {
            System.out.println("Enter user " + i + " name:");
            String name = scanner.nextLine();
            UserManager.getInstance().addUser(name);
        }

//        System.out.println("\nRegistered Users:");
        UserManager.getInstance().listUsers();
    }
}
