import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;

public class DictionaryManagement {
    private Word w1 = new Word();
    private Dictionary dict = new Dictionary();

    /**
     * Clear screen of CMD.
     */
    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
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
     *
     * @throws FileNotFoundException when cannot find file
     */
    public void insertFromFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionaries.txt");
        File dataFile = new File(String.valueOf(dataDir));
        Scanner inputScan = new Scanner(dataFile);
        while (inputScan.hasNext()) {
            if (inputScan.hasNext()) {
                inputScan = inputScan.useDelimiter("\\t");
                w1.setWord_target(inputScan.next());
            }
            if (inputScan.hasNext()) {
                inputScan = inputScan.useDelimiter("\\n");
                w1.setWord_explain(inputScan.next());
            }
            dict.addWordToDict(w1);
        }
    }

    /**
     * this function help us to show the array of word in the function DictBasic in the class DictCMD.
     */
    public void ShowWord() {
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

    /**
     * Modify a word
     */
    public void modifyWord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select: ");
        System.out.println("1. Modify English word");
        System.out.println("2. Modify Vietnamese meaning");
        System.out.print("Your choice: ");
        String choice = input.nextLine();
        clrscr();
        switch (choice) {
            case "1":
                System.out.print("The word you want to modify: ");
                w1.setWord_target(input.nextLine());
                System.out.print("Modify to: ");
                w1.setWord_explain(input.nextLine());
                //target is word need modify, explain is modify to
                dict.modifyWord(w1.getWord_target(), w1.getWord_explain());
                break;
            case "2":
                System.out.print("The word you want to modify: ");
                w1.setWord_target(input.nextLine());
                System.out.print("Modify to: ");
                w1.setWord_explain(input.nextLine());
                dict.modifyMeaning(w1.getWord_target(), w1.getWord_explain());
                break;
            default:
                break;
        }
        clrscr();
        System.out.println("The dictionary after modify");
        dict.showDict();
    }

    /**
     * Delete a word
     */
    public void deleteWord() {
        Scanner input = new Scanner(System.in);
        System.out.println("The word you want to delete: ");
        String needDelete = input.next();
        dict.deleteWord(needDelete);
        clrscr();
        System.out.println("The dictionary after delete");
        dict.showDict();
    }

    public void dictionaryExportToFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionaries.txt");
        File dataFile = new File(String.valueOf(dataDir));
        PrintWriter writer = new PrintWriter(dataFile);
        writer.print("");
        writer.close();
        dict.exportDictToFile(dataFile);
    }

    /**
     * Function DictSearch help us find the word we want.
     *
     * @param find is the word we want to find.
     */
    public void DictSearch() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu tieng anh muon tra: ");
        String find = sc.next();
        boolean flag = false;
        Set<String> target = dict.getKeyValue();
        for (String key : target) {
            if (target.toString().substring(0, find.length()).equals(find)) {
                flag = true;
                System.out.println(target.toString());
                break;
            }
        }
        if (!flag) {
            System.out.print("NOT FOUND");
        }
    }
}
