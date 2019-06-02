package Design.CoinCashbackService;

public class CoinChangeManager {

    UserDB userDB = new UserDB();
    ServiceProviderDB spDB = new ServiceProviderDB();

    void doTransaction(String userId, ServiceProviderNames serviceProviderName, Float transactionAmount){
        User user = getUserInfo(userId);
        if(user == null){
            System.out.println("couldn't find user");
            return;
        }
        int prevCoins = user.coins;
        ServiceProvider serviceProvider = getServiceProviderInfo(serviceProviderName);
        if(serviceProvider == null){
            System.out.println("couldn't find service provider");
            return;
        }

        int maxRedemableCoins = Math.min(serviceProvider.maxRedeemableCoins, (int) (transactionAmount/serviceProvider.redemptionValue));

        int coinsUsed = Math.min(prevCoins, maxRedemableCoins);
        //int coinsUsed = 0;
        Float amountSaved = (float) 0;

        prevCoins = prevCoins-coinsUsed;


        amountSaved = (float)serviceProvider.redemptionValue*coinsUsed;
        Float finalPrice = transactionAmount - amountSaved;

        int coinsReceived = 0;
        int coins = (int) (float)finalPrice/serviceProvider.costPerCoin;
        if(coins > serviceProvider.maxAwardableCoins){
            coinsReceived = serviceProvider.maxAwardableCoins;
        }else{
            coinsReceived = coins;
        }

        updateUserDB(userId, prevCoins+coinsReceived, user.savedMoney+amountSaved);

        //System.out.println("details : "+prevCoins+coinsReceived+" "+ user.savedMoney+amountSaved);

        System.out.println("awarded coins : "+coinsReceived+" redeemed coins : "+ coinsUsed+" coins in account : "+ (prevCoins)+" amount savedTillNow : "+ (user.savedMoney));

    }

    void updateUserDB(String userId, int coins, Float amount){
        for(User user: userDB.userList){
            if(userId.equals(user.id)){
                user.savedMoney = amount;
                user.coins = coins;
            }
        }
    }

    ServiceProvider getServiceProviderInfo(ServiceProviderNames serviceProviderName){
        ServiceProvider serviceProvider;
        if(spDB.serviceProviderMap.containsKey(serviceProviderName)){
            serviceProvider = spDB.serviceProviderMap.get(serviceProviderName);
            return serviceProvider;
        }

        return null;
    }

    User getUserInfo(String userId){
        for (User user: userDB.userList){
            if(userId.equals(user.id)){
                return user;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        CoinChangeManager coinChangeManager = new CoinChangeManager();

        //making db
        coinChangeManager.userDB.userList.add(new User("alpha"));
        coinChangeManager.userDB.userList.add(new User("beta"));
        coinChangeManager.spDB.serviceProviderMap.put(ServiceProviderNames.s1, new ServiceProvider(ServiceProviderNames.s1, 250, 5, 150, 10));
        coinChangeManager.spDB.serviceProviderMap.put(ServiceProviderNames.s2, new ServiceProvider(ServiceProviderNames.s1, 100, 10, 100, 5));


        //test cases:
        coinChangeManager.doTransaction("alpha", ServiceProviderNames.s1, (float)1250);
        coinChangeManager.doTransaction("beta", ServiceProviderNames.s1, (float)500);
        coinChangeManager.doTransaction("alpha", ServiceProviderNames.s2, (float)2000);

        coinChangeManager.doTransaction("alpha", ServiceProviderNames.s1, (float) 2000);
        coinChangeManager.doTransaction("alpha", ServiceProviderNames.s1, (float) 250);

        //not available cases
        coinChangeManager.doTransaction("unknown", ServiceProviderNames.s1, (float)1250);
        coinChangeManager.doTransaction("alpha", ServiceProviderNames.s3, (float)1250);

    }
}
