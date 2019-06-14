package Design.Splitwise;

import java.util.ArrayList;

public class User {
    String userId;
    ArrayList<String> transactions;

    public User(String userId) {
        this.userId = userId;
        this.transactions = new ArrayList<>();
    }
}
