package TP1.historique;

import TP1.liste_chainees.Cellule;
import TP1.liste_chainees.ListeChainees;

/**
 * Classe représentant un historique de navigation web basé sur une liste chaînée {@link ListeChainees}.
 *
 * @version 1.0
 * @author Alonso Cédric
 * @author Hatoum Jade
 * */
public class Historique {
    /**
     * La liste chaînée utilisée pour représenter l'historique.
     */
    private final ListeChainees<String> historique;

    /**
     * La cellule courante dans la liste, indiquant la position actuelle de l'utilisateur.
     */
    private Cellule<String> courant;

    /**
     * Constructeur par défaut de la classe Historique.
     * Initialise un nouvel historique vide.
     */
    public Historique(){
        this.historique = new ListeChainees<>();
    }

    /**
     * Ajoute une URL à l'historique, la plaçant à la fin de la liste.
     * Si l'historique est vide, la cellule courante est également mise à jour.
     * @param url L'URL à ajouter à l'historique.
     */
    public void ajouter_url(String url){
        if (this.historique.getFirst() == null){
            this.historique.ajouter_fin(url);
            this.courant = this.historique.getFirst();
        }
        else
            this.historique.ajouter_fin(url);
    }

    /**
     * Supprime la dernière URL de l'historique, ajustant la cellule courante si nécessaire.
     */
    public void supprimer_dernier_url(){
        if (this.courant.equals(historique.getLast())){
            this.courant = historique.getLast().getPrecedent();
            this.historique.supprimer_fin();
        }
        else
            this.historique.supprimer_fin();
    }

    /**
     * Avance d'une page dans l'historique, mettant à jour la cellule courante.
     * @throws HistoriqueException Si l'utilisateur est déjà à la fin de l'historique.
     */
    public void avancer() throws HistoriqueException{
        if (this.courant.getSuivant() != null)
            this.courant = this.courant.getSuivant();
        else
            throw new HistoriqueException("Vous ne pouvez pas avancer, Vous etes deja a la fin de l'historique");
    }

    /**
     * Recule d'une page dans l'historique, mettant à jour la cellule courante.
     * @throws HistoriqueException Si l'utilisateur est déjà au début de l'historique.
     */
    public void reculer() throws HistoriqueException{
        if (this.courant.getPrecedent() != null)
            this.courant = this.courant.getPrecedent();
        else
            throw new HistoriqueException("Vous ne pouvez pas reculer, vous etes deja au debut de l'historique");
    }

    /**
     * Renvoie une chaîne de caractères indiquant la position actuelle de l'utilisateur.
     * @return Une chaîne de caractères représentant l'emplacement actuel de l'utilisateur.
     */
    public String whereAmI(){
        return "Vous etes actuellement ici : " + this.courant.getValue();
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'historique complet.
     * @return Une chaîne de caractères représentant l'historique complet.
     */
    public String toString(){
        return historique.toString();
    }
}
