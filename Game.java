import java.text.DecimalFormat;

public class Game {
    private int score;
    private boolean answer;

    public Game() {
        score = 0;
        answer = false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void printStatus(boolean ans, int mode, int current) {
        double numberOfQuestion = 0;
        double p = 0;
        double deP = 0;
        if (mode == 1) {
            numberOfQuestion = 10;
            p = 10;
            deP = 3;
            if (ans) {
                score += p;
            } else {
                if (score - deP <= 0) {
                    score = 0;
                } else {
                    score -= deP;
                }
            }
        } else if (mode == 2) {
            numberOfQuestion = 20;
            p = 5;
            deP = 2;
            if (ans) {
                score += p;
            } else {
                if (score - deP <= 0) {
                    score = 0;
                } else {
                    score -= deP;
                }
            }
        } else {
            numberOfQuestion = 40;
            p = 2.5;
            deP = 1.5;
            if (ans) {
                score += p;
            } else {
                if (score - deP <= 0) {
                    score = 0;
                } else {
                    score -= deP;
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("00.00");
        System.out.println("Score: " + score + ".\nProgress: " + decimalFormat.format((current / numberOfQuestion) * 100) + "%.\nQuestions left: " + (int) (numberOfQuestion - current));
    }
}