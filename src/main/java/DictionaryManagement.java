import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    /**
     * Clear screen of CMD.
     */
    public static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    /**
     * Insert word to dictionary from CMD.
     */
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
     * Read data from file then add word to dict.
     * Word & meaning separate by tab.
     * @throws FileNotFoundException when cannot find file
     */
    public void  insertFromFile() throws FileNotFoundException {
        File currentDir = new File (".");
        File parentDir = currentDir.getParentFile();
        Scanner inputScan = new Scanner(new File(parentDir, "data//dictionaries.txt"));
        inputScan = inputScan.useDelimiter( "\\t" );
        while (inputScan.hasNext()) {
            w1.setWord_target(inputScan.next());
            w1.setWord_explain(inputScan.next());
            dict.addWordToDict(w1);
        }
    }

    /**
     * this function help us to show the array of word in the function DictBasic in the class DictCMD.
     */
    public void ShowWord(){
        dict.showDict();
    }

    /**
     * Look up word in dictionary function and UI.
     * @param target word need meaning
     */
    public void dictionaryLookup(String target) {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("Type 'ESC' to exit looking up, 'CON' to continue looking up: ");
            String isEsc = input.nextLine();
            clrscr();
            if (isEsc.equals("ESC")) {
                break;
            } else if (isEsc.equals("CON")) {
                System.out.print("Word: ");
                if (!dict.findWordInDict(target).equals
                        ("Can't find this word, please try again.")) {
                    System.out.println("Meaning: " + dict.findWordInDict(target));
                } else {
                    System.out.println(dict.findWordInDict(target));
                }
            }
        }

    }
}
