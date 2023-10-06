import java.io.IOException;
import java.util.Scanner;

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
        // sap xep.
        dictionary.sortWords();

        // tạo form bảng từ.
        System.out.printf("%-5s%-15s%-15s%n", "No", "English", "Vietnamese");

        // in ra các từ theo form.
        for (int i = 0; i < dictionary.getCount(); i++) {
            System.out.printf("%-5s%-15s%-15s%n", i + 1, dictionary.getWordArray().get(i).getWord_target(), dictionary.getWordArray().get(i).getWord_explain());
        }
    }

    /**
     * hàm dictionaryBasic.
     * tạm thời bỏ qua.
     * Chức năng: thêm từ, in ra từ điển.
     * @param dictionary đối tượng của class Dictionary.
     */
    /*public void dictionaryBasic(Dictionary dictionary) throws IOException {
        // tạo đối tượng class DictionaryManagement.
        DictionaryManagement call = new DictionaryManagement();

        //call.addWordToDictionary(dictionary, numberOfWords);
        // gọi hàm thêm từ bằng commandline.
        //call.insertFromComandline(dictionary);

        // in ra danh sách từ điển trong file.
        //call.importFromFile(dictionary);

        // in ra từ điển hiện tại.
        DictionaryCommandline.showAllWords(dictionary);

        // thêm từ vào từ điển.
        //call.addWordToDictionary(dictionary);

        call.addWord(dictionary);
        call.addWord(dictionary);
        call.updateWord(dictionary);
        call.deleteWord(dictionary);

        //test.
        //call.dictionaryLookup(dictionary);

        DictionaryCommandline.showAllWords(dictionary);
    }*/

    /**
     * từ điển nâng cao.
     * hàm này chắc dễ hiểu nhất òi.
     * @param dictionary sử dụng từ điển hiện có.
     * @param dictionaryManagement dùng các chức năng của từ điển.
     * @throws IOException exception io của file.
     */
    public void dictionaryAdvanced(Dictionary dictionary, DictionaryManagement dictionaryManagement) throws IOException {
        System.out.println("Welcome to our application!");
        System.out.println("Features: [9] is not available, stay cool and wait for a newer version.");
        System.out.println("English Learning Application v1.0.0");
        System.out.println("Produced by D.D.Dung, D.D.Cuong, N.V.Ban.");
        System.out.println("Course: OOP - UET - K67 - CA - CLC2 - 2023.");
        while (true) {
            System.out.println("--------------------");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.print("Enter your request: ");
            Scanner input = new Scanner(System.in);
            int request = input.nextInt();
            System.out.println("--------------------");
            if (request < 0 || request > 9) {
                System.out.println("Nhập sai, vui lòng nhập lại.");
                continue;
            }
            switch (request) {
                case 1 -> dictionaryManagement.addWord(dictionary);
                case 2 -> dictionaryManagement.deleteWord(dictionary);
                case 3 -> dictionaryManagement.updateWord(dictionary);
                case 4 -> showAllWords(dictionary);
                case 5 -> dictionaryManagement.dictionaryLookup(dictionary);
                case 6 -> dictionaryManagement.dictionarySearcher(dictionary);
                case 7 -> {
                    QuestionManager questionManager = new QuestionManager();
                    questionManager.importQuestions("Question.txt");
                    GameLauncher gameLauncher = new GameLauncher();
                    gameLauncher.menu(questionManager);
                }
                case 8 -> dictionary = dictionaryManagement.importFromFile(dictionary);
                case 9 -> System.out.println("Feature is not Available.");
            }
            if (request == 0) {
                System.out.println("Quiting...");
                System.out.println("Quited. Thanks for using our Application.");
                break;
            }
        }
    }
}