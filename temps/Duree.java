package temps;

public class Duree extends Temps {
    private static String quoi = "Duree";
    public Duree(int h, int m)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(h, m, quoi, false);
    }
    public Duree(String texte)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(texte, quoi, false);
    }
    public void uneHeureDePlus() {
        heure++;
    }
    public void uneHeureDeMoins() {
        if (heure > 0) {
            heure--;
        } else {
            heure = 0;
            minute = 0;
        }
    }
}
