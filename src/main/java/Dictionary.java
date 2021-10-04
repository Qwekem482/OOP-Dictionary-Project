import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> list = new TreeMap<>();

    /**
     * Add a word to dict.
     * @param w1: word need to add
     */
    public void addWordToDict(Word w1) {
        this.list.put(w1.getWord_target(), w1.getWord_explain());
    }

    /**
     * Display dict to screen.
     * Sample:
     * 1    key 1                value 1
     * 2    key 2                value 2
     */
    public void showDict() {
        String formatWord = "%-30s%s%n"; //Add tab to align string
        String formatNo = "%-10s"; //Add tab to align number
        int i = 1;
        System.out.println("No.       English                       Vietnamese");
        for (String key : list.keySet()) {
            //printf to add format, @param formatWord(No) is add-tab format
            System.out.printf(formatNo, i);
            System.out.printf(formatWord, key, list.get(key));
            i++;
        }
    }

    public void exportDictToFile(File outputFile) throws FileNotFoundException {
        PrintWriter writeToFile = new PrintWriter(outputFile);
        for (String key : list.keySet()) {
            //printf to add format, @param formatWord is add-tab format
            writeToFile.print(key);
            writeToFile.print("\t");
            writeToFile.print(list.get(key));
            writeToFile.print("\n");
        }
        writeToFile.close();
    }

    /**
     * find a word in dictionary.
     * @param target word need meaning
     * @return meaning or error message
     */
    public String findWordInDict(String target) {
        target = target.toLowerCase();
        for (String key : list.keySet()) {
            if (target.equals(key)) {
                return list.get(key);
            }
        }
        return "Can't find this word, please try again.";
    }

    /**
     * Modify a word_target.
     * @param needModify word_target need modify
     * @param newModify word_target after modify
     */
    public void modifyWord(String needModify, String newModify) {
        if (list.containsKey(needModify)) {
            this.list.put(newModify, list.get(needModify));
            list.remove(needModify);
        } else {
            System.out.println("Can't find this word");
        }
    }

    /**
     * Modify a word_meaning.
     * @param needModify word_target need modify
     * @param newMeaning word_meaning after modify
     */
    public void modifyMeaning(String needModify, String newMeaning) {
        if (list.containsKey(needModify)) {
            list.remove(needModify);
            this.list.put(needModify, newMeaning);
        } else {
            System.out.println("Can't find this word");
        }
    }

    /**
     * Delete a word.
     * @param needDelete word_target need delete
     */
    public void deleteWord(String needDelete) {
        if (list.containsKey(needDelete)) {
            this.list.remove(needDelete);
        } else {
            System.out.println("Can't find this word");
        }
    }
    int Count(){
        return list.size();
    }
    public Set<String> getKeyValue(){
        return list.keySet();
    }
}
