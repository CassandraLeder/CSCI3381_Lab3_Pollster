package PollingPredictions;

/*
    Poll-Machine Project
    Created by Cassandra Leder on 23-10-24

    This project will receive polling info from project 538, create data/charts based on data,
    create predictions from this information.

*/

public class Main {
    // location of text file containing list of urls
    final static String URLS = "src/urls.txt";


    public static void main(String[] args) {
        DataCollector dataCollector = new DataCollector(URLS);
        dataCollector.collectData();
        Analyzer analyzer = new Analyzer();

        System.out.println(analyzer.computeAverage(dataCollector.getData()));
    }
}