import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dict = new Dictionary(Dictionary.DICT_PATH);
        dict.showAll();
        dict.export("sampleOut.txt");
    }
}