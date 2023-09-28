import java.util.ArrayList;
import java.util.List;
public class Question {
    private String content;
    private List<String> choices;
    private String answer;

    public Question() {
        content = null;
        choices = new ArrayList<>();
        answer = null;
    }

    public Question(String content, List<String> choices, String answer) {
        this.content = content;
        this.choices = choices;
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
