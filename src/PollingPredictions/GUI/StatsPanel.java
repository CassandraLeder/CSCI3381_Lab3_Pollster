package PollingPredictions.GUI;
/*
    Panel that displays stats, mean and std deviation, about presidential election candidates
 */

import javax.swing.*;
import PollingPredictions.CandidateProfile;
import PollingPredictions.CandidateInformation;

public class StatsPanel extends JPanel implements GUIConstants {
    JTextArea mean;
    JTextArea standard_deviation;


    StatsPanel(int candidate_id, double mean, double standard_deviation) {
        // this is the class containing info about candidates
        CandidateInformation candidateInformation = new CandidateInformation();
        CandidateProfile current_candidate =  candidateInformation.getCandidateProfile(candidate_id);

        // panel
        setSize(STATS_PANEL_DIMENSION);

        // mean
        this.mean = new JTextArea("The mean percentage for " + current_candidate.candidate_first_name() + " "
                + current_candidate.candidate_last_name() + " is " + mean);
        this.mean.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.mean.setFont(DEFAULT_FONT);

        // standard deviation
        this.standard_deviation = new JTextArea("The standard deviation for " + current_candidate.candidate_first_name() + " "
                + current_candidate.candidate_last_name()  + " is " + standard_deviation);
        this.standard_deviation.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.standard_deviation.setFont(DEFAULT_FONT);

        super.add(this.mean);
        super.add(this.standard_deviation);

        setVisible(true);
    }
}