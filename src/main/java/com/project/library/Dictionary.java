package com.project.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class Dictionary {
    private static TreeMap<String, String> list = new TreeMap<>();

    /**
     * Add a word to dict.
     *
     * @param w1: word need to add
     */
    public void addWordToDict(Word w1) {
        this.list.put(w1.getWord_target(), w1.getWord_explain());
    }

    public ArrayList<String> getEngList() {
        ArrayList<String> forReturn = new ArrayList<String>();
        for (String key : list.keySet()) {
            forReturn.add(key);
        }
        return forReturn;
    }

    public ArrayList<String> getVieList() {
        ArrayList<String> forReturn = new ArrayList<String>();
        for (String key : list.keySet()) {
            forReturn.add(list.get(key));
        }
        return forReturn;
    }

    public TreeMap<String, String> getWordList() {
        TreeMap<String, String> forReturn = list;
        return forReturn;
    }

    public void exportDictToFile(File outputFile) throws FileNotFoundException {
        PrintWriter writeToFile = new PrintWriter(outputFile);
        for (String key : list.keySet()) {
            //printf to add format, @param formatWord is add-tab format
            writeToFile.print(key);
            writeToFile.print("\t");
            writeToFile.print(list.get(key));
            writeToFile.print("\n");
        }
        writeToFile.close();
    }

    public boolean deleteWord(String needDelete) {
        if (list.containsKey(needDelete)) {
            this.list.remove(needDelete);
            return true;
        }
        return false;
    }

    public boolean modifyWord(String needModify, String newModify) {
        if (needModify.equals(newModify)) return false;
        if (list.containsKey(needModify)) {
            this.list.put(newModify, list.get(needModify));
            list.remove(needModify);
            return true;
        }
        return false;
    }

    public boolean modifyMeaning(String needModify, String newMeaning) {
        if (needModify.equals(newMeaning)) return false;
        if (list.containsKey(needModify)) {
            list.remove(needModify);
            this.list.put(needModify, newMeaning);
            return true;
        }
        return false;
    }
}
