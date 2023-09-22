import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryCommandline d = new DictionaryCommandline();
        d.dictionaryBasic(dictionary);
    }
}