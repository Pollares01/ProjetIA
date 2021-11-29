package fr.ul.algoIA.arbre;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ul.kelberp.algoIA.jeu.Case;
import fr.ul.kelberp.algoIA.jeu.Jeu;

public class Arbre {
	
	private Noeud racine;
	private Jeu partie;
	
	public Arbre(Noeud n, Jeu j) {
		this.partie = j;
		this.racine = new Noeud(null,j.getPlateau());
	}
	
	
	public void chargementSolutions() {
		int profondeur = this.partie.getProfondeur();
		profondeur = 7;
		int limite = 0;
		int nbGrilleProfondeur = 0;
		ArrayList<Noeud> listeTmp = new ArrayList();
		HashMap<Noeud,ArrayList<Noeud>> successeurs = new HashMap();
		HashMap<Noeud,ArrayList<Noeud>> mapTmp		= new HashMap();
		for(int j=0; j<7; j++) {
			ArrayList<ArrayList<Case>> grilleTmp = new ArrayList();
			this.recupererGrilleNoeud(grilleTmp,this.racine);
					
			for (int i = 5; i >= 0;i--) {
				if(!(grilleTmp.get(i).get(j).isRemplie())){
					grilleTmp.get(i).get(j).setJeton("x");
					grilleTmp.get(i).get(j).setRemplie(true);
					break;
				}
			}
			this.racine.ajouterSuccesseur(new Noeud(this.racine,grilleTmp));
			this.afficherGrille(grilleTmp);
			
			nbGrilleProfondeur++;
		}
		limite++;
		System.out.println(nbGrilleProfondeur);
		nbGrilleProfondeur = 0;
		for(Noeud n : this.racine.getListeSuccesseurs()) {
			successeurs.put(n,n.getListeSuccesseurs());
		}
		
		
		while(limite<=profondeur) {
			System.out.println("Pronfondeur = " + limite);
			for(Noeud n : successeurs.keySet()) {
				listeTmp = successeurs.get(n);
				if(listeTmp.isEmpty()) {
					for(int j=0; j<7; j++) {
						ArrayList<ArrayList<Case>> grilleTmp = new ArrayList();
						this.recupererGrilleNoeud(grilleTmp,n);	
						for (int i = 5; i >= 0;i--) {
							if(!(grilleTmp.get(i).get(j).isRemplie())){
								if(limite%2 !=0) {
									grilleTmp.get(i).get(j).setJeton("o");
								}else {
									grilleTmp.get(i).get(j).setJeton("x");
								}
								grilleTmp.get(i).get(j).setRemplie(true);
								break;
							}
						}
						n.ajouterSuccesseur(new Noeud(n,grilleTmp));
						this.afficherGrille(grilleTmp);
						nbGrilleProfondeur++;
					}
					for(Noeud n2 : n.getListeSuccesseurs()) {
						mapTmp.put(n2,n2.getListeSuccesseurs());
					}
					if(limite == profondeur) {
						break;
					}
				}else {
					
				}
			}
			System.out.println(nbGrilleProfondeur);
			limite++;
			successeurs.putAll(mapTmp);
			
		}
		System.out.println("FIN " + profondeur);
		
	}
	
	
	private void recupererGrilleNoeud(ArrayList<ArrayList<Case>> g,Noeud n) {
		for (int a = 0; a<6; a++) {
            ArrayList<Case> tmpList = new ArrayList<>();
            for (int b = 0; b < 7; b++) {
                tmpList.add(new Case());
                if(n.getGrille().get(a).get(b).isRemplie()) {
                	tmpList.set(b,n.getGrille().get(a).get(b));
                }
            }
            g.add(tmpList);
        }
	}
	
	private void afficherGrille(ArrayList<ArrayList<Case>> g) {
		System.out.println();
		for (int a = 0; a<6; a++) {
			System.out.println(g.get(a));
		}
		System.out.println();
	}
	
}
