package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SpellCheckerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField time;

    @FXML
    private TextArea input;
    
    @FXML
    private ChoiceBox<String> chooselng;

    @FXML
    private Button spellCheck;

    @FXML
    private TextArea output;

    @FXML
    private Button clearText;

    @FXML
    private TextField recap;

    @FXML
    void doClearText(ActionEvent event) {
    	output.clear();
    	input.clear();
    }
   
    
    Dictionary dict = new Dictionary();
    List<String> inputTextList = new ArrayList<String>();
    
    @FXML
    void doSpellCheck(ActionEvent event) {
    	String text = input.getText().toLowerCase();
    	text = text.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	StringTokenizer st = new StringTokenizer(text, " ");
    	while (st.hasMoreTokens()) {
    		inputTextList.add(st.nextToken());
    	}
    	output.setText(dict.spellCheckToString(inputTextList));
    }
    
    @FXML
    void chooseLanguage(MouseEvent event) {
    	String choice = chooselng.getValue().toString();
    	dict.loadDictionary(choice+".txt");
    }

    @FXML
    void initialize() {
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert spellCheck != null : "fx:id=\"spellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert clearText != null : "fx:id=\"clearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert recap != null : "fx:id=\"recap\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert chooselng != null : "fx:id=\"chooselng\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        ObservableList<String> availableChoices = FXCollections.observableArrayList("Italian", "English"); 
        chooselng.setItems(availableChoices);
        chooselng.getSelectionModel().getSelectedItem();
        
    }
}
