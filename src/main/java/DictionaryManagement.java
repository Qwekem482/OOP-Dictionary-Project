import java.util.Scanner;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    private void insertWord(Scanner input) {
        w1.setWord_target(input.nextLine());
        w1.setWord_explain(input.nextLine());
        dict.addWordToMap(w1); //Need to rewrite after has trie dictionary
    }

    public void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            insertWord(input);
        }
        insertWord(input);
    }

}
