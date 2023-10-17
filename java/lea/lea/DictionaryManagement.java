package lea.lea;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;
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

    /**
     * đọc từ điển từ file.
     * @param dictionary thừa hưởng từ lớp Dictionary.
     */
    public Dictionary importFromFile(Dictionary dictionary) throws IOException {
        // Đọc từ file Dictionary.txt.
        FileReader fileReader = new FileReader("Dictionary.txt");
        // sử dụng phương thức BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // đọc các dòng trong file.
        String line = bufferedReader.readLine();
        while (line != null) {
            int position = -1;  // vị trí mặc định = -1. vị trí ngăn cách giữa 2 từ.
            for (int i = 0; i < line.length(); i++) {
                //xét xem dấu "Tab" có xuất hiện hay không.
                if ((int) line.charAt(i) == 9) {
                    position = i + 1;
                    break;
                }
            }
            // cắt xâu.
            String word_target = line.substring(0, position - 1);
            String word_explain = line.substring(position);
            // tạo từ mới bằng constructor 2.
            Word newWord = new Word(word_target, word_explain);
            // thêm từ vào từ điển hiện tại.
            dictionary.addWord(newWord);
            // đọc dòng tiếp theo.
            line = bufferedReader.readLine();
        }

        System.out.println("Successfully importing dictionary from file.");

        // giải phóng.
        fileReader.close();
        bufferedReader.close();

        return dictionary;
    }

    /**
     * tìm kiếm tuyến tính từ vựng.
     * tương tự hàm dictionaryLookup bên dưới.
     */
    public void dictionaryLookup(Dictionary dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập từ cần tìm kiếm: ");
        String word = input.nextLine();
        word = word.toLowerCase();
        // linear search.
        boolean isAppear = false;
        int position = -1;
        for (int i = 0; i < dictionary.getCount() && !isAppear; i++) {
            // nếu word_target có trong từ điển thì lưu lại vị trí và kết thúc vòng lặp.
            if (word.equals(dictionary.getWordArray().get(i).getWord_target())) {
                isAppear = true;
                position = i;
            }
        }
        // nếu từ đó có xuất hiện thì in ra từ đã tra.
        if (isAppear) {
            System.out.println("Từ cần tìm: " + dictionary.getWordArray().get(position).getWord_target());
            System.out.println("Nghĩa của từ: " + dictionary.getWordArray().get(position).getWord_explain());
        } else {
            System.out.println("Từ bạn đã tìm không xuất hiện trong từ điển.");
        }
    }

    public void dictionarySearcher(Dictionary dictionary) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        s = s.toLowerCase();
        System.out.println("Result words which start with " + s + " are:");
        for (int i = 0; i < dictionary.getCount(); i++) {
            if (dictionary.getWordArray().get(i).getWord_target().startsWith(s)) {
                String word_target = dictionary.getWordArray().get(i).getWord_target();
                String word_explain = dictionary.getWordArray().get(i).getWord_explain();
                System.out.println(word_target + " - " + word_explain);
            }
        }
    }

    /**
     * thêm từ mới.
     */
    public void addWord(Dictionary dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập từ muốn thêm: ");
        String word_target = input.nextLine();
        System.out.print("Nhập nghĩa của từ: ");
        String word_explain = input.nextLine();
        // nếu từ word_target không xuất hiện trong từ điển.
        // xem hàm dictionaryLookup() ở dưới.
        if (dictionaryLookup(dictionary, word_target) == -1) {
            Word newWord = new Word(word_target, word_explain);
            dictionary.addWord(newWord);
            System.out.println("Từ: " + word_target + " với nghĩa: " + word_explain + " đã được thêm vào từ điển hiện tại.");
        } else {
            System.out.println("Từ: " + word_target + " đã có trong từ điển.");
        }
    }

    /**
     * thay thế từ.
     * @param dictionary sử dụng lớp Dictionary.
     */
    public void updateWord(Dictionary dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào từ muốn sửa: ");
        String word_target = input.nextLine();
        word_target = word_target.toLowerCase();
        if (dictionaryLookup(dictionary, word_target) != -1) {
            System.out.println("Từ: " + word_target + " có xuất hiện trong từ điển. Vui lòng nhập từ muốn sửa.");
            System.out.println("Nếu muốn sửa cả từ, nhấn 0, nếu chỉ muốn sửa nghĩa từ, nhấn 1.");
            System.out.print("Nhập yêu cầu: ");
            int request = input.nextInt();
            // xoá kí tự enter.
            input.nextLine();
            int position = dictionaryLookup(dictionary, word_target);
            if (request == 0) {
                System.out.print("Nhập từ mới: ");
                String newWord_target = input.nextLine();
                System.out.print("Nhập nghĩa của từ mới: ");
                String newWord_explain = input.nextLine();

                // set lại từ cần thay đổi.
                dictionary.getWordArray().get(position).setWord_target(newWord_target);
                dictionary.getWordArray().get(position).setWord_explain(newWord_explain);
            } else if (request == 1){
                System.out.print("Nhập nghĩa của từ mới: ");
                String newWord_explain = input.nextLine();
                // yêu cầu = 1 nên chỉ cần set nghĩa của từ.
                dictionary.getWordArray().get(position).setWord_explain(newWord_explain);
            } else {
                System.out.println("Bạn đã nhập sai.");
            }
        } else {
            System.out.println("Từ: " + word_target + " không xuất hiện trong từ điển nên không thể xoá.");
        }
    }

    /**
     * xoá từ.
     * @param dictionary lớp Dictionary.
     */
    public void deleteWord(Dictionary dictionary) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào từ muốn xoá: ");
        String w = input.nextLine();
        if (dictionaryLookup(dictionary, w) == -1) {
            System.out.println("Từ bạn muốn xoá không xuất hiện trong từ điển.");
        } else {
            System.out.println("Từ bạn muốn xoá xuất hiện trong từ điển.");
            // gọi hàm xoá từ w trong lớp Dictionary.
            dictionary.deleteWord(w);
            System.out.println("Đã xoá từ: " + w);
        }
    }

    /**
     * xét xem từ word có trong từ điển hay không.
     */
    public int dictionaryLookup(Dictionary dictionary, String word) {
        int position = -1;
        word = word.toLowerCase();
        // linear search.
        boolean isAppear = false;
        for (int i = 0; i < dictionary.getCount() && !isAppear; i++) {
            // nếu từ có xuất hiện thì trả về giá trị của vị trí từ.
            if (word.equals(dictionary.getWordArray().get(i).getWord_target())) {
                isAppear = true;
                position = i;
            }
        }
        // trả về giá trị vị trí của từ, nếu không xuất hiện thì position = -1;
        return position;
    }
}