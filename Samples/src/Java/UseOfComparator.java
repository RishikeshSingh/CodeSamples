package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Shoe{
    String name;
    int size;
    int height;

    public Shoe(String name, int size, int height) {
        this.name = name;
        this.size = size;
        this.height = height;
    }
}

// comparators can be used to sort list and use tree map
// TreeMap<String, Double> tm = new TreeMap<>(new TreeCompare()); where tree class has implemented Comparator
//SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));
public class UseOfComparator implements Comparator{
    public static void main(String[] args) {

        //2nd method by using anonymous class object
        Comparator<Shoe> cmp = new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                if(o1.size>o2.size){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        //3rd method with lambda
        Comparator<Shoe> cmp1 = (o1, o2)->o1.height-o2.height;

        ArrayList<Shoe> listOfShoes = new ArrayList<>();
        listOfShoes.add(new Shoe("lunar",8,3));
        listOfShoes.add(new Shoe("bounce", 9, 2));
        listOfShoes.add(new Shoe("wanderer", 5, 3));

        Collections.sort(listOfShoes, cmp);

        //4th method
        /*Collections.sort(listOfShoes, new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                return 0;
            }
        });*/

        for(Shoe shoe: listOfShoes){
            System.out.println(shoe.name+" "+shoe.size);
        }
    }

    //first method
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
