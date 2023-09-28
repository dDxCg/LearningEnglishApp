import java.io.BufferedReader;
import java.io.FileReader;
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

    public void importQuestions() {
        try {
            FileReader fileReader = new FileReader("Question.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String question = line;
                List<String> choices= new ArrayList<>();
                for (int i = 0; i < NUMBEROFANSWER; i++) {
                    line = bufferedReader.readLine();
                    choices.add(line);
                }

                line = bufferedReader.readLine();
                String answer = line;

                Question newQuestion = new Question(question, choices, answer);
                questionList.add(newQuestion);

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error while reading file Question.txt: " + e);
        }
    }

    public void shuffle() {
        Collections.shuffle(questionList);
    }
}
