
public class Dictionary {
    private int count = 0;
    private Word[] wordArray = new Word[50];

    /**
     * Constructor.
     */
     Dictionary() {
        for (int i = 0; i < 50; i++) {
            wordArray[i] = new Word();
        }
    }
    /**
     * setter wordArray.
     * @param wordArray thiết lập mảng word.
     */
    public void setWordArray(Word[] wordArray) {
        this.wordArray = wordArray;
    }

    /**
     * getter wordArray.
     * @return trả về mảng word.
     */
    public Word[] getWordArray() {
        return this.wordArray;
    }

    /**
     * get count.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * thêm từ mới.
     */
    public void addWord(Word newWord) {
        if (count < 50) {
            wordArray[count] = newWord;
            count++;
        }
    }

    /**
     * xoá từ.
     */
    public void deleteWord(String word) {
        int position = -1;
        boolean isAppear = false;
        for (int i = 0; i < count && !isAppear; i++) {
            if (wordArray[i].getWord_target().equals(word)) {
                position = i;
                isAppear = true;
            }
        }

        if (isAppear) {
            for (int i = position; i < count; i++) {
                wordArray[i] = wordArray[i + 1];
            }
            count--;
        }
    }
    public void print() {
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(wordArray[i].getWord_target() + " " + wordArray[i].getWord_explain());
        }
    }
}
