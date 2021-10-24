package com.project.library;

public class Word {
    private String word_target;
    private String word_explain;
    private String ipa = "Không rõ";
    private String grammar = "Không rõ";
    private boolean devCreateWord;
    public static final boolean NOT_DEV_CREATE = false;

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

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public void setDevCreateWord(boolean devCreateWord) {
        this.devCreateWord = devCreateWord;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getIpa() {
        return ipa;
    }

    public String getGrammar() {
        return grammar;
    }

    public boolean isDevCreateWord() {
        return devCreateWord;
    }

    /**
     * Constructor 1.
     * @param word_target: Word in English
     * @param word_explain: Meaning in Vietnamese
     */
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.devCreateWord = false;
    }

    public Word(String word_target, String word_explain, String ipa, String grammar, boolean devCreateWord) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.ipa = ipa;
        if (grammar != "") {
            this.grammar = grammar;
        }
        this.devCreateWord = devCreateWord;
    }

    /**
     * Constructor 2.
     * @param w1: Another word
     */
    public Word(Word w1) {
        this.word_target = w1.word_target;
        this.word_explain = w1.word_explain;
        this.ipa = w1.ipa;
        this.grammar = w1.grammar;
        this.devCreateWord = w1.devCreateWord;
    }

    /**
     * Constructor 3.
     */
    public Word() {
    }
}
