import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public BufferedWriter writer;

    Writer(String outPath) throws IOException {
        writer = new BufferedWriter(new FileWriter(outPath));
    }

    public void writeWord(Word newWord) throws IOException {
        writer.write(newWord.getWord_target() + "\t" + newWord.getWord_explain() + "\n");
    }

    void close() throws IOException {
        writer.close();
    }
}
