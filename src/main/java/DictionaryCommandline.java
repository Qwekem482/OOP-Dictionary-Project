import java.util.ArrayList;
import java.util.TreeMap;

public class DictionaryCommandline {
    private DictionaryManagement _word = new DictionaryManagement();
    /**
     * show all the word in the array
     */
    public void Show(){
        _word.ShowWord();
    }
    /**
     * //function DictionaryBasic()
     * Insert Word and show the all the word in the array
     */
    public void DictionaryBasic(){
        _word.insertFromCommandline();
        _word.ShowWord();
    }
}
