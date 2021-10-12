package fr.ul.kelberp.algoIA.jeu;

public class Case {


    /**
     * État de remplissage de la case
     */
    private boolean remplie;

    private String jeton;

    public Case() {
        this.remplie = false;
    }

    public void setRemplie(boolean remplie) {
        this.remplie = remplie;
    }

    public String getJeton() {
        return jeton;
    }

    /**
     * Vérification de si la case est remplie ou non
     * @return boolean
     */
    public boolean isRemplie() {
        return remplie;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public String formatIsRemplie(){
//        return this.isRemplie()?"x":" ";
        return this.isRemplie()?this.getJeton():" ";
    }

    /**
     * Met l'attribut remplie à true
     * @return boolean
     * @param joueurCourant
     */
    public boolean remplir(int joueurCourant){
        if(this.remplie){
            return false;
        }
        this.remplie = true;
        if (joueurCourant==0){
            this.jeton = "x";
        } else {
            this.jeton = "o";
        }
        return true;
    }

    @Override
    public String toString() {
        return "| " + this.formatIsRemplie() + " |";
    }
}

