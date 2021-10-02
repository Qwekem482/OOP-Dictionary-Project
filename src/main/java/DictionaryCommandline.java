import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryCommandline {
    private DictionaryManagement manage = new DictionaryManagement();

    /**
     * show all the word in the array.
     */
    public void showAllWords() throws FileNotFoundException {
        this.manage.ShowWord();
    }

    /**
     * Insert Word and show the all the word in the array.
     */
    public void dictionaryBasic() throws FileNotFoundException {
        this.manage.insertFromCommandline();
        System.out.println("The Dictionary after adding new word");
        this.manage.ShowWord();
    }

    /**
     * Call the insert Word, ShowWord and DictLookup
     */
    public void dictionaryAdvanced() throws IOException {
        this.manage.insertFromFile();
        this.manage.ShowWord();
        this.manage.dictionaryLookup();
    }
}

