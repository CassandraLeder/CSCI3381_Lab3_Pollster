package PollingPredictions.GUI;
/*
    Adds information related to the table of data
 */


import javax.swing.*;

public class DetailPanel extends JPanel implements GUIConstants  {
    JTextArea details;

    DetailPanel() {
        details = new JTextArea("The data from this table is gathered from a list of polls from ABC's Project 538. " +
                "Only major party nominees are considered to narrow the data. " +
                "Polls are considered regardless of partisan association. These results may not be accurate.");

        details.setFont(DEFAULT_FONT);
        details.setSize(DETAIL_PANEL_DIMENSION);
        details.setLineWrap(true);
        details.setBackground(BACKGROUND_COLOR);

        add(details);
        setBackground(BACKGROUND_COLOR);
        setVisible(true);
    }
}
