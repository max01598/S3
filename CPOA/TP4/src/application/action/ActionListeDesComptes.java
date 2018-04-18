package application.action;

import banque.AgenceBancaire;

public class ActionListeDesComptes implements Action{
	
	private String message;
	public ActionListeDesComptes() {
		message="Liste des comptes";
	}
	@Override
	public String actionMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		ag.afficher();
	}

}
