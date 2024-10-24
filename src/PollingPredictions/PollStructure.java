package PollingPredictions;
/*
    - Tells classes what headers in data from csv is
    - Tells classes what the data extracted from csv should look like
 */
import java.util.Map;

public interface PollStructure {
    Map<String, Integer> original_data_headers = Map.of("pollster name", 2,
            "chosen candidate last name", 48,
            "percentage", 51);
    Map<Integer, String> new_data_headers = Map.of(0, "pollster name",
            1, "chosen candidate last name",
            2, "percentage");

    // this should really be a char, but its costly to do String.valueof() every time
    String STANDARD_DELIMITER = ",";
}
