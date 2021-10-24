package com.project.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class Dictionary {
    private static TreeMap<String, Word> list = new TreeMap<>();

    /**
     * Add a word to dict.
     *
     * @param word: word need to add
     */
    public void addWordToDict(Word word) {
        list.put(word.getWord_target(), word);
    }

    public ArrayList<String> getEngList() {
        ArrayList<String> forReturn = new ArrayList<String>();
        for (String key : list.keySet()) {
            forReturn.add(key);
        }
        return forReturn;
    }

    public TreeMap<String, Word> getWordList() {
        return list;
    }

    public void exportDictToFile(File outputFile) throws FileNotFoundException {
        PrintWriter writeToFile = new PrintWriter(outputFile);
        for (String key : list.keySet()) {
            writeToFile.print(key);
            writeToFile.print("\t");
            writeToFile.print(list.get(key).getWord_explain());
            writeToFile.print("\t");
            writeToFile.print(list.get(key).getIpa());
            writeToFile.print("\t");
            writeToFile.print(list.get(key).getGrammar());
            writeToFile.print("\t");
            writeToFile.print(list.get(key).isDevCreateWord());
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
            list.get(needModify).setWord_explain(newMeaning);
            return true;
        }
        return false;
    }
}
