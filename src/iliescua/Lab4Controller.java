/*
* CS2852
* Fall 2018
* Lab 4 - Lab4Controller Class
* Created: 9/29/2018
*/
package iliescua;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * This class is the controller that tells the GUI
 * how to properly operate
 */
public class Lab4Controller {
    private static FileChooser fileChooser = new FileChooser();
    private FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("TXT", "*.txt");
    private FileChooser.ExtensionFilter csv = new FileChooser.ExtensionFilter("CSV", "*.csv");
    private File selectedFile;
    private IndexArrayStrategy iAStrat = new IndexArrayStrategy();
    private IndexLinkedStrategy iLStrat = new IndexLinkedStrategy();
    private ForEachArrayStrategy fEAStrat = new ForEachArrayStrategy();
    private ForEachLinkedStrategy fELStrat = new ForEachLinkedStrategy();
    private String totalTime;

    @FXML
    RadioMenuItem indexArray;
    @FXML
    RadioMenuItem indexLinked;
    @FXML
    RadioMenuItem forEachArray;
    @FXML
    RadioMenuItem forEachLinked;
    @FXML
    TextField searchField;
    @FXML
    Label lbltotalTime;
    @FXML
    Label lblMatches;
    @FXML
    TextArea txtAreaResults;

    @FXML
    private void openFile() {
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(txt, csv);
        selectedFile = fileChooser.showOpenDialog(null);
        iAStrat.initialize(selectedFile);
        iLStrat.initialize(selectedFile);
        fEAStrat.initialize(selectedFile);
        fELStrat.initialize(selectedFile);
    }

    @FXML
    private void enteredWord() {
        StringBuilder sb = new StringBuilder();
        if (indexArray.isSelected()) {
            iAStrat.allThatBeginWith(searchField.getText());
            for (int i = 0; i < iAStrat.getNewList().size(); i++) {
                sb.append(iAStrat.getNewList().get(i) + "\n");
            }
            lblMatches.setText("Matches Found: " + Integer.toString(iAStrat.getNewList().size()));
            lbltotalTime.setText("Time: " + totalTimeCalc(iAStrat.getLastOperationTime()));
        } else if (indexLinked.isSelected()) {
            iLStrat.allThatBeginWith(searchField.getText());
            for (int i = 0; i < iLStrat.getNewList().size(); i++) {
                sb.append(iLStrat.getNewList().get(i) + "\n");
            }
            lblMatches.setText("Matches Found: " + Integer.toString(iLStrat.getNewList().size()));
            lbltotalTime.setText("Time: " + totalTimeCalc(iLStrat.getLastOperationTime()));
        } else if (forEachArray.isSelected()) {
            fEAStrat.allThatBeginWith(searchField.getText());
            for (int i = 0; i < fEAStrat.getNewList().size(); i++) {
                sb.append(fEAStrat.getNewList().get(i) + "\n");
            }
            lblMatches.setText("Matches Found: " + Integer.toString(fEAStrat.getNewList().size()));
            lbltotalTime.setText("Time: " + totalTimeCalc(fEAStrat.getLastOperationTime()));
        } else if (forEachLinked.isSelected()) {
            fELStrat.allThatBeginWith(searchField.getText());
            for (int i = 0; i < fELStrat.getNewList().size(); i++) {
                sb.append(fELStrat.getNewList().get(i) + "\n");
            }
            lblMatches.setText("Matches Found: " + Integer.toString(fELStrat.getNewList().size()));
            lbltotalTime.setText("Time: " + totalTimeCalc(fELStrat.getLastOperationTime()));
        }
        txtAreaResults.setText(sb.toString());
    }

    private String totalTimeCalc(Long time) {
        if (TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) > 1) {
            totalTime = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " milliseconds";
        } else if (TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS) > 1) {
            totalTime = TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS) + " microseconds";
        } else {
            totalTime = time + " nanoseconds";
        }
        return totalTime;
    }
}