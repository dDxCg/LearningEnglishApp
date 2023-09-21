public class DictionaryCommandline {

    /**
     * Constructor.
     */
    DictionaryCommandline() {

    }

    /**
     * show từ điển.
     */
    public void showAllWords() {
        Dictionary showDic = new Dictionary();
        int numOfWords = showDic.getCount();
        Word[] show = new Word[numOfWords];
        showDic.setWordArray(show);
        show = showDic.getWordArray();
        System.out.println(numOfWords);

        System.out.println("No" + String.format("%7s", " | ") + "English" + String.format("%5s", " | ") + "Vietnamese");
        for (int i = 0; i < numOfWords; i++) {
            System.out.println((i + 1) + String.format("%7s", " | ") + show[i].getWord_target() + String.format("%5s", " | ") + show[i].getWord_explain());
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement call = new DictionaryManagement();
        call.insertFromComandline();
        //DictionaryCommandline.showAllWords();
    }
}
