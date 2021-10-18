package com.project.library;

import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> list = new TreeMap<>();

    /**
     * Add a word to dict.
     *
     * @param w1: word need to add
     */
    public void addWordToDict(Word w1) {
        this.list.put(w1.getWord_target(), w1.getWord_explain());
    }
}
