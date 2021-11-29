package fr.ul.kelberp.algoIA;

import fr.ul.kelberp.algoIA.jeu.Jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {

    private Jeu j;

    public Partie() {
        j = new Jeu();
    }

    public void lancerPartie(){
        System.out.println(
                        "\t[1] Changer qui commence à jouer (actuellement " + j.getNomJoueur() + ")\n" +
                        "\t[2] Changer la profondeur (actuellement " + j.getProfondeur() + ")\n" +
                        "\t[3] Commencer à jouer !\n"
        );
        System.out.print("Votre choix : ");
        Scanner sc = new Scanner(System.in);
        try {
            int choix = sc.nextInt();
            switch (choix) {
                case 1 -> {
                    j.changerJoueurCourant();
                    this.lancerPartie();
                }
                case 2 -> {
                    j.changerProfondeur();
                    this.lancerPartie();
                }
                case 3 -> j.debut();
                default -> {
                    System.out.println("Veuillez rentrer un choix valide !");
                    this.lancerPartie();
                }
            }
        } catch (InputMismatchException inputMismatchException){
            System.out.println("Veuillez rentrer une valeur valide !");
            this.lancerPartie();
        }
    }
        
    public Jeu getJeu() {
    	return this.j;
    }
}
