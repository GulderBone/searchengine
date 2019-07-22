import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<List<String>> tokenizedDocuments = new ArrayList<>();

    public static void main(String[] args) {
        TFIDFCalculator calculator = new TFIDFCalculator();
        SearchIndexer indexer = new SearchIndexer();
        addSampleData();

        indexer.sortDocuments(tokenizedDocuments, "fox");

        System.out.println("Enter the search query:");
        String query = new Scanner(System.in).nextLine();
    }

    private static void addSampleData() {
        tokenizedDocuments.add(tokenizeDocument("the fox fox fox over the brown dog"));
        tokenizedDocuments.add(tokenizeDocument("the brown fox jumped over the brown dog"));
        tokenizedDocuments.add(tokenizeDocument("the lazy brown dog sat in the corner"));
        tokenizedDocuments.add(tokenizeDocument("the red fox bit the lazy dog"));
    }

    private static List<String> tokenizeDocument(String document) {
        return Arrays.asList(document.split(" "));
    }
}
