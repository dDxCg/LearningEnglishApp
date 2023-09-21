public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dc = new DictionaryManagement();
        dc.insertFromComandline();
        DictionaryCommandline d = new DictionaryCommandline();
        //d.showAllWords();
    }
}