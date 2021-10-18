package com.project.library;

public class Word {
    private String word_target;
    private String word_explain;

    public void setWord_explain(String word_explain) {
        if (word_explain == "") return;
        //when insert from file, word explain have /t as the begin char
        if(word_explain.charAt(0) == '\t') {
            String delBeginning = word_explain.substring(1);
            this.word_explain = delBeginning.toLowerCase();
            return;
        }
        this.word_explain = word_explain.toLowerCase();
    }

    public void setWord_target(String word_target) {
        if (word_target == "") return;
        //when insert from file, word target have /n as the begin char
        if(word_target.charAt(0) == '\n' || word_target.charAt(0) == '\t') {
            String delBeginning = word_target.substring(1);
            this.word_target = delBeginning.toLowerCase();
            return;
        }
        this.word_target = word_target.toLowerCase();
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    /**
     * Constructor 1.
     * @param word_target: Word in English
     * @param word_explain: Meaning in Vietnamese
     */
    public Word(String word_target, String word_explain) {
        this.word_target = word_target.toLowerCase();
        this.word_explain = word_explain.toLowerCase();
    }

    /**
     * Constructor 2.
     * @param w1: Another word
     */
    public Word(Word w1) {
        this.word_target = w1.word_target;
        this.word_explain = w1.word_explain;
    }

    /**
     * Constructor 3.
     */
    public Word() {
    }
}
