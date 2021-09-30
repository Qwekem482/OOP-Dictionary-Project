import java.util.Scanner;
import java.io.IOException;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    /**
     * Insert word to dictionary from CMD.
     */

    public static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void insertFromCommandline() {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("Type 'ESC' to exit adding, 'CON' to continue adding: ");
            String isEsc = input.nextLine();
            clrscr();
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
