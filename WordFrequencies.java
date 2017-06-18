
/**
 * Write a description of class WordFrequencies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;

public class WordFrequencies
{

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    

    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();

        for (String word : fr.words()){
            
            String lowerCaseWord = word.toLowerCase();
            if (!myWords.contains(lowerCaseWord)){
                myWords.add(lowerCaseWord);
                myFreqs.add(1);
            } 
            else {
                int index = myWords.indexOf(lowerCaseWord);
                myFreqs.set(index, myFreqs.get(index) + 1);
            }
            
        }
        
    }
    
    public int findIndexOfMax(){
        int idxMax = 0;
        int maxValue = 0;
        for (int k = 0; k < myFreqs.size(); k++){
            if(myFreqs.get(k) <= maxValue  && k > idxMax ) continue;
            maxValue = myFreqs.get(k); idxMax = k;
        }
        return idxMax;
    }
    
    public void tester() {
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        int count = 0;
        for (int k = 0; k < myWords.size(); k++){
            System.out.println(myFreqs.get(k) + " " + myWords.get(k));
            count ++;
        }
        System.out.println("The word that occurs the most often and its count are: " +
                               myWords.get(findIndexOfMax()) + " " + myFreqs.get(findIndexOfMax()));
        System.out.println("Total of unique words: " + count);
    }
}
