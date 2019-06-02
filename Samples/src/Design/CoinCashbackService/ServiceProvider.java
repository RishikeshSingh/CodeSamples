package Design.CoinCashbackService;

public class ServiceProvider {

    ServiceProviderNames name;
    int costPerCoin;
    int maxAwardableCoins;
    int redemptionValue;
    int maxRedeemableCoins;

    public ServiceProvider(ServiceProviderNames name, int costPerCoin, int maxAwardableCoins, int redemptionValue, int maxRedeemableCoins) {
        this.name = name;
        this.costPerCoin = costPerCoin;
        this.maxAwardableCoins = maxAwardableCoins;
        this.redemptionValue = redemptionValue;
        this.maxRedeemableCoins = maxRedeemableCoins;
    }
}
