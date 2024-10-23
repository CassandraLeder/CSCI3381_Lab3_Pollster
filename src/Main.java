/*
    Poll-Machine Project
    Created by Cassandra Leder on 23-10-24

    This project will receive polling info from project 538, create data/charts based on data,
    create predictions from this information.

*/

public class Main {
    // location of text file containing list of urls
    final static String URLS = "urls.txt";


    public static void main(String[] args) {
        DataCollector dataCollector = new DataCollector(URLS);
    }
}