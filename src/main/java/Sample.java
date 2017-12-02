package main.java;

public class Sample {

    private final String name;
    private final String SRRrun;
    private final String experiment;
    private final String librarylayout;
    private final String bioproject;

    public Sample(String bioproject, String name, String run, String experiment, String librarylayout){

        this.bioproject = bioproject;
        this.name = name;
        this.SRRrun = run;
        this.experiment = experiment;
        this.librarylayout = librarylayout;
    }

    public String getName() {
        return name;
    }

    public String getSRRrun() {
        return SRRrun;
    }

    public String getExperiment() {
        return experiment;
    }

    public String getLibrarylayout() {
        return librarylayout;
    }

    public String getBioproject() {
        return bioproject;
    }
}
