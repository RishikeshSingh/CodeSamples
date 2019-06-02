package Design.PhoneBook;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.addContact("Ratan","8990909090");
        app.addContact("chetan", "1234567891");
        app.addContact("cheetah", "8989898989");
        app.findContact("rat");
        //app.db.displayAllContacts();
    }

    DB db = new DB();
    NameTrie nameTrie = new NameTrie();
    NumberTrie numberTrie = new NumberTrie();

    void addInTrie(String name, String number){
        addInNumberTrieUtil(numberTrie, number, 0, number.length(), '0');
        addInNameTrieUtil(nameTrie, name, 0, name.length(), 'a');
    }

    void addInNumberTrieUtil(NumberTrie trie, String identifier, int curr, int len, char startCharacter){
        if(curr == len){
            trie.setEndOfWord(true);
            return;
        }

        if(trie.getArray()[identifier.charAt(curr)-startCharacter] == null){
            trie.getArray()[identifier.charAt(curr)-startCharacter] = new NumberTrie();
        }
        addInNumberTrieUtil(trie.getArray()[identifier.charAt(curr)-startCharacter], identifier,curr+1, len, startCharacter);
    }

    void addInNameTrieUtil(NameTrie trie, String identifier, int curr, int len, char startCharacter){

        if(curr == len){
            trie.setEndOfWord(true);
            return;
        }

        if(trie.getArray()[identifier.charAt(curr)-startCharacter] == null){
            trie.getArray()[identifier.charAt(curr)-startCharacter] = new NameTrie();
        }
        addInNameTrieUtil(trie.getArray()[identifier.charAt(curr)-startCharacter], identifier,curr+1, len, startCharacter);
    }

    void addContact(String name, String number){
        name = name.toLowerCase();
        number = number.toLowerCase();
        db.addContact(name, number);
        addInTrie(name, number);
    }

    void findContact(String token){
        if(token.length() == 0)
            System.out.println();

        token = token.toLowerCase();
        ArrayList<String> list = new ArrayList<>();
        if(token.matches("\\d+")){
            findInNumberTrie(numberTrie, token, 0, "", list);
            System.out.println("Contacts : ");
            for(String str: list){
                Contact contact = db.find(str);
                if(contact != null){
                    System.out.println(contact.getName()+" "+contact.getNumber());
                }
            }
        }else{
            findInNameTrie(nameTrie, token, 0, "", list);
            System.out.println("Contacts : ");
            for(String str: list){
                Contact contact = db.find(str);
                if(contact != null){
                    System.out.println(contact.getName()+" "+contact.getNumber());
                }
            }
        }
    }

    static void findInNumberTrie(NumberTrie numberTrie, String token, int counter, String number, ArrayList<String> numbers){
        if(numberTrie.isEndOfWord()){
            if(counter>=token.length()){
                numbers.add(number);
            }
            return;
        }

        if(counter<token.length()){
            findInNumberTrie(numberTrie.getArray()[token.charAt(counter)-'0'], token, counter+1, number+token.charAt(counter), numbers);
        }else{
            for(int i=0;i<numberTrie.getArray().length;i++){
                if(numberTrie.getArray()[i] != null){
                    findInNumberTrie(numberTrie.getArray()[i], token, counter+1, number+i, numbers);
                }
            }
        }
    }

    static void findInNameTrie(NameTrie nameTrie, String token, int counter, String number, ArrayList<String> numbers){
        if(nameTrie.isEndOfWord()){
            if(counter>=token.length()){
                numbers.add(number);
            }
            return;
        }

        if(counter<token.length()){
            number += token.charAt(counter);
            findInNameTrie(nameTrie.getArray()[token.charAt(counter)-'a'], token, counter+1, number, numbers);
        }else{
            for(int i=0;i<nameTrie.getArray().length;i++){
                if(nameTrie.getArray()[i] != null){
                    char ch = 'a';
                    ch += i;
                    findInNameTrie(nameTrie.getArray()[i], token, counter+1, number+ch, numbers);
                }
            }
        }
    }

    static void displayCompletetrie(NumberTrie trie, String str){
        if(trie != null){
            for(int i=0;i<10;i++){
                if(trie.getArray()[i] != null){
                    str += i;
                }
            }
        }
    }


}

