import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    private DictionaryManagement manage = new DictionaryManagement();

    /**
     * show all the word in the array.
     */
    public void showAllWords() throws FileNotFoundException {
        manage.insertFromFile();
        this.manage.ShowWord();
    }

    /**
     * Insert Word and show the all the word in the array.
     */
    public void dictionaryBasic() throws FileNotFoundException {
        manage.insertFromFile();
        this.manage.insertFromCommandline();
        System.out.println("The Dictionary after adding new word");
        this.manage.ShowWord();
        this.manage.dictionaryExportToFile();
    }

    /**
     * Call the insert Word, ShowWord and DictLookup.
     */
    public void dictionaryAdvanced() throws IOException {
        manage.insertFromFile();
        this.manage.ShowWord();
        this.manage.dictionaryLookup();
    }

    /**
     * Modify word.
     */
    public void modifyWord() throws FileNotFoundException {
        manage.insertFromFile();
        this.manage.modifyWord();
        this.manage.dictionaryExportToFile();
    }

    /**
     * Delete word.
     */
    public void deleteWord() throws FileNotFoundException {
        manage.insertFromFile();
        this.manage.deleteWord();
        this.manage.dictionaryExportToFile();
    }

    /**
     * Funtion DictionarySearch().
     */
    public void dictionnarySearch() throws FileNotFoundException {
        manage.insertFromFile();
        manage.DictSearch();
    }
}

