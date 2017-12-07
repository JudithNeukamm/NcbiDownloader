package main.java;

import main.java.io.Downloader;
import main.java.io.HMPParser;
import main.java.io.RunInfoParser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        if(args[0].equals("ncbi")){
            RunInfoParser runInfoParser = new RunInfoParser(args[1]);

            List<Sample> samples = runInfoParser.getAll_samples();

            Downloader downloader = new Downloader(args[2], runInfoParser.getNumberOfSamples());
            for(Sample s : samples){
                downloader.writeDownloadScriptNCBI(s);
            }

            downloader.getOutput().close();
        } else if(args[0].equals("hmp")){

            HMPParser hmpParser = new HMPParser(args[1]);

            List<String> samples = hmpParser.getAll_urls();

            Downloader downloader = new Downloader(args[2], hmpParser.getNumberOfSamples());
            for(String s : samples){
                downloader.writeDownloadScriptHMP(s);
            }

            downloader.getOutput().close();

        }



    }
}
