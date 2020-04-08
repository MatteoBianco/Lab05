package it.polito.tdp.anagrammi;

	import java.util.List;
	import it.polito.tdp.anagrammi.model.Model;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class FXMLController {

		private Model model;
		
	    @FXML
	    private Button btnCalculate;
	    
	    @FXML
	    private CheckBox checkBox;

	    @FXML
	    private TextField txtWord;

	    @FXML
	    private TextArea txtCorrect;

	    @FXML
	    private TextArea txtWrong;

	    @FXML
	    private Button btnReset;

	    @FXML
	    void calculate(ActionEvent event) {
	    	txtCorrect.clear();
	    	txtWrong.clear();
	    	String parola = txtWord.getText();
	    	if(parola.equals("")) {
	    		txtWrong.setText("Inserire una parola da anagrammare!\n");
	    		return;
	    	}
	    	if(!parola.matches("[a-zA-Z]*")) {
	    		txtWrong.setText("Attenzione! Inserire solo una parola, e senza caratteri speciali!\n");
	    		return;
	    	}
	    	if(parola.length() > 8 && !checkBox.isSelected()) {
	    		txtWrong.setText("Attenzione: per parole di lunghezza maggiore di 8 caratteri, "
	    				+ "il calcolo degli anagrammi può essere molto lento e portare ad un blocco "
	    				+ "del programma. Se si vuole ugualmente procedere, spuntare la checkbox "
	    				+ "posta a fianco del bottone 'Calcola anagrammi' e rilanciare il calcolo\n");
	    		return;
	    	}
	    	List<String> anagrammi = model.anagramma(parola);
	    	for(String a : anagrammi) {
	    		if(model.isCorrect(a))
	    			txtCorrect.appendText(a + "\n");
	    		else txtWrong.appendText(a + "\n");
	    	}
	    }

	    @FXML
	    void reset(ActionEvent event) {
	    	txtWord.clear();
	    	txtCorrect.clear();
	    	txtWrong.clear();
	    }
	    
	    public void setModel(Model model) {
	    	
	    	this.model = model;
	    }

	}