package temps;

public class Heure extends Temps {
    private static String quoi = "Heure";
    public Heure(int h, int m)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(h, m, quoi, true);
    }
    public Heure(String texte)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        super(texte, quoi, true);
    }
    public void uneHeureDePlus() {
        if (heure < 23) {
            heure++;
        } else {
            heure = 0;
        }
    }
    public void uneHeureDeMoins() {
        if (heure > 0) {
            heure--;
        } else {
            heure = 23;
        }
    }
}
