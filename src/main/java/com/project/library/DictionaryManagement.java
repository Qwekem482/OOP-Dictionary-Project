package com.project.library;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.*;
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
    public static void insertFromApp(String english, String vietnamese, String ipa, String grammar) throws FileNotFoundException {
        Word word = new Word(english, vietnamese, ipa, grammar, Word.NOT_DEV_CREATE);
        if (word.getWord_target() != "" && word.getWord_explain() != "") {
            dict.addWordToDict(w1);
        }
        dictionaryExportToFile();
    }

    /**
     * Connection to SQLServer
     * Read data from database then add word to dict.
     * Word & meaning separate by tab.
     *
     * @throws FileNotFoundException when cannot find file
     */
    public static void getConnect() throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dictionary", "root", "Thaidepzai1@");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from dict");
        while (resultset.next()) {
            Word word = new Word();
            String Word = resultset.getString(2);
            String Mean = resultset.getString(3);
            String ipa = resultset.getString(4);
            String grammar = resultset.getString(5);
            int dev = resultset.getInt(6);
            word.setWord_target(Word);
            word.setWord_explain(Mean);
            word.setIpa(ipa);
            word.setGrammar(grammar);
            word.setDevCreateWord(dev);
            dict.addWordToDict(word);
        }
    }

    /**
     * Read data from file then add word to dict.
     * Word & meaning separate by tab.
     *
     * @throws FileNotFoundException when cannot find file
     */
   /* public static void insertFromFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionary//dictionaries.txt");
        File dataFile = new File(String.valueOf(dataDir));
        Scanner inputScan = new Scanner(dataFile);
        while (inputScan.hasNext()) {
            Word word = new Word();
            if (inputScan.hasNext()) {
                inputScan = inputScan.useDelimiter("\\t");
                word.setWord_target(inputScan.next());
            }
            if (inputScan.hasNext()) {
                word.setWord_explain(inputScan.next());
            }
            if (inputScan.hasNext()) {
                word.setIpa(inputScan.next());
            }
            if (inputScan.hasNext()) {
                word.setGrammar(inputScan.next());
            }
            if (inputScan.hasNext()) {
                word.setDevCreateWord(inputScan.next());
                //System.out.println(inputProcess.substring(1));
            }
            dict.addWordToDict(word);
        }
        //TreeMap<String, Word> list = dict.getWordList();
        //System.out.println(list.get("day").isDevCreateWord());
    }*/

    /**
     * Show the English word list.
     *
     * @return English word list
     */
    public static ArrayList<String> showEngList() {
        return dict.getEngList();
    }

    public static TreeMap<String, Word> search(String find) {
        TreeMap<String, Word> forReturn = new TreeMap<String, Word>();
        boolean flag = false;
        TreeMap<String, Word> allWordList = dict.getWordList();
        for (String key : allWordList.keySet()) {
            if (key.length() >= find.length()) {
                if (key.substring(0, find.length()).equals(find)) {
                    flag = true;
                    forReturn.put(key, allWordList.get(key));
                }
            }
        }
        if (!flag) {
            Word word = new Word();
            forReturn.put("TỪ ĐIỂN KHÔNG CÓ TỪ BẠN CẦN", word);
        }
        return forReturn;
    }

    public static void dictionaryExportToFile() throws FileNotFoundException {
        Path currentDir = Path.of(System.getProperty("user.dir"));
        Path dataDir = currentDir.resolve("data//dictionary//dictionaries.txt");
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

    public static String ModifyWord(String needModify, String newModify) throws FileNotFoundException {
        if (dict.modifyWord(needModify, newModify)) {
            dictionaryExportToFile();
            return "Success";
        }
        return "Error";
    }

    public static String ModifyMean(String needModifyy, String newMeaningg) throws FileNotFoundException {
        if (dict.modifyMeaning(needModifyy, newMeaningg)) {
            return "Success";
        }
        return "Error";
    }
}