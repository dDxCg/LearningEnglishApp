import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryAdvanced(dictionary, dictionaryManagement);
    }
}