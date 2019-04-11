/*
* CS2852
* Fall 2018
* Lab 4 - ForEachArrayStrategy Class
* Created: 9/29/2018
*/
package iliescua;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is the third strategy that uses a forEach and an ArrayList
 */
public class ForEachArrayStrategy implements AutoCompleter {
    private Scanner in;
    private ArrayList<String> wordList = new ArrayList();
    private ArrayList<String> newList = new ArrayList();
    private long start;
    private long end;

    /**
     * This method is used to load in the file and add the words to the ArrayList
     * @param file the file the user selects
     */
    @Override
    public void initialize(File file){
        try{
            in = new Scanner(file);
        } catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("IOException");
            alert.setContentText("Error with the file, reload it");
            alert.showAndWait();
        }
        if(file.getName().endsWith(".txt")){
            while(in.hasNext()){
                wordList.add(in.nextLine());
            }
        } else if(file.getName().endsWith(".csv")){
            while(in.hasNext()){
                String[] lineIn = in.nextLine().split(",");
                wordList.add(lineIn[1] + ": " + lineIn[0]);
            }
        }
    }

    /**
     * This method is used to determine what dictionary words match with user input
     * @param prefix user input
     */
    @Override
    public void allThatBeginWith(String prefix){
        start = System.nanoTime();
        newList.clear();
        for(String word : wordList){
            if(word.startsWith(prefix)){
                newList.add(word);
            }
        }
        end = System.nanoTime();
    }

    /**
     * This method is used to calculate the time it takes to find the matches
     * @return returns the total time spent to complete the operation
     */
    @Override
    public Long getLastOperationTime(){
        return end - start;
    }

    public ArrayList<String> getNewList() {
        return newList;
    }
}