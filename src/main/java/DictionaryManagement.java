import java.util.Scanner;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    /**
     * Insert word to dictionary from CMD.
     */
    public void insertFromCommandline() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("Type 'ESC' to exit adding, 'CON' to continue adding: ");
            String isEsc = input.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (isEsc.equals("ESC")) {
                break;
            } else if (isEsc.equals("CON")) {
                System.out.print("Word: ");
                w1.setWord_target(input.nextLine());
                System.out.print("Meaning: ");
                w1.setWord_explain(input.nextLine());
                dict.addWordToDict(w1);
            }
        }
    }

    /**
     * this function help us to show the array of word in the function DictBasic in the class DictCMD.
     */
    public void ShowWord(){
        dict.showDict();
    }
}
