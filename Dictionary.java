import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class Dictionary {
    private int count;
    private List<Word> wordArray;

    /**
     * Constructor 1.
     */
    public Dictionary() {
        wordArray = new ArrayList<>();
    }

    /**
     * Constructor 2.
     */
    public Dictionary(List<Word> wordArray) {
        this.wordArray = wordArray;
    }

    /**
     * setter wordArray.
     * @param wordArray thiết lập mảng word.
     */
    public void setWordArray(List<Word> wordArray) {
        this.wordArray = wordArray;
    }

    public int getCount() {
        return wordArray.size();
    }

    /**
     * getter wordArray.
     * @return trả về mảng word.
     */
    public List<Word> getWordArray() {
        return this.wordArray;
    }

    /**
     *if word is in dictionary return index else return -1.
     */
    public int iSInDictionary(String word) {
        //todo:
        for (int i = 0; i < wordArray.size(); ++i) {
            if (wordArray.get(i).getWord_target() == word) {
                return i;
            }
        }
        return -1;
    }

    /**
     * thêm từ mới.
     */
    public void addWord(Word newWord) {
        if (iSInDictionary(newWord.getWord_target()) == -1) {
            wordArray.add(newWord);
        }
    }

    /**
     * xoá từ.
     */
    public void deleteWord(String word) {
        if (iSInDictionary(word) != -1) {
            wordArray.remove(iSInDictionary(word));
        } else {
            System.out.println("The word is not in the dictionary.");
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

    public void FileImport (String path) throws IOException {
        Reader reader = new Reader(path);
        wordArray = reader.listInput();
    }

    /**
     * test.
     */
    public void print() {
        for (Word word : wordArray) {
            System.out.println(word.getWord_target() + " " + word.getWord_explain());
        }
    }
}