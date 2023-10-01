import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        FavouriteDictionary favDict = new FavouriteDictionary();
//        favDict.Manager();
        Dictionary dict = new Dictionary();
        dict.FileImport("Dictionary.txt");
        dict.print();
        System.out.println(dict.checker("a"));
    }
}