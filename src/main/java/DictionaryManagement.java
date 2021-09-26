import java.util.Scanner;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    /**
     * Core of Insert word to dictionary from both CMD and .TXT functions
     * @param input: input stream which have word's data
     */
    private void insertWord(Scanner input) {
        w1.setWord_target(input.nextLine());
        w1.setWord_explain(input.nextLine());
        dict.addWordToMap(w1); //Need to rewrite after has trie dictionary
    }

    /**
     * Insert word to dictionary from CMD
     */
    public void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            insertWord(input);
        }
        insertWord(input);
    }

}
