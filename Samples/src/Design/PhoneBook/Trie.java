package Design.PhoneBook;

public abstract class Trie {
    private boolean endOfWord = false;
    public int k;

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public abstract void addElement(int index);
}
