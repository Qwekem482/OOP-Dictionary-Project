package com.project.library;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DictionaryManagement {
    private static Word w1 = new Word();
    private static Dictionary dict = new Dictionary();

    /**
     * Insert word to dictionary by application.
     */
    public static void insertFromApp(String english, String vietnamese) throws FileNotFoundException {
        w1.setWord_target(english);
        w1.setWord_explain(vietnamese);
        if (w1.getWord_target() != null && w1.getWord_explain() != null) {
            dict.addWordToDict(w1);
        }
        dictionaryExportToFile();
    }

    /**
     * Read data from file then add word to dict.
     * Word & meaning separate by tab.
     *
     * @throws FileNotFoundException when cannot find file
     */
    public static void insertFromFile() throws FileNotFoundException {
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
     * Show the English word list.
     * @return English word list
     */
    public static ArrayList<String> showEngList() {
        return dict.getEngList();
    }

    public static TreeMap<String, String> search(String find) {
        TreeMap<String, String> forReturn = new TreeMap<String, String>();
        boolean flag = false;
        int i = 1;
        TreeMap<String, String> allWordList = dict.getWordList();
        for (String key : allWordList.keySet()) {
            if (key.length() >= find.length()) {
                if (key.substring(0, find.length()).equals(find)) {
                    flag = true;
                    forReturn.put(key, allWordList.get(key));
                    i++;
                }
            }
        }
        if (!flag) {
            forReturn.put("NOT FOUND", "PLEASE CHECK SPELLING AND/OR TRY AGAIN");
        }
        return forReturn;
    }

    public static void dictionaryExportToFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionaries.txt");
        File dataFile = new File(String.valueOf(dataDir));
        PrintWriter writer = new PrintWriter(dataFile);
        writer.print("");
        writer.close();
        dict.exportDictToFile(dataFile);
    }

    public static String DeleteWord(String Delete) throws FileNotFoundException {
        if (dict.deleteWord(Delete)) {
            dictionaryExportToFile();
            return "Success";
        }
        return "Error";
    }

}