import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionManager {
    List<Question> questionList;
    public final int NUMBEROFANSWER = 4;

    public QuestionManager() {
        questionList = new ArrayList<>();
    }

    public int getNUMBEROFANSWER() {
        return NUMBEROFANSWER;
    }

    public void importQuestions(String path) throws IOException {
        Reader reader = new Reader(path);
        String line = reader.getReader().readLine();
        while (line != null) {
            Question newQuestion = new Question();

            newQuestion.setContent(line.substring(4));
            line = reader.getReader().readLine();

            List<String> answer = new ArrayList<>();
            for (int i = 0; i < NUMBEROFANSWER; i++) {
                answer.add(line);
                line = reader.getReader().readLine();
            }
            newQuestion.setChoices(answer);

            newQuestion.setAnswer(line);

            questionList.add(newQuestion);

            line = reader.getReader().readLine();
        }
    }

    public List<Question> getQuestion(int number) {
        shuffle();
        List<Question> newList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            newList.add(questionList.get(i));
        }
        return newList;
    }

    public void shuffle() {
        Collections.shuffle(questionList);
    }
}
