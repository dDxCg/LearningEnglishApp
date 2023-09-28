import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dictionary {
    private int count;
    private List<Word> wordArray;

    public static final String DICT_PATH = "Dictionary.txt";

    /**
     * Constructor 1.
     */
    public Dictionary() {
        count = 0;
        wordArray = new ArrayList<>();
    }

    /**
     * Constructor 2.
     */
    public Dictionary(List<Word> wordArray, int count) {
        this.wordArray = wordArray;
        this.count = count;
    }

    /**
     * constructor file input.
     */
    public Dictionary(String filePath) throws IOException {
        Reader flManage = new Reader(filePath);
        wordArray = new ArrayList<>();
        wordArray = flManage.listInput();
    }


    /**
     * setter wordArray.
     * @param wordArray thiết lập mảng word.
     */
    public void setWordArray(List<Word> wordArray) {
        this.wordArray = wordArray;
    }

    /**
     * getter wordArray.
     * @return trả về mảng word.
     */
    public List<Word> getWordArray() {
        return this.wordArray;
    }

    /**
     * get count.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * set count.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * thêm từ mới.
     */
    public void addWord(Word newWord) {
        if (count < 50) {
            wordArray.add(newWord);
            count++;
        }
    }

    /**
     * xoá từ.
     */
    public void deleteWord(String word) {
        // lấy vị trí từ cần xoá.
        int position = -1;

        // xét xem từ word có xuất hiện hay không.
        boolean isAppear = false;

        for (int i = 0; i < count && !isAppear; i++) {
            // nếu xuất hiện thì lưu vị trí lại.
            if (wordArray.get(i).getWord_target().equals(word)) {
                position = i;
                isAppear = true;
            }
        }

        // đẩy từ word ra khỏi mảng.
        if (isAppear) {
            wordArray.remove(position);

            // giảm số lượng từ.
            count--;
        }
    }

    public void sortWords() {
        wordArray.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareTo(o2.getWord_target());
            }
        });
    }

    /**
     * test show all words and defs.
     */
    public void showAll() {
        String head1 = "No.";
        String head2 = "Word";
        String head3 = "Def";
        int firstBlank = 15;
        int secondBlank = 40;
        System.out.print(head1);
        for (int i = 0; i < firstBlank - head1.length(); ++i) {
            System.out.print(" ");
        }
        System.out.print("| " + head2);
        for (int i = 0; i < secondBlank - head2.length(); ++i) {
            System.out.print(" ");
        }
        System.out.print("| " + head3 + "\n");
        for (int i = 0; i < wordArray.size(); ++i) {
            String index = String.valueOf(i+1);
            System.out.print(index);
            for (int j = 0; j < firstBlank - index.length(); ++j) {
                System.out.print(" ");
            }
            String word = wordArray.get(i).getWord_target();
            String def = wordArray.get(i).getWord_explain();
            System.out.print("| " + word);
            for (int j = 0; j < secondBlank - word.length(); ++j) {
                System.out.print(" ");
            }
            System.out.print("| " + def + "\n");
        }
    }

    void export(String outPath) throws IOException {
        Writer writer = new Writer(outPath);
        for (int i = 0; i < wordArray.size(); ++i) {
            writer.writeWord(wordArray.get(i));
        }
        writer.close();
    }
}