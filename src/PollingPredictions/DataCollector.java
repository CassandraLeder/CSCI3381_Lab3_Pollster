package PollingPredictions;

/*
    This class downloads files from the interwebs,
    then reads the input, adds it to data variable
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class DataCollector extends CandidateInformation {
    // relevant information from polls
    // [0]: pollster name, [1]: candidate choice last name, [2]: percentage
    private ArrayList<String> data;
    private ArrayList<String> file_names;

    DataCollector(String url_location) {
        // initialize
        data = new ArrayList<>();
        file_names = new ArrayList<>();
        downloadFiles(url_location);
    }

    // helper function for constructor
    // downloads files from specified urls (urls.txt)
    private void downloadFiles(String url_location) {
        // try to create a new file_reader
        try (BufferedReader file_reader = new BufferedReader(new FileReader(url_location))) {
            String url;

            // for each url in file,
            while ((url = file_reader.readLine()) != null) {

                // try to open url,
                try {
                    URI uri = URI.create(url);
                    InputStream poll = uri.toURL().openStream();

                    // if successful, create new data file
                    String url_name = "data/" + parseURL(url);
                    Files.copy(poll, Paths.get(url_name), StandardCopyOption.REPLACE_EXISTING);
                    file_names.add(url_name);
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // helper function for downloadFiles()
    // for a given file download, find just its filename
    private String parseURL(String full_url) {
        String[] parse = full_url.split("/");
        return parse[parse.length - 1];
    }

    // collect data from csvs
    public void collectData() {

        // for all files
        for (String file : file_names) {
            try (BufferedReader file_reader = new BufferedReader(new FileReader(file))) {
                while (file_reader.readLine() != null) {
                    String[] data = file_reader.readLine().split(String.valueOf(STANDARD_DELIMITER));
                    StringBuilder new_data = new StringBuilder();

                    // ignore unlikely candidates
                    for (CandidateProfile candidate : CANDIDATES) {

                        try {
                            if (candidate.candidate_id() == Integer.parseInt(data[49])) {
                                // 2: pollster name, 48: 'answer' or candidate choice last name
                                new_data.append(data[2]).append(STANDARD_DELIMITER).append(data[48]).append(STANDARD_DELIMITER);
                                // 51: percentage
                                new_data.append(data[51]);

                                this.data.add(new_data.toString());
                                break; // get out of candidate loop
                            }
                        }
                        catch (NumberFormatException n) {
                            System.out.println(n.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<String> getData() { return data; }
    public ArrayList<String> getFileNames() { return file_names; }
}