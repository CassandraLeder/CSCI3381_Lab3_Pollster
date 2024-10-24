package PollingPredictions;

/*
    This class is shared by PollingPredictions.DataCollector and PollingPredictions.Analyzer classes to share the candidates const
*/

public class CandidateInformation {
    // only real candidates worth looking at are Harris and Trump
    // Kamala Harris   Donald Trump
    protected final static CandidateProfile[] CANDIDATES = {new CandidateProfile("Kamala", "Harris",
            "Tim", "Walz", "DEM", 16661),
            new CandidateProfile("Donald", "Trump",
                    "JD", "Vance", "REP", 16651)};

    protected final static char STANDARD_DELIMITER = ',';
}