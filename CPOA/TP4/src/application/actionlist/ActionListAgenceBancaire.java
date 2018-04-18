package application.actionlist;

import java.util.ArrayList;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire implements ActionList{
	
	
	private String mess;
	private ArrayList<Action> listeAct;
	
	public ActionListAgenceBancaire() {
		this.mess="";
		this.listeAct = new ArrayList<Action>();
	}
	@Override
	public String actionMessage() {
		// TODO Auto-generated method stub
		return mess;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		String choix="1";
		while(choix!="0") {
			System.out.println("--");
			System.out.println("	Agence " + ag.getNomAgence() + " de" + ag.getLocAgence());
			System.out.println("--");
			int taille = this.listeAct.size();
			for(int i = 1;i<=taille;i++) {
				this.listeAct.get(i).actionMessage();
			}
			Scanner lect;
			lect = new Scanner ( System.in );
			System.out.println("Choix");
			choix=lect.next();
			int choixI=Integer.parseInt(choix);
			this.listeAct.get(choixI).execute(ag);
		}
	}

	@Override
	public String listTitle() {
		return mess;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.listeAct.size();
	}

	@Override
	public boolean addAction(Action ac) {
		if(this.listeAct.contains(ac)==false) {
			return false;
		}else {
			this.listeAct.add(ac);
			return true;
		}
	}
	
}
