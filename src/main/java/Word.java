public class Word {
    private String word_target
    private String word_explain;

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
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
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    /**
     * Constructor 2.
     * @param w1: Another word
     */
    public Word(Word w1) {
        this.word_target = w1.word_target;
        this.word_explain = w1.word_explain;
    }
}
