public class Game {
    private int score;
    private String process;
    private int numberOfQuestion;

    public Game() {
        score = 0;
        process = "0%";
        numberOfQuestion = 0;
    }

    public Game(int score, String process, int numberOfQuestion) {
        this.score = score;
        this.process = process;
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }
}
