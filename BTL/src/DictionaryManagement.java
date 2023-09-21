import java.util.Scanner;
public class DictionaryManagement {
    public DictionaryManagement() {

    }
    /**
     * thêm từ vào từ điển (bao gồm cả từ và nghĩa).
     */
    public void insertFromComandline() {
        Dictionary dic = new Dictionary();
        Scanner insertWord = new Scanner(System.in);
        String word_target = insertWord.next(); //tieng anh
        String word_explain = insertWord.next(); //tieng viet
        Word newWord = new Word();
        newWord.setWord_explain(word_explain);
        newWord.setWord_target(word_target);
        dic.addWord(newWord);
    }
}
