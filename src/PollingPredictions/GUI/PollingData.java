package PollingPredictions.GUI;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import PollingPredictions.Analyzer;
import PollingPredictions.CandidateProfile;
import PollingPredictions.DataCollector;
import static PollingPredictions.CandidateInformation.CANDIDATES;

/*
    MAIN FOR GUI
 */

public class PollingData implements GUIConstants {
    // location of text file containing list of urls
    private final static String URLS = "src/urls.txt";

    // constructor
    public PollingData(JFrame jFrame) {
        // set all defaults
        jFrame.setTitle(FRAME_TITLE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setLayout(DEFAULT_LAYOUT_MANAGER);
        jFrame.setBackground(BACKGROUND_COLOR);
        jFrame.setFont(DEFAULT_FONT);
    }

    public static void main(String[] args) {
        // set up jframe
        JFrame jFrame = new JFrame();
        PollingData default_obj = new PollingData(jFrame);

        DataCollector dataCollector = new DataCollector(URLS);
        // to prevent unncessary returning of data
        ArrayList<Object[]> data = dataCollector.getData();

        // try to collect data
        try  { dataCollector.collectData(); }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // tablepanel
        TablePanel tablePanel = new TablePanel(dataCollector.getData());

        // statspanel
        Analyzer analyzer = new Analyzer();
        JPanel[] statsPanels = new JPanel[CANDIDATES.length];
        int panel_iterator = 0;

        for (CandidateProfile candidate : CANDIDATES) {
            // get should be used on returned data because the maps are numbers associated with a candidate's last name
            double mean = analyzer.computeAverage(candidate.candidate_id(), data).get(candidate.candidate_last_name());
            double standard_deviation = analyzer.computeStandardDeviation(candidate.candidate_id(), data).get(candidate.candidate_last_name());
            String likely_winner1 = analyzer.guessWinner(data);
            String likely_winner2 = analyzer.predictWinner();

            statsPanels[panel_iterator] = new StatsPanel(candidate.candidate_id(), mean, standard_deviation,
                    likely_winner1, likely_winner2);

            ++panel_iterator;
        }

        // add panels
        for (JPanel statPanel : statsPanels)
            jFrame.getContentPane().add(statPanel);

        jFrame.getContentPane().add(tablePanel);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
