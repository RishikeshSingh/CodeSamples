package Design.PhoneBook;

import java.util.ArrayList;

public class NumberTrie extends Trie{
    private NumberTrie[] array = new NumberTrie[10];

    public NumberTrie[] getArray() {
        return array;
    }

    public void addElement(int index){
        array[index] = new NumberTrie();
    }
}
