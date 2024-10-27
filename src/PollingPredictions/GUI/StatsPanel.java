package PollingPredictions.GUI;
/*
    Panel that displays stats, mean and std deviation, about presidential election candidates
 */

import javax.swing.*;
import PollingPredictions.CandidateProfile;
import PollingPredictions.CandidateInformation;

public class StatsPanel extends JPanel implements GUIConstants {
    JTextField mean;
    JTextField standard_deviation;
    JTextField likelyCandidate1;
    JTextField likelyCandidate2;


    StatsPanel(int candidate_id, double mean, double standard_deviation, String likelyCandidate1, String likelyCandidate2) {
        setSize(STATS_PANEL_DIMENSION);

        this.mean.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.mean.setFont(DEFAULT_FONT);

        this.standard_deviation.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.standard_deviation.setFont(DEFAULT_FONT);

        this.likelyCandidate1.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.likelyCandidate2.setFont(DEFAULT_FONT);

        // put text in jtextboxes
        addStats(candidate_id, mean, standard_deviation);
        addLikelyWinners(likelyCandidate1, likelyCandidate2);

        super.add(this.mean);
        super.add(this.standard_deviation);
        super.add(this.likelyCandidate1);
        super.add(this.likelyCandidate2);

        setVisible(true);
    }


    private void addStats(int candidate_id, double mean, double standard_deviation) {
        // this is the class containing info about candidates
        CandidateInformation candidateInformation = new CandidateInformation();
        CandidateProfile current_candidate =  candidateInformation.getCandidateProfile(candidate_id);

        this.mean.setText("The mean percentage for " + current_candidate.candidate_first_name() + " "
                + current_candidate.candidate_last_name() + " is " + mean);
        this.standard_deviation.setText("The standard deviation for " + current_candidate.candidate_first_name() + " "
                + current_candidate.candidate_last_name()  + " is " + standard_deviation);
    }

    // there's two methods for determining the likely winner
    private void addLikelyWinners(String likelyCandidate1, String likelyCandidate2) {
        this.likelyCandidate1.setText("Based on a simplistic method the 2024 president elect will be " + likelyCandidate1);
        this.likelyCandidate2.setText("Based on a more advanced method the 2024 president elect will be " + likelyCandidate2);
    }
}