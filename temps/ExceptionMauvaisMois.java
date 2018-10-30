package temps;

public class ExceptionMauvaisMois extends Exception {
    public ExceptionMauvaisMois(int m) {
        super("Mois incorrect (" + m + ") pour une date "
            + "(il faut un entier entre 1 et 12");
    }
}
