package PollingPredictions;

/*
    This class will perform statistical calculations and analyze data about candidates
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Analyzer extends CandidateInformation implements PollStructure {
    private String likely_candidate;
    private Map<String, Integer> candidate_points;
    private int candidate_average;
    private int standard_deviation;

    Analyzer() {
        likely_candidate = "";
        candidate_points = new HashMap<>();
        candidate_average = 0;
        standard_deviation = 0;
    }

    public void setLikelyCandidate(String likely_candidate) { this.likely_candidate = likely_candidate; }
    public void setCandidatePoints(String candidate_last_name, int num) {
        boolean name_check_flag = true;

        for (CandidateProfile candidate : CANDIDATES) {
            if (candidate.candidate_last_name().equalsIgnoreCase(candidate_last_name)) {
                name_check_flag = false;
                break;
            }
        }

        if (!name_check_flag)
            throw new IllegalArgumentException("Error: candidate is not an option");

        if (num < 0)
            throw new IllegalArgumentException("Error: number of points must be a positive numbers");

        this.candidate_points.putIfAbsent(candidate_last_name, num);
    }
    public void setCandidateAverage(int candidate_average) { this.candidate_average = candidate_average; }
    public void setStandardDeviation(int standard_deviation) { this.standard_deviation = standard_deviation; }


    // getters/calculators
    public String getLikelyCandidate() { return likely_candidate; }
    public Map<String, Integer> getCandidatePoints() { return candidate_points; }
    public int getCandidateAverage() { return candidate_average; }
    public int getStandardDeviation() { return standard_deviation; }

    // find average of the percentage that the candidate has
    public int computeAverage(ArrayList<Object[]> data) {
        int sum = 0;
        int count = 0;

        for (Object[] lines : data) {
            for (Object line : lines) {
                if (line instanceof String line_str) {
                    String[] fields = line_str.split(STANDARD_DELIMITER);

                    try {
                        sum += Double.parseDouble(fields[final_data_headers.get("percentage")]);
                        ++count;
                    } catch (NumberFormatException n) {
                        System.out.println(n.getMessage());
                    }
                }
            }
        }

        if (count == 0)
            throw new IllegalArgumentException("Error: count must not be zero.");
        else
            setCandidateAverage(sum / count);

        return(getCandidateAverage());
    }

    public int computeStandardDeviation() {
        // add work here...
        return 0;
    }

    public String predictWinner(ArrayList<String> data) {

        int[] points = new int[CANDIDATES.length];
        int i = 0;

        // initialize candidate points
        for (CandidateProfile candidate : CANDIDATES) {
            points[i] = 0;
            ++i;
            setCandidatePoints(candidate.candidate_last_name(), 0);
        }

        for (CandidateProfile candidate : CANDIDATES) {
            for (String field : data) {
                String[] fields = field.split(String.valueOf(STANDARD_DELIMITER));

                // [1] is candidate choice
                if (fields[1].equalsIgnoreCase(candidate.candidate_last_name())) {
                    setCandidatePoints(candidate.candidate_last_name(), points[i]);
                }
            }
        }
        String winner = "";
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> set : getCandidatePoints().entrySet()) {
            if (set.getValue() > max) {
                max = set.getValue();
                winner = set.getKey();
            }
        }

        if (winner.isEmpty())
            throw new IllegalArgumentException("Error: no winner could be found.");

        return winner;
    }
}
