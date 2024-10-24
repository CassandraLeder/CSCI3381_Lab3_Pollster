package PollingPredictions;
/*
    - Define what headers in data from csv is
    - Define what the data extracted from csv should look like
    - contains csv delimiter
 */
import java.util.Map;
import java.util.TreeMap;

public interface PollStructure {
    // prevent making typos by rewriting twice
    String[] STANDARD_COLUMNS = {"pollster name", "chosen candidate last name", "candidate id", "percentage"};

    TreeMap<String, Integer> original_data_headers = new TreeMap<>(Map.of(STANDARD_COLUMNS[0], 2,
            STANDARD_COLUMNS[1], 48,
            STANDARD_COLUMNS[2], 49,
            STANDARD_COLUMNS[3], 51));

    // keys type swapped so we can iterate over column names to query original columns
    TreeMap<Integer, String> new_data_headers = new TreeMap<>(Map.of(0, STANDARD_COLUMNS[0],
            1, STANDARD_COLUMNS[1],
            2, STANDARD_COLUMNS[2],
            3, STANDARD_COLUMNS[3]));

    // this should really be a char, but it's costly to do String.valueof() every time
    String STANDARD_DELIMITER = ",";
}
