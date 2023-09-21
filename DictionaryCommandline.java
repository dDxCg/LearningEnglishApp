public class DictionaryCommandline {

    /**
     * Constructor.
     * chua co gi..
     */
    DictionaryCommandline() {

    }

    /**
     * show từ điển.
     */
    public static void showAllWords(Dictionary dictionary) {
        // tạo form bảng từ.
        System.out.println("No" + String.format("%7s", " | ") + "English" + String.format("%5s", " | ") + "Vietnamese");

        // in ra các từ theo form.
        for (int i = 0; i < dictionary.getCount(); i++) {
            System.out.println((i + 1) + String.format("%7s", " | ") + dictionary.getWordArray()[i].getWord_target() + String.format("%5s", " | ") + dictionary.getWordArray()[i].getWord_explain());
        }
    }

    /**
     * hàm dictionaryBasic.
     * Chức năng: thêm từ, in ra từ điển.
     * @param dictionary đối tượng của class Dictionary.
     */
    public void dictionaryBasic(Dictionary dictionary) {
        // tạo đối tượng class DictionaryManagement.
        DictionaryManagement call = new DictionaryManagement();

        // gọi hàm thêm từ bằng commandline.
        call.insertFromComandline(dictionary);

        // in ra từ điển hiện tại.
        DictionaryCommandline.showAllWords(dictionary);
    }
}