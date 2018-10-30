import agenda.*;
import outils.*;

abstract class GestAgenda {
    private static void ajouterEvenement(Agenda a) {
        String nom, txtDate, txtHeure, txtDuree;
        System.out.println("Designation ?");
        nom = IN.getString();
        System.out.println("Date ?");
        txtDate = INTemps.getTexteDate();
        System.out.println("Heure ?");
        txtHeure = INTemps.getTexteHeure();
        System.out.println("Durée ?");
        txtDuree = INTemps.getTexteDuree();
        try {
            a.ajouter(new Evenement(nom, txtDate, txtHeure, txtDuree));
            a.trier();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String arg[]) {
        char choix;
        Agenda agenda = new Agenda();
        do {
            agenda.afficher();
            System.out.print("a)jouter q)uitter ? ");
            choix = IN.getChar();
            switch(choix) {
                case 'a' : ajouterEvenement(agenda); break;
            }
        } while (choix != 'q');
    }
}
