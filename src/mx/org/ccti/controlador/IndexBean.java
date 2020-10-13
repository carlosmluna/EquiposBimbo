package mx.org.ccti.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class IndexBean {
	private String outcome = "index";
	private String userInput = "";
	 
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}	
	public String submit(){
		this.userInput = "The user has entered \""+this.userInput+" \"";
		return "";
	}	
}
