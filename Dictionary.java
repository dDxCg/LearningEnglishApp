public class Dictionary {
    private int count;
    private Word[] wordArray;

    /**
     * Constructor 1.
     */
    public Dictionary() {
        count = 0;
        wordArray = new Word[50];
    }

    /**
     * Constructor 2.
     */
    public Dictionary(Word[] wordArray, int count) {
        this.wordArray = wordArray;
        this.count = count;
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
            wordArray[count] = newWord;
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
            if (wordArray[i].getWord_target().equals(word)) {
                position = i;
                isAppear = true;
            }
        }

        // đẩy từ word ra khỏi mảng.
        if (isAppear) {
            for (int i = position; i < count; i++) {
                wordArray[i] = wordArray[i + 1];
            }

            // giảm số lượng từ.
            count--;
        }
    }
//
//    /**
//     * test.
//     */
//    public void print() {
//        System.out.println(count);
//        for (int i = 0; i < count; i++) {
//            System.out.println(wordArray[i].getWord_target() + " " + wordArray[i].getWord_explain());
//        }
//    }
}