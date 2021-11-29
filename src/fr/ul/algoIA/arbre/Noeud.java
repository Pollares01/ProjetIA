package fr.ul.algoIA.arbre;

import java.util.ArrayList;

import fr.ul.kelberp.algoIA.jeu.Case;
import fr.ul.kelberp.algoIA.jeu.Jeu;

public class Noeud {
	
	private ArrayList<Noeud> listeSuccesseurs;
	private Noeud NoeudParent;
	private ArrayList<ArrayList<Case>> grille;
	
	public Noeud(Noeud parent) {
		this.listeSuccesseurs = new ArrayList<Noeud>();
		this.NoeudParent = parent;
		this.grille = new ArrayList();
	}
	
	public Noeud(Noeud parent, ArrayList<ArrayList<Case>> g) {
		this.listeSuccesseurs = new ArrayList();
		this.NoeudParent = parent;
		this.grille = g;
	}
	
	public void ajouterSuccesseur(Noeud n) {
		this.listeSuccesseurs.add(n);
	}
	
	public void setListeSuccesseurs(ArrayList<Noeud> liste) {
		this.listeSuccesseurs = liste;
	}
	
	public void setNoeudParent(Noeud n) {
		this.NoeudParent = n;
	}
	
	public void setGrille(ArrayList<ArrayList<Case>> g) {
		this.grille = g;
	}
	
	public ArrayList<ArrayList<Case>> getGrilleNoeudParent(){
		return this.NoeudParent.getGrille();
	}
	
	public ArrayList<Noeud> getListeSuccesseurs(){
		return this.listeSuccesseurs;
	}
	
	public Noeud getParent() {
		return this.NoeudParent;
	}
	
	public ArrayList<ArrayList<Case>> getGrille(){
		return this.grille;
	}
	
}
