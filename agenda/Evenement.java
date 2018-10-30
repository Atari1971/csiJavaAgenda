package agenda;

/*
import temps.Date;
import temps.Heure;
import temps.Duree;
*/
import temps.*;
import java.lang.Comparable;

public class Evenement implements Comparable<Evenement> {
    private String designation;
    private Date date;
    private Heure heure;
    private Duree duree;
    public Evenement(String designation,
                     int jour, int mois, int annee,
                     int heure, int minute)
    throws ExceptionMauvaisJour,
           ExceptionMauvaisMois,
           ExceptionMauvaiseAnnee,
           ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        this.designation = designation;
        date = new Date(jour, mois, annee);
        this.heure = new Heure(heure, minute);
        duree = new Duree(1, 0);
    }
    public Evenement(String nom, String txtDate,
                     String txtHeure, String txtDuree)
    throws ExceptionMauvaisJour,
           ExceptionMauvaisMois,
           ExceptionMauvaiseAnnee,
           ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        designation = nom;
        date = new Date(txtDate);
        heure = new Heure(txtHeure);
        duree = new Duree(txtDuree);
    }
    public String toString() {
        String s = "Le " + date;
        s += " a " + heure;
        s += " (" + duree + ")";
        s += " : " + designation;
        return s;
    }
    public int compareTo(Evenement autre) {
        int diffDates = date.compareTo(autre.date);
        if (diffDates == 0) {
            int diffHeures = heure.compareTo(autre.heure);
            if (diffHeures == 0)
                return duree.compareTo(autre.duree);
            else
                return diffHeures;
        } else
            return diffDates;
    }
}
