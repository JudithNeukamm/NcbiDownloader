package main.java.io;

import main.java.Sample;

import java.io.File;
import java.io.IOException;

public class Downloader {


    private final String result_folder;

    public Downloader(String result_folder){

        this.result_folder = result_folder;
        // create result folder
        new File(result_folder).mkdirs();

    }

    public void downloadSample(Sample sample) throws IOException {
        String f = result_folder + File.separator + sample.getBioproject() + File.separator + sample.getName();
        new File(f).mkdirs();

        if(sample.getLibrarylayout().equals("SINGLE")){
            //String[] cmd = new String[]{"/bin/sh", "cd f"};
            //Process pr = Runtime.getRuntime().exec(cmd);
            //Process ps=Runtime.getRuntime().exec(new String[]{"cd", f});
            //String[] cmd2 = new String[]{"/bin/sh", "fastq-dump " + sample.getSRRrun()};
            //Process pr2 = Runtime.getRuntime().exec(cmd2);
            //Process ps2=Runtime.getRuntime().exec(new String[]{"fastq-dump", sample.getSRRrun()});


        } else if (sample.getLibrarylayout().equals("PAIRED")){
            //Process ps=Runtime.getRuntime().exec(new String[]{"cd", f});
            //Process ps2=Runtime.getRuntime().exec(new String[]{"fastq-dump","--split-files", sample.getSRRrun()});

        }

    }
}
