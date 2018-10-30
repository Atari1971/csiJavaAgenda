package temps;

public class ExceptionMauvaiseAnnee extends Exception {
    public ExceptionMauvaiseAnnee(int a) {
        super("Annee incorrecte (" + a + ") pour une date "
            + "(il faut un entier positif");
    }
}
