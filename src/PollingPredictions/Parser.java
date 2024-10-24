package PollingPredictions;

/*
    Parser parses a given url using its one method.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser extends CandidateInformation implements PollStructure {
    private final static String URL_DELIMITER = "/";

    // parse data from csv based on wanted information
    public static String[] parseData(String[] data) {
        StringBuilder new_data_string = new StringBuilder();
        ArrayList<String> new_data = new ArrayList<>();


        // ignore unlikely candidates
        for (CandidateProfile candidate : CANDIDATES) {
            // the data is kinda wonky so sometimes data[49] is not candidate_id
            // if data at the index of candidate id matches current candidates id
            // this is so ugly
            if (data[original_data_headers.get("candidate id")]
                    .equals(String.valueOf(candidate.candidate_id()))) {

                // based on the correct order of columns for data array,
                // add from data using original index of column
                for (String val : new_data_headers.values()) {

                    // if not last string, append comma, else don't
                    if(!val.equals(STANDARD_COLUMNS[STANDARD_COLUMNS.length - 1]))
                        new_data_string.append(data[original_data_headers.get(val)]).append(STANDARD_DELIMITER);
                    else
                        new_data_string.append(data[original_data_headers.get(val)]);
                }
                new_data.add(new_data.toString());

                break; // get out of candidate loop
            }
        }

        return (new_data.toArray(new String[new_data.size()]));
    }

    // for a given file download, find just its filename
    public static String parseURL(String full_url) {
        String[] parse = full_url.split(URL_DELIMITER);
        return (parse[parse.length - 1]); // last element in URL should filename
    }
}