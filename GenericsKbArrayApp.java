import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOExemption;
import java.util.Scanner;

class Statement {
    private String term;
    private String sentence;
    private double conScore;

    public Statement(String term, String sentence, double conScore){
        this.term = term;
        this.sentence = sentence;
        this.conScore = conScore;

    }
    public String getTerm(){
        return term;
    }
    public String getSentence(){
        return sentence;
    }
    public double getConfidenceScore(){
        return conScore;
    }
    public void setSentence(String sentence){
        this.sentence = sentence;
    }
    public void setConfidenceScore(double conScore){
        this.conScore = conScore;
    }
}

