import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLauncher {
    private int mode;
    private int trueNumber;
    private int falseNumber;

    public GameLauncher() {
        mode = 0;
        trueNumber = 0;
        falseNumber = 0;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<Question> getQuestion(QuestionManager questionManager) {
        int number = 10;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        return questionManager.getQuestion(number);
    }

    public void menu(QuestionManager questionManager) {
        Scanner input = new Scanner(System.in);
        int mode = 0;
        System.out.println("Chào mừng đến với multiple-choice game!!!");
        System.out.println("Luật chơi: ");
        System.out.println("Có 3 chế độ: Dễ - Trung bình - Khó lần lượt tương ứng với số lượng câu hỏi: 10 - 20 - 40");
        System.out.println("Dễ: Mỗi câu đúng được 10đ, trả lời sai trừ 3đ.");
        System.out.println("Trung bình: Mỗi câu đúng được 5đ, trả lời sai mất 2đ.");
        System.out.println("Khó: Mỗi câu đúng được 2.5đ, trả lời sai mất 1.5đ.");
        System.out.print("Vui lòng chọn mức độ chơi (nhập 1 (Dễ) hoặc 2 (Trung bình) hoặc 3 (Khó): ");
        while (true) {
            mode = input.nextInt();
            setMode(mode);
            if (mode == 1) {
                System.out.println("Bạn đã chọn chế độ dễ.");
                System.out.println("Chúc bạn chơi vui vẻ!");
                launch(new Game(), questionManager, 10);
                break;
            } else if (mode == 2) {
                System.out.println("Bạn đã chọn chế độ trung bình.");
                System.out.println("Chúc bạn chơi vui vẻ!");
                launch(new Game(), questionManager, 20);
                break;
            } else if (mode == 3) {
                System.out.println("Bạn đã chọn chế độ khó.");
                System.out.println("Chúc bạn chơi vui vẻ!");
                launch(new Game(), questionManager, 40);
                break;
            } else {
                System.out.println("Nhập sai dữ liệu, vui lòng nhập lại.");
            }
        }
    }

    public void launch(Game game, QuestionManager questionManager, int number) {
        System.out.println("-----------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        List<Question> questionList = new ArrayList<>();
        questionList = questionManager.getQuestion(number);

        for (int i = 0; i < number; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            System.out.println(questionList.get(i).getContent());
            for (int j = 0; j < questionManager.getNUMBEROFANSWER(); j++) {
                System.out.println(questionList.get(i).getChoices().get(j));
            }

            System.out.print("Nhập câu trả lời của bạn: ");
            String answer = scanner.next();
            String correctAnswer = questionList.get(i).getAnswer();
            if (answer.equals(correctAnswer) || answer.equals(correctAnswer.toLowerCase())) {
                game.setAnswer(true);
                trueNumber++;
                System.out.println("Bạn đã trả lời đúng.");
            } else {
                game.setAnswer(false);
                falseNumber++;
                System.out.println("Bạn đã trả lời sai. Đáp án đúng là: " + correctAnswer);
            }
            System.out.println("-----------------------------------------------------------");
            game.printStatus(game.isAnswer(), mode, i + 1);
            System.out.println("-----------------------------------------------------------");
        }
        System.out.println("Cảm ơn bạn đã chơi. Sau đây là kết quả: ");
        System.out.println("Điểm: " + game.getScore() + ".\nSố câu trả lời đúng: " + trueNumber + ".\nSố câu trả lời sai: " + falseNumber);
    }
}