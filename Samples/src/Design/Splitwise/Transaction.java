package Design.Splitwise;

import java.util.ArrayList;

public class Transaction {
    String transactionId;
    String paidBy;
    ArrayList<Split> splitList;

    public Transaction(String transactionId, String paidBy) {
        this.transactionId = transactionId;
        splitList = new ArrayList<>();
        this.paidBy = paidBy;
    }
}
