package Design.CoinCashbackService;

public class User {
    String id;
    int coins;
    Float savedMoney;

    public User(String id) {
        this.id = id;
        coins = 0;
        savedMoney = (float) 0;
    }
}
