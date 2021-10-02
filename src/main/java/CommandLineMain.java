import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CommandLineMain {
    static Scanner input;
    static int choice;
    static boolean menuControl = true;
    static DictionaryCommandline dict = new DictionaryCommandline();

    private static void menu() {
        System.out.println("1. Add new word");
        System.out.println("2. Show the Dictionary");
        System.out.println("3. Look up a word");
        System.out.println("4. Exit the Dictionary");
        System.out.print("Your choice: ");
        input = new Scanner(System.in);
        choice = input.nextInt();
    }

    public static void main(String[] args) throws IOException {
        DictionaryManagement.clrscr();
        System.out.println("      English  - Vietnamese Dictionary v1.0.0");
        System.out.println("                        made by Qwekem482 and letthai");
        while (menuControl) {
            System.out.println("-----------------------------------------------------");
            System.out.println("What do you want to do?");
            menu();
            DictionaryManagement.clrscr();
            switch (choice) {
                case 1:
                    dict.dictionaryBasic();
                    break;
                case 2:
                    dict.showAllWords();
                    break;
                case 3:
                    dict.dictionaryAdvanced();
                    break;
                case 4:
                    menuControl = false;
                    break;
                default:
                    System.out.println("Can't recognize your input, please try again");
                    menu();
            }
        }
    }
}
