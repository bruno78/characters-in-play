
/**
 * Write a description of class CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import edu.duke.*;

public class CharactersInPlay
{
    private ArrayList<String> charactersNames;
    private ArrayList<Integer> countLines;
    
    public CharactersInPlay()
    {
        charactersNames = new ArrayList<String>();
        countLines = new ArrayList<Integer>();
    }
    
    public void update(String person){
        if(!charactersNames.contains(person)){
            charactersNames.add(person);
            countLines.add(1);
        }
        else {
            int index = charactersNames.indexOf(person);
            countLines.set(index, countLines.get(index)+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for (String line : fr.lines()){
            int cutIndex = line.indexOf('.');
            if (cutIndex != -1) {
                String person = line.substring(0, cutIndex);
                update(person);
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        
        for (int k = 0; k < countLines.size(); k++) {
            
            if(countLines.get(k) >= num1 && countLines.get(k) <= num2){
                System.out.println(charactersNames.get(k));
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        for(int k = 0; k < charactersNames.size(); k++){
            if (countLines.get(k) <= 1) continue; 
            
            System.out.println(charactersNames.get(k) + " " + countLines.get(k));
        }
        
        charactersWithNumParts(10, 15);
    }
}
