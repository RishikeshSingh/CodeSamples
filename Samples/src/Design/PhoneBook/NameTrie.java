package Design.PhoneBook;

public class NameTrie extends Trie{
    private NameTrie[] array = new NameTrie[26];

    public NameTrie[] getArray() {
        return array;
    }

    public void addElement(int index){
        array[index] = new NameTrie();
    }

}
