package fr.ul.kelberp.algoIA;

import fr.ul.algoIA.arbre.Arbre;
import fr.ul.algoIA.arbre.Noeud;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================  BIENVENUE SUR LE JEU DE PUISSANCE 4  ================= \n");
        Partie p = new Partie();
        p.lancerPartie();
//        construction de l'arbre
//        Noeud n = new Noeud(null);
//        Arbre a = new Arbre(n,p.getJeu());
//        a.chargementSolutions();
    }
}
