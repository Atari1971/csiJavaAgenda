package agenda;

import java.util.LinkedList;
import java.util.Collections;

public class Agenda {
    private LinkedList<Evenement> contenu;
    public void trier() {
        Collections.sort(contenu);
    }
    public Agenda() {
        contenu = new LinkedList<Evenement>();
    }
    public boolean estVide() {
        return contenu.isEmpty();
    }
    public int taille() {
        return contenu.size();
    }
    public void ajouter(Evenement e) {
        contenu.add(e);
    }
    public void afficher() {
        int num = 1;
        for(Evenement evt : contenu) {
            System.out.println(num + ") " + evt);
            num++;
        }
    }
}
