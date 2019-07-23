package engine;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchIndexer {

    public Map<Double, String> sortDocuments(List<List<String>> documents, String searchQuery) {
        TFIDFCalculator calculator = new TFIDFCalculator();
        Map<Double, String> documentsWithValues = new TreeMap<>(Collections.reverseOrder());

        documents.stream()
                .filter(document -> calculator.tf(document, searchQuery) != 0)
                .forEach(document -> documentsWithValues.put(calculator.tfIdf(document, documents, searchQuery), detokenizeDocument(document)));

        return documentsWithValues;
    }

    private String detokenizeDocument(List<String> document) {
        return String.join(" ", document);
    }
}
