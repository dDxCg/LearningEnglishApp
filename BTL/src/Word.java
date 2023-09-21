public class Word {
    private String word_target;
    private String word_explain;

    /**
     * getter word_target.
     * @return trả về từ cần tra.
     */
    public String getWord_target() {
        return this.word_target;
    }

    /**
     * setter word_target.
     * @param word_target thiết lập từ cần tra.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * getter word_explain.
     * @return trả về nghĩa của từ.
     */
    public String getWord_explain() {
        return this.word_explain;
    }

    /**
     * setter word_explain.
     * @param word_explain thiết lập nghĩa của từ.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * constructor 1.
     */
    Word() {
        word_target = "";
        word_explain = "";
    }

    /**
     * Constructor 2.
     * @param target từ vựng.
     * @param explain giải thích nghĩa từ.
     */
    Word (String target, String explain) {
        this.word_target = target;
        this.word_explain = explain;
    }

    /**
     * Constructor 3.
     * @param word thiết lập đối tượng word.
     */
    Word (Word word) {
        this.word_target = word.word_target;
        this.word_explain = word.word_explain;
    }

}
