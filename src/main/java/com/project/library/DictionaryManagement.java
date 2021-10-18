package com.project.library;


public class DictionaryManagement {
    private static Word w1 = new Word();
    private static Dictionary dict = new Dictionary();

    /**
     * Insert word to dictionary by application.
     */
    public static void insertFromApp(String english, String vietnamese) {
        w1.setWord_target(english);
        w1.setWord_explain(vietnamese);
        if (w1.getWord_target() != null && w1.getWord_explain() != null) {
            dict.addWordToDict(w1);
        }
    }
}