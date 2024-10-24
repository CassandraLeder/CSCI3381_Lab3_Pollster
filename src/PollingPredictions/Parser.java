package PollingPredictions;

/*
    Parser parses a given url using its one method.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Parser extends CandidateInformation implements PollStructure {
    private final static String URL_DELIMITER = "/";

    // parse data from csv based on wanted information
    public static String[] parseData(String[] data) {
        StringBuilder new_data = new StringBuilder();

        // ignore unlikely candidates
        for (CandidateProfile candidate : CANDIDATES) {
            // see if candidate_id matches relevant candidates
            try {
                // the data is kinda wonky so sometimes data[49] is not candidate_id
                if (candidate.candidate_id() == Integer.parseInt(data[original_data_headers.get("chosen candidate last name")])) {
                    // 2: pollster name, 48: 'answer' or candidate choice last name
                    new_data.append(data[2]).append(STANDARD_DELIMITER).append(data[48]).append(STANDARD_DELIMITER);
                    // 51: percentage
                    new_data.append(data[51]);

                    data.add(new_data.toString());
                    break; // get out of candidate loop
                }
            }
            catch (NumberFormatException n) {
                System.out.println(n.getMessage());
            }
        }
    }

    // for a given file download, find just its filename
    public static String parseURL(String full_url) {
        String[] parse = full_url.split(URL_DELIMITER);
        return (parse[parse.length - 1]); // last element in URL should filename
    }
}
