package PollingPredictions.GUI;
/*
    Adds information related to the table of data
 */


import javax.swing.*;

public class DetailPanel extends JPanel implements GUIConstants  {
    JTextArea likelyCandidate1;
    JTextArea likelyCandidate2;

    DetailPanel(String likelyCandidate1, String likelyCandidate2) {
        // set up panel
        setPreferredSize(DETAIL_PANEL_DIMENSION);

        // first likely candidate
        this.likelyCandidate1 = new JTextArea("Based on a simplistic method the 2024 president elect will be " + likelyCandidate1);
        this.likelyCandidate1.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.likelyCandidate1.setFont(DEFAULT_FONT);

        // second likely candidate
        this.likelyCandidate2 = new JTextArea("Based on a more advanced method the 2024 president elect will be " + likelyCandidate2);
        this.likelyCandidate2.setSize(JTEXTBOX_SIZE, JTEXTBOX_SIZE);
        this.likelyCandidate2.setFont(DEFAULT_FONT);

        super.add(this.likelyCandidate1);
        super.add(this.likelyCandidate2);

        setVisible(true);
    }
}
