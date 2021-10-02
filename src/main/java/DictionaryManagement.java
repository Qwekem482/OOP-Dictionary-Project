import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

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
    public void insertFromFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionaries.txt");
        File dataFile = new File(String.valueOf(dataDir));
        Scanner inputScan = new Scanner(dataFile);
        while (inputScan.hasNext()) {
            if (inputScan.hasNext()) {
                inputScan = inputScan.useDelimiter( "\\t" );
                w1.setWord_target(inputScan.next());
            }
            if (inputScan.hasNext()) {
                inputScan = inputScan.useDelimiter( "\\n" );
                w1.setWord_explain(inputScan.next());
            }
            dict.addWordToDict(w1);
        }
    }

    /**
     * this function help us to show the array of word in the function DictBasic in the class DictCMD.
     */
    public void ShowWord() throws FileNotFoundException {
        this.insertFromFile();
        dict.showDict();
    }

    /**
     * Look up word in dictionary function and UI.
     */
    public void dictionaryLookup() throws IOException {
        Scanner input;
        while (true) {
            input = new Scanner(System.in);
            System.out.print("Type 'ESC' to exit looking up, 'CON' to continue looking up: ");
            String isEsc = input.nextLine();
            clrscr();
            if (isEsc.equals("ESC")) {
                break;
            } else if (isEsc.equals("CON")) {
                insertFromFile();
                System.out.print("Word: ");
                String target = input.nextLine();
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
