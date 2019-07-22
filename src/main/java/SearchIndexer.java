import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SearchIndexer {

    public Map<Double, String> sortDocuments(List<List<String>> documents, String searchQuery) {
        Map<Double, String> documentsWithValues = new TreeMap<>(Collections.reverseOrder());

        documents.forEach(document -> documentsWithValues.put(new TFIDFCalculator().tfIdf(document, documents, searchQuery), detokenizeDocument(document)));

        return documentsWithValues;
    }

    private String detokenizeDocument(List<String> document) {
        return document.stream()
                .collect(Collectors.joining(" "));
    }
}
