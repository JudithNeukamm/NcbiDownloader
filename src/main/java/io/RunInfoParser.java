package main.java.io;

import main.java.Sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunInfoParser {

    private int index_sample_name;
    private int index_library_layout;
    private int index_run;
    private int index_experiment;
    private int index_bio_project;

    private List<Sample> all_samples = new ArrayList<>();


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
            List<String> header_list = Arrays.asList(headerline);
            index_library_layout = header_list.indexOf("LibraryLayout_s");
            index_sample_name = header_list.indexOf("Sample_Name_s");
            index_experiment = header_list.indexOf("Experiment_s");
            index_run = header_list.indexOf("Run_s");
            index_bio_project = header_list.indexOf("BioProject_s");

            while ((line = br.readLine()) != null) {
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
}
