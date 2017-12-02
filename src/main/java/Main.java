package main.java;

import main.java.io.Downloader;
import main.java.io.RunInfoParser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        RunInfoParser runInfoParser = new RunInfoParser(args[0]);

        List<Sample> samples = runInfoParser.getAll_samples();

        Downloader downloader = new Downloader(args[1], runInfoParser.getNumberOfSamples());
        for(Sample s : samples){
            downloader.downloadSample(s);
        }

        downloader.getOutput().close();

    }
}
