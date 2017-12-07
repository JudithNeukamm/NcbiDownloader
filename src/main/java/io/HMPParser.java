package main.java.io;

import main.java.Sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HMPParser {
    private List<String> all_urls;
    private int numberOfSamples;
    private int index_url;

    public HMPParser(String filepath) {

        try {
            parseFile( filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void parseFile(String filepath) throws IOException {
        all_urls = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filepath));
        try {
            String line = br.readLine();
            String[] headerline = line.split("\t");


            for(int i = 0; i < headerline.length; i++){
                String colname = headerline[i];
                if(colname.contains("urls")) {
                    index_url = i;
                }
            }

            while ((line = br.readLine()) != null) {
                numberOfSamples++;
                String[] line_splitted = line.split("\t");
                all_urls.add(line_splitted[index_url].split(",")[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

    }



    public List<String> getAll_urls() {
        return all_urls;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }
}

