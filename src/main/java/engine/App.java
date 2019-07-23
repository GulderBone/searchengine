package engine;

import java.util.*;

public class App {

    private static List<List<String>> tokenizedDocuments = new ArrayList<>();

    public static void main(String[] args) {
        SearchIndexer indexer = new SearchIndexer();
        addSampleData();

        Scanner scanner = new Scanner(System.in);
        String query = "";
        Map<Double, String> results;

        while (!"exit".equals(query)) {

            System.out.println("Enter the search query or write 'exit' to stop the search:");
            query = scanner.nextLine();
            results = indexer.sortDocuments(tokenizedDocuments, query);

            writeSearchResults(results);
        }
    }

    private static void addSampleData() {
        tokenizedDocuments.add(tokenizeDocument("the brown fox jumped over the brown dog"));
        tokenizedDocuments.add(tokenizeDocument("the lazy brown dog sat in the corner"));
        tokenizedDocuments.add(tokenizeDocument("the red fox bit the lazy dog"));
    }

    private static List<String> tokenizeDocument(String document) {
        return Arrays.asList(document.split(" "));
    }

    private static void writeSearchResults(Map<Double, String> results) {
        for (Map.Entry<Double, String> entry : results.entrySet()) {
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
        System.out.println();
    }
}
