/*
    This class downloads files from the interwebs,
    then reads the input, adds it to data variable
 */



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class DataCollector {
    private ArrayList<String> data;
    private ArrayList<String> file_names;

    // only real candidates worth looking at are harris and trump
                            // Kamala Harris   Donald Trump
    private static final int[] cand_no = {16661, 16651};

    DataCollector(String url_location) {

        // initalized dataset
        data = new ArrayList<>();
        file_names = new ArrayList<>();

        // try to create a new file_reader
        try (BufferedReader file_reader = new BufferedReader(new FileReader(url_location))) {
            String url;

            // for each url in file,
            while ((url = file_reader.readLine()) != null) {

                // try to open url,
                try (InputStream poll = new URL(url).openStream()) {
                    // if successful, create new data file
                    Files.copy(poll, Paths.get(poll.toString()), StandardCopyOption.REPLACE_EXISTING);
                    file_names.add(url.toString());
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

    public void collectData() {
        for (String file : file_names) {
            try (BufferedReader file_reader = new BufferedReader(new FileReader(file))) {
                while (file_reader.readLine() != null) {
                    // get specified data ????? ...

                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList<String> getData() { return data; }
    public ArrayList<String> getFileNames() { return file_names; }
}
