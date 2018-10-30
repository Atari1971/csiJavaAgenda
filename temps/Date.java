package temps;

import java.util.StringTokenizer;
import java.lang.Integer;
import java.lang.Comparable;

// un commentaire qui finit à la fin de la ligne
/* Un commentaire
   sur plusieurs lignes */

/** Date représente un jour de l'année
    * @version 3
    * @author Samuel PLANCHOT
**/

public class Date implements Comparable<Date> {
    private int jour;
    private int mois; /* un commentaire */
    private int annee;
    /** Donne des valeurs aux variables d'instance de l'objet 'date'
        *
        * @param j = un entier qui détermine le jour du mois 
        * @param m = un entier qui détermine le mois dans l'année
        * @param a = un entier qui détermine l'année
        * 
        * @exception ExceptionMauvaisJour exception indiquant si le jour est incorrect (<=0 ou >31)
        * @exception ExceptionMauvaisMois exception indiquant si le mois est incorrect (en dehors de 1-12)
        * @exception ExceptionMauvaiseAnnee exception indiquant si l'année est incorrecte
    **/
    private void initialise(int j, int m, int a)
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        if (m < 1 || m > 12) throw new ExceptionMauvaisMois(m); else mois = m;
        if (a < 1) throw new ExceptionMauvaiseAnnee(a); else annee = a;
        int jmax = nombreDeJoursDuMois(m, a);
        if (j < 1 || j > jmax) {
            String msg;
            msg = "Jour incorrect (" + j + ") pour une date ";
            msg += "(il faut un entier entre 1 et " + jmax + " pour ";
            if (jmax == 30 || jmax == 31)
                msg += "un mois de " + nomDuMois(m) + ")";
            else
                msg += "le mois de " + nomDuMois(m) + " " + a + ")";
            throw new ExceptionMauvaisJour(msg);
        } else
            jour = j;
    }
    
    /** Construit une date en donnant des valeurs aux variables d'instance de l'objet 'date'
        *
        * @param j = un entier qui détermine le jour du mois<br/>
        * @param m = un entier qui détermine le mois dans l'année<br/>
        * @param a = un entier qui détermine l'année<br/>
        * 
        * @exception ExceptionMauvaisJour exception indiquant si le jour est incorrect (<=0 ou >31)
        * @exception ExceptionMauvaisMois exception indiquant si le mois est incorrect (en dehors de 1-12)
        * @exception ExceptionMauvaiseAnnee exception indiquant si l'année est incorrecte
    **/
    public Date(int j, int m, int a)
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        initialise(j, m, a);
    }

    /** Convertit la date en un texte notant cette date
        *
        * @return une chaine de caractère au format jj/mm/aaaa
    **/
    
    public Date(String texte)
    throws ExceptionMauvaisJour, ExceptionMauvaisMois, ExceptionMauvaiseAnnee {
        StringTokenizer st = new StringTokenizer(texte, "/");
        int j, m, a;
        j = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        initialise(j, m, a);
    }
    
    /** Convertit la date en un texte notant cette date
        *
        * @return une chaine de caractère au format jj/mm/aaaa
    **/
    public String toString() {
        String s = "";
        s = s + jour;
        s += '/';
        if (mois < 10) s += '0';
        s += mois;
        s += '/';
        s += annee;
        return s;
    }
    
    /** Détermine si une année compte 366 jours au lieu de 365
        *
        * @param a un entier précisant l'année à laquelle on s'intéresse
        * 
        * @return Vrai si l'année est bissextile, faux dans le cas contraire
        * 
        * @since 1.0
    **/
    public static boolean bissextile(int a) {
        if (a % 400 == 0) return true;
        if (a % 4 == 0 && a % 100 != 0) return true;
        return false;
    }
    
    
    /** Détermine le nombre de jours de l'année
        *
        * @param m un entier qui précise le mois dans l'année
        * @param a un entier qui précise l'année
        * 
        * @return la longueur du mois m de l'année a
        * 
    **/
    
    private static int nombreDeJoursDuMois(int m, int a) {
        switch(m) {
            case 1  :
            case 3  :
            case 5  :
            case 7  :
            case 8  :
            case 10 :
            case 12 :
                return 31;
            case 2 :
                return (bissextile(a)) ? 29 : 28;    
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                return 30;
            default :
                return 0;
        }
    }
    
        
    /** Renvoie le nom du mois à partir de son numéro
        *
        * @param m un entier qui précise le mois auquel on s'interesse
        *          
        * @return une chaîne de caractères qui est le nom du mois en français
        * 
    **/
    public static String nomDuMois(int m) {
        switch (m) {
            case  1: return "janvier";
            case  2: return "février";
            case  3: return "mars";
            case  4: return "avril";
            case  5: return "mai";
            case  6: return "juin";
            case  7: return "juillet";
            case  8: return "août";
            case  9: return "septembre";
            case 10: return "octobre";
            case 11: return "novembre";
            case 12: return "décembre";
            default: return "inexistant";
        }
    }
    
    /** Remplace les valeurs de la date pour en faire son lendemain **/
    public void passerAuLendemain() {
        if (jour < nombreDeJoursDuMois(mois, annee)) {
            jour ++;
        } else {
            jour = 1;
            if (mois < 12) {
                mois ++;
            } else {
                mois = 1;
                annee ++;
            }
        }
    }

/** Remplace les valeurs de la date pour en faire sa veille **/
    public void passerALaVeille() {
        if (jour > 1) {
            jour --;
        } else {  
            if (mois >1) {
                mois --;
            } else {
                mois = 12;
                annee --;
            }
            jour = nombreDeJoursDuMois(mois, annee);
        }
    }

/** Compare la date considérée à une autre date
    * @param autreDate une instance de la classe Date à comparer
    * @return un entier nul si les deux dates sont égales,<br/>
    * un entier <i>positif</i> si la date considérée est postérieure à autreDate<br/>
    * un entier <i>négatif</i> si la date considérée est antérieure à autreDate<br/>
    * 
    * @see java.lang.comparable
**/
    public int compareTo(Date autreDate) {
        if (annee == autreDate.annee) {
            if (mois == autreDate.mois) {
                return jour - autreDate.jour;
            } else
                return mois - autreDate.mois;
        } else
            return annee - autreDate.annee;
    }
}