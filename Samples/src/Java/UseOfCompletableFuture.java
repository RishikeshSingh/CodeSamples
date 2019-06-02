package Java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class UseOfCompletableFuture {
    public static void main(String[] args) {

        //runAsync();
        supplyAsync();

    }

    static void runAsync(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try{
                System.out.println("waiting...");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("completed task");

            }catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        });

        try{
            future.get();
        }catch (Exception e){

        }
    }

    static void supplyAsync(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try{
                    System.out.println("waiting...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("lgging done");
                }catch (Exception e){

                }

                return "data saved successfully";
            }
        });
        try{
            System.out.println("business logic");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("business logic done");
            System.out.println(future.get());
            System.out.println("logging acknowledgement");

        }catch (Exception e){

        }

    }
}
