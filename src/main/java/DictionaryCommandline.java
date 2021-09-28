
public class DictionaryCommandline {
    private DictionaryManagement manage = new DictionaryManagement();

    /**
     * show all the word in the array.
     */
    public void showAllWords(){
        this.manage.ShowWord();
    }

    /**
     * Insert Word and show the all the word in the array.
     */
    public void dictionaryBasic() {
        this.manage.insertFromCommandline();
        System.out.println("The Dictionary after adding new word");
        this.manage.ShowWord();
    }
}
