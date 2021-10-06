package fr.ul.kelberp.algoIA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {

    /**
     * 0 = HUMAIN
     * 1 = ALGO
     */
    private int joueurCourant;
    private int profondeur;

    private static final String NOM_JOUEUR = "HUMAIN";
    private static final String NOM_ALGO = "ALGO";

    public Partie() {
        this.joueurCourant = 0;
        this.profondeur = 4;
    }

    /**
     * @return String : nom du joueurCourant
     */
    private String getNomJoueur(){
        return switch (joueurCourant) {
            case 0 -> NOM_JOUEUR;
            case 1 -> NOM_ALGO;
            default -> null;
        };
    }

    public void lancerPartie(){
        System.out.println(
                        "\t[1] Changer qui commence à jouer (actuellement " + this.getNomJoueur() + ")\n" +
                        "\t[2] Changer la profondeur (actuellement " + this.getProfondeur() + ")\n" +
                        "\t[3] Commencer à jouer !\n"
        );
        System.out.print("Votre choix : ");
        Scanner sc = new Scanner(System.in);
        try {

            int choix = sc.nextInt();
            switch (choix) {
                case 1 -> {
                    this.changerJoueur();
                    this.lancerPartie();
                }
                case 2 -> {
                    this.changerProfondeur();
                    this.lancerPartie();
                }
                case 3 -> {
                    System.out.println("que le jeu commence");
                }
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

    private void changerProfondeur() {
        Scanner scProf = new Scanner(System.in);
        System.out.print("Veuillez entrer la nouvelle profondeur d'exploration (>0): ");
        try{
            int prof = scProf.nextInt();
            if (prof <= 0){
                throw new InputMismatchException();
            } else {
                this.profondeur = prof;
                System.out.println("Pouf ! Profondeur changée !\n");
            }
        } catch (InputMismatchException inputMismatchException){
            System.out.println("Veuillez rentrer une valeur valide !");
            this.changerProfondeur();
        }
    }

    private void changerJoueur() {
        this.joueurCourant = Math.abs(this.joueurCourant-1);
        System.out.println("Pouf ! Joueur changé !\n");
    }

    private int getProfondeur() {
        return profondeur;
    }
}
