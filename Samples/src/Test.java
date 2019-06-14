import java.util.Comparator;
import java.util.PriorityQueue;

class Sample{
    String name;
    int age;
    int roll;

    public Sample(String name, int age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }
}
public class Test {


    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        q.add(5);
        q.add(3);
        q.add(7);
        q.add(1);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

        System.out.println(System.getProperty("sun.arch.data.model"));
    }



}
