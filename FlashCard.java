import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class FlashCard extends FavouriteDictionary{

    public FlashCard() throws IOException {
        new FavouriteDictionary();
    }

    private void nonShuffle() {
        boolean flag = false;
        Scanner scn = new Scanner(System.in);
        int i = 0;
        while (i < super.getCount() && !flag) {
            System.out.println("    Word: " + super.getWordArray().get(i).getWord_target());
            System.out.println("    1: Show definition");
            System.out.println("    2: Prev");
            System.out.println("    3: Next");
            System.out.println("    4: End");
            System.out.print("  Choice: ");
            switch (scn.nextLine()) {
                case "1":
                    System.out.println("Def: " + super.getWordArray().get(i).getWord_explain());
                    ++i;
                    break;
                case "2":
                    if (i - 1 < 0) {
                        System.out.println("Khong con tu phia truoc");
                    } else {
                        --i;
                    }
                    break;
                case "3":
                    if (i + 1 >= super.getCount()) {
                        System.out.println("Khong con tu phia sau");
                        flag = true;
                    } else {
                        ++i;
                    }
                    break;
                case "4":
                    flag = true;
                    break;
                default:
                    System.out.println("chon so tu 1 -> 4");
                    break;
            }
        }
    }

    private void shuffle() {
        //todo:
        Collections.shuffle(super.getWordArray());
        nonShuffle();
    }

    public void flashCard() throws IOException {
        boolean flag = false;
        Scanner scn = new Scanner(System.in);
        while (!flag) {
            System.out.println("0: Manange");
            System.out.println("1: Shuffle");
            System.out.println("2: Non shuffle");
            System.out.println("3: CLose");
            System.out.print("Choice: ");
            switch (scn.nextLine()) {
                case "0":
                    Manager();
                    break;
                case "1":
                    shuffle();
                    break;
                case "2":
                    super.sortWords();
                    nonShuffle();
                    break;
                case "3":
                    flag = true;
                    break;
                default:
                    System.out.println("Chon so tu 1 -> 3");
                    break;
            }
        }
    }
}
