import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    BufferedReader reader;

    Reader(String fileIn) throws IOException {
        reader = new BufferedReader(new FileReader(fileIn));
    }

    public List<Word> listInput() throws IOException {
        List<Word> output = new ArrayList<>();
        String data = "";
        while ((data = reader.readLine()) != null) {
            String word = "";
            String def = "";
            int i = 0;
            while (data.charAt(i) != '\t') {
                ++i;
            }
            word = data.substring(0,i);
            def = data.substring(i+1);
            Word newWord = new Word(word, def);
            output.add(newWord);
        }
        return output;
    }
}
