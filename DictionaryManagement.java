import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class DictionaryManagement {

    /**
     * Constructor.
     * chua co gi..
     */
    public DictionaryManagement() {

    }

    /**
     * thêm từ vào từ điển (bao gồm cả từ và nghĩa).
     */
    public void insertFromComandline(Dictionary dictionary) {
        Dictionary dic = new Dictionary();
        Scanner insertWord = new Scanner(System.in);

        // nhập số lượng từ.
        System.out.print("Nhập số lượng từ: ");
        int numOfWords = insertWord.nextInt();

        // xoá bỏ "enter" sau khi nextInt().
        insertWord.nextLine();

        for (int i = 0; i < numOfWords; i++) {
            // nhập từ bằng tiếng anh.
            System.out.print("Nhập từ bằng tiếng anh: ");
            String word_target = insertWord.nextLine();

            // nhập nghĩa từ bằng tiếng việt.
            System.out.print("Nhập nghĩa của từ: ");
            String word_explain = insertWord.nextLine();

            // tạo từ.
            Word newWord = new Word(word_target, word_explain);

            // thêm từ vào từ điển.
            dictionary.addWord(newWord);
        }

        // giải phóng scanner.
        insertWord.close();
    }

    public void importFromFile(Dictionary dictionary) throws IOException {
        FileReader fileReader = new FileReader("Dictionary.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String line = bufferedReader.readLine();
        while (line != null) {
            int position = -1;
            for (int i = 0; i < line.length(); i++) {
                if ((int) line.charAt(i) == 9) {
                    position = i + 1;
                    break;
                }
            }
            String word_target = line.substring(0, position);
            String word_explain = line.substring(position);
            Word newWord = new Word(word_target, word_explain);
            dictionary.addWord(newWord);
            line = bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();
    }
}