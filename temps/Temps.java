package temps;

import java.util.StringTokenizer;
import java.lang.Integer;
import java.lang.Comparable;

abstract class Temps implements Comparable<Temps> {
    protected int heure;
    protected int minute;
    private void initialise(int h, int m, String classe, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        if (m < 0 || m > 59)
            throw new ExceptionMauvaiseValeurPourMinute("Valeur incorrecte de minute (" + m + ") pour une instance de " + classe);
        boolean heureIncorrecte = (borneSupHeure) ? (h < 0 || h > 23) : (h < 0);
        if (heureIncorrecte)
            throw new ExceptionMauvaiseValeurPourHeure("Valeur incorrecte de heure (" + h + ") pour une instance de " + classe);
        heure = h;
        minute = m;
    }
    public Temps(int h, int m, String classe, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        initialise(h, m, classe, borneSupHeure);
    }
    public Temps(String texte, String quoi, boolean borneSupHeure)
    throws ExceptionMauvaiseValeurPourHeure,
           ExceptionMauvaiseValeurPourMinute {
        StringTokenizer st = new StringTokenizer(texte, ":");
        int h, m;
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initialise(h, m, quoi, borneSupHeure);
    }
    public void uneMinuteDePlus() {
        if (minute < 59) {
            minute++;
        } else {
            minute = 0;
            uneHeureDePlus();
        }
    }
    public abstract void uneHeureDePlus();
    public void uneMinuteDeMoins() {
        if (minute > 0) {
            minute--;
        } else {
            minute = 59;
            uneHeureDeMoins();
        }
    }
    public abstract void uneHeureDeMoins();
    public String toString() {
        String s = "";
        if (heure < 10) s += "0";
        s += heure;
        s += "h";
        if (minute < 10) s += "0";
        s += minute;
        return s;
    }
    public int compareTo(Temps autreTemps) {
        if (heure == autreTemps.heure) {
            return minute - autreTemps.minute;
        } else
            return heure - autreTemps.heure;
    }
}
