package Design.Splitwise;

import jdk.nashorn.internal.objects.NativeJSON;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    int transactionCounter = 0;
    TransactionDB transactionDB = new TransactionDB();
    UserDB userDB = new UserDB();

    void addTransaction(String paidBy, String[] userIds, int amount){

    }

    User findUser(String userId){
        for(User user: userDB.users){
            if(user.userId.equals(userId))
                return user;
        }

        return null;
    }

    Transaction findTransaction(String transactionId){
        for(Transaction transaction: transactionDB.transactions){
            if(transaction.transactionId.equals(transactionId))
                return transaction;
        }

        return null;
    }

    void addTransaction(String paidby, String[] userIds, int[] amounts){
        int totalSum = 0;
        for(int sum: amounts){
            totalSum += sum;
        }

        /*System.out.println("/////////adding to the database");
        for(int i=0;i<userIds.length;i++){
            System.out.print(userIds[i]+" : "+amounts[i]+" ");
        }
        System.out.println();*/

        String transactionId = "transaction"+transactionCounter;
        Transaction transaction = new Transaction(transactionId, paidby);
        if(userIds.length == amounts.length){
            for(int i=0;i<userIds.length;i++){
                if(userIds[i].equals(paidby)){
                    transaction.splitList.add(new Split(userIds[i], totalSum-amounts[i]));
                }else{
                    transaction.splitList.add(new Split(userIds[i], -amounts[i]));
                }

            }
        }
        transactionDB.transactions.add(transaction);

        for(String userId: userIds){
            User user = findUser(userId);
            user.transactions.add(transactionId);
        }

        transactionCounter++;
    }

    void viewSummary(String userId){
        HashMap<String, Integer> summary = new HashMap<>();
        int total = 0;
        User summaryViewer = findUser(userId);
        if(summaryViewer == null){
            System.out.println("couldn't find user : "+userId);
            return;
        }
        for(String transactionId: summaryViewer.transactions){
            Transaction transaction = findTransaction(transactionId);

            if(transaction.paidBy.equals(userId)){
                for(Split split: transaction.splitList){
                    if(!split.userId.equals(userId)){
                        if(summary.containsKey(split.userId)){
                            summary.put(split.userId, summary.get(split.userId)-split.amount);
                        }else{
                            summary.put(split.userId, -split.amount);
                        }
                    }else{
                        total += split.amount;
                    }
                }
            }else{
                for(Split split: transaction.splitList){
                    if(split.userId.equals(userId)){
                        if(summary.containsKey(transaction.paidBy)){
                            summary.put(transaction.paidBy, summary.get(transaction.paidBy)+split.amount);
                        }else{
                            summary.put(transaction.paidBy, split.amount);
                        }
                        total += split.amount;
                    }
                }
            }
        }

        System.out.println("summary of : "+userId+" - "+total);
        for(Map.Entry itr: summary.entrySet()){
            if(!itr.getKey().equals(userId))
                System.out.println(itr.getKey()+" "+itr.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.userDB.users.add(new User("abhay"));
        manager.userDB.users.add(new User("shas"));
        manager.userDB.users.add(new User("rishi"));

        String[] participants1 = {"abhay", "shas", "rishi"};
        int[] amounts1 = {60, 100, 100};
        manager.addTransaction("rishi", participants1, amounts1);
        manager.viewSummary("rishi");
        manager.viewSummary("abhay");
        manager.viewSummary("shas");

        int[] amounts2 = {100, 100, 100};
        manager.addTransaction("shas", participants1, amounts2);
        manager.viewSummary("rishi");
        manager.viewSummary("abhay");
        manager.viewSummary("shas");
    }
}
