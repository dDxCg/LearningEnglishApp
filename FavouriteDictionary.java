import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FavouriteDictionary extends Dictionary{

    public FavouriteDictionary() throws IOException {
        super();
        super.FileImport("FavDict.txt");
    }


    public void save() throws IOException {
        Writer writer = new Writer("FavDict.txt");
        super.sortWords();
        List<Word> ls = super.getWordArray();
        for (Word word : ls) {
            writer.writeWord(word);
        }
        writer.close();
    }

    public void Manager() throws IOException {
        boolean flag = false;
        Scanner scn = new Scanner(System.in);
        while (!flag) {
            System.out.println("1: Add");
            System.out.println("2: Show All");
            System.out.println("3: Remove");
            System.out.println("4: Close");
            System.out.print("Option: ");
            switch (scn.nextInt()) {
                case 1: //add
                    scn.nextLine();
                    System.out.print("Word: ");
                    String word = scn.nextLine();
                    System.out.print("Definition: ");
                    String def = scn.nextLine();
                    Word newWord = new Word(word, def);
                    super.addWord(newWord);
                    save();
                    break;
                case 2: //show all
                    super.print();
                    break;
                case 3: //remove
                    System.out.print("Word to remove: ");
                    scn.nextLine();
                    String wordToRemove = scn.nextLine();
                    super.deleteWord(wordToRemove);
                    save();
                    break;
                case 4:
                    flag = true;
                    save();
                    break;
                default:
                    save();
                    System.out.println("Choose options from 1 -> 4:");
                    break;
            }
        }
    }

    public void flashCard() {
        //todo:
    }
}
