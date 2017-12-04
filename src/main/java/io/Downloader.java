package main.java.io;

import main.java.Sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Downloader {


    private final String result_folder;
    private BufferedWriter output=null;
    private int numberOfLines;
    private int samplesDonwloaded=0;



    public Downloader(String result_folder, int numberOfLines) {
        this.numberOfLines = numberOfLines;
        // write bash script that can be run afterwards to download all data
        this.result_folder = result_folder;

        try {
            File file = new File(this.result_folder + File.separator + "downloadData.sh");
            output = new BufferedWriter(new FileWriter(file));
            output.write("#!/bin/bash\n");
            output.write("pat=$(pdw)\n");

            output.write("mkdir -p $pat" + File.separator + result_folder + "\n");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void downloadSample(Sample sample) throws IOException {

        if(sample.getLibrarylayout().equals("SINGLE")){
            String f = File.separator + result_folder + File.separator + sample.getBioproject() +
                    File.separator + "SingleEnd" + File.separator + sample.getName();
            output.write("mkdir -p $pat" + File.separator + f + "\n");

            output.write( "cd $pat" + File.separator  + f + "\n");
            output.write( "fastq-dump " + sample.getSRRrun() + "\n");
            samplesDonwloaded++;
            output.write("echo '("+ samplesDonwloaded +"/"+ numberOfLines+") samples downloaded'\n");

        } else if (sample.getLibrarylayout().equals("PAIRED")){
            String f = File.separator + result_folder + File.separator + sample.getBioproject() +
                    File.separator + "PairedEnd" + File.separator + sample.getName();
            output.write("mkdir -p $pat" + File.separator + f + "\n");

            output.write( "cd $pat" + File.separator + f + "\n");
            output.write( "fastq-dump --split-files " + sample.getSRRrun() + "\n");
            output.write( "mv " + sample.getSRRrun() + "_2.* " + sample.getSRRrun() + "_R2.fastq " +"\n");
            samplesDonwloaded++;
            output.write("echo '("+ samplesDonwloaded +"/"+ numberOfLines+") samples downloaded'\n");
        }

    }

    public String getResult_folder() {
        return result_folder;
    }

    public BufferedWriter getOutput() {
        return output;
    }

    public void setOutput(BufferedWriter output) {
        this.output = output;
    }
}
