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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataCollector extends CandidateInformation implements PollStructure {
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
                    String url_name = "data/" + Parser.parseURL(url);
                    Files.copy(poll, Paths.get(url_name), StandardCopyOption.REPLACE_EXISTING);
                    file_names.add(url_name);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // collect data from csvs
    public void collectData() throws IOException {
        StringBuilder new_data = new StringBuilder();

        // for all files
        for (String file : file_names) {
            String contents = Files.readString(Path.of(file), StandardCharsets.UTF_8);
            // every line seperated by newlines
            List<String> lines = List.of(contents.split("\n"));
            ArrayList<Object[]> ex_data = new ArrayList<>();

            lines.stream()
                    .skip(1) // skip header
                    .map(line -> line.split(STANDARD_DELIMITER)) // split into strings based on delimiter
                    .map(Parser::parseData)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                    .forEach(System.out::println);
        }
    }

    public ArrayList<String> getData() { return data; }
    public ArrayList<String> getFileNames() { return file_names; }
}