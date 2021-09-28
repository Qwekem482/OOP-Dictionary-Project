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

}
