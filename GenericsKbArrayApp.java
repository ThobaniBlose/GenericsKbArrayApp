import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

public class GenericsKbArrayApp{
    private static final int SizeMax = 10000000; // Maximum number of terms and statements
    private static Statement[] knowledgeBase = new Statement[SizeMax];
    private static int size = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;
    }

    do {
        System.out.println("Choose an action from the menu:");
        System.out.println("1. Load a knowledge base from a file");
        System.out.println("2. Add a new statement to the knowledge base");
        System.out.println("3. Search for an item in the knowledge base term");
        System.out.println("4. Search for an item in the knowledge base by term and sentence");
        System.out.println("5. Quit");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice){
            case 1:
                loadKnowledgeBase();
                break;
            case 2:
                addStatement();
                break;
            case 3:
                searchByTerm();
                break;
            case 4:
                searchByTermAndSentence();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.") // So that we will not get an error.

        }
    } while (choice != 5);

    scanner.close();
}

private static void loadKnowledgeBase() {
    try (BufferedReader buffer = new BufferedReader(new FileReader(fileName:"GenericsKB.txt"))){
        String line;

        while ((line = buffer.readLine()) != null && size < SizeMax){
            String[] parts = line.split(regex:"\t");
            knowledgeBase[size++] = new Statement(parts[0], parts[1], Double.parseDouble(parts[2]));
        }
        System.out.println("Knowledge base loaded successfully.");

    } catch(IOException e){
        System.out.println("Error loading knowldge base: " + e.getMessage());
    }
}
