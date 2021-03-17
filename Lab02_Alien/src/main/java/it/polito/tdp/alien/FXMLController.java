package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import it.polito.tdp.alien.AlienDictionary; 
import it.polito.tdp.alien.Word;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary model = new AlienDictionary() ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTraduzione;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	
    	String parole = txtTraduzione.getText();
    	String aliena = null;
    	String traduzione = null;
    	String[] s = null;
    	try {
    		s = parole.split(" ");
    	} catch (PatternSyntaxException ex) {
    		txtResult.setText("ERRORE: Formato non corretto");
    		return ;
    	}
    	if (s.length>1) {
    		aliena = s[0];
        	traduzione = s[1];        	
    	}
    	else {
    		aliena = s[0];
    	}
    	
    	// controlli sull'input
    	
    	
    	
	  	if (!aliena.toLowerCase().matches("[a-z]*") || (traduzione != null && !traduzione.toLowerCase().matches("[a-z]*"))) {
	    		txtResult.setText("ERRORE: Formato testo non corretto.");
	    		return ;
	   	}
    	
    	if (traduzione == null)
    	{
	    	if (model.translateWord(aliena) == null ) {
	    		txtResult.setText("ERRORE: La parola cercata non e' nel dizionario");
	    		return ;
	    	}
	    	else {
	    		txtResult.setText(model.translateWord(aliena));
	    		return ; 
	    	}
    	}
    	else {
    		model.addWord(aliena, traduzione);	    		
    	}

    }
    
    

    @FXML
    void initialize() {
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
