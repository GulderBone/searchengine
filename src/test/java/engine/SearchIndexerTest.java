package engine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchIndexerTest {
    private static List<List<String>> tokenizedDocuments = new ArrayList<>();
    private SearchIndexer indexer;


    @Before
    public void setUp() {
        indexer = new SearchIndexer();

        tokenizedDocuments.add(Arrays.asList("Robert", "was", "a", "good", "king"));
        tokenizedDocuments.add(Arrays.asList("There", "were", "many", "others", "who", "wanted", "to", "become", "king"));
        tokenizedDocuments.add(Arrays.asList("Eventually", "they", "succeeded", "in", "their", "plan", "of", "killing", "the", "king"));
        tokenizedDocuments.add(Arrays.asList("People", "were", "anxious", "and", "unhappy"));
        tokenizedDocuments.add(Arrays.asList("War", "does", "not", "bring", "anything", "good", "to", "the", "common", "people"));
    }

    @Test
    public void indexingTest() {
        Map<Double, String> indexedDocuments;

        indexedDocuments = indexer.sortDocuments(tokenizedDocuments, "Robert");
        assertEquals(1, indexedDocuments.size());

        indexedDocuments = indexer.sortDocuments(tokenizedDocuments, "king");
        assertEquals(3, indexedDocuments.size());

        indexedDocuments = indexer.sortDocuments(tokenizedDocuments, "people");
        assertEquals(2, indexedDocuments.size());
        assertTrue(indexedDocuments.containsValue("People were anxious and unhappy"));
        assertTrue(indexedDocuments.containsValue("War does not bring anything good to the common people"));
    }
}