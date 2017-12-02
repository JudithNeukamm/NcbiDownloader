package main.java.io;

import main.java.Sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunInfoParser {

    private int index_sample_name;
    private int index_library_layout;
    private int index_run;
    private int index_experiment;
    private int index_bio_project;

    private List<Sample> all_samples = new ArrayList<>();
    private int numberOfSamples =0;


    public RunInfoParser(String filepath){
        try {
            parseFile( filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(String filepath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filepath));
        try {
            String line = br.readLine();
            String[] headerline = line.split("\t");


            for(int i = 0; i < headerline.length; i++){
                String colname = headerline[i];
               if(colname.contains("LibraryLayout")){
                   index_library_layout = i;
               } else if(colname.contains("Sample_Name")){
                   index_sample_name = i;
               } else if(colname.contains("Experiment")){
                   index_experiment = i;
               } else if(colname.contains("BioProject")){
                   index_bio_project = i;
               }else if(colname.contains("Run")){
                   index_run = i;
               }
            }

            while ((line = br.readLine()) != null) {
                numberOfSamples++;
                String[] line_splitted = line.split("\t");
                parseInfo(line_splitted);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

    }

    private void parseInfo(String[] line_splitted) {

        Sample sample = new Sample(
                line_splitted[index_bio_project],
                line_splitted[index_sample_name],
                line_splitted[index_run],
                line_splitted[index_experiment],
                line_splitted[index_library_layout]);

        all_samples.add(sample);
    }

    public List<Sample> getAll_samples() {
        return all_samples;
    }

    public int getNumberOfSamples() {
        return numberOfSamples;
    }
}
