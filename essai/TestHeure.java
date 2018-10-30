package essai;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import temps.*;

/**
 * Classe-test TestHeure.
 *
 * @author  Samuel
 * @version 1.0
 */

public class TestHeure
{
    protected static Heure h1;
    protected static Heure h2;
    
    /** Met en place les engagements.
        * Méthode appelée avant chaque appel de méthode de test
    **/
     
     @BeforeClass
     public static void setUp() throws ExceptionMauvaiseValeurPourHeure,
     ExceptionMauvaiseValeurPourMinute {
        h1 = new Heure(14,57);
        h2 = new Heure("23:56");
    }
    
    @Test
    public void test1Constructeur() {
        assertEquals("14h57", h1.toString());
        assertEquals("23h56", h2.toString());
    }
    
    @Test(expected = ExceptionMauvaiseValeurPourMinute.class)
    public void test2Constructeur() throws ExceptionMauvaiseValeurPourHeure,
     ExceptionMauvaiseValeurPourMinute {
        new Heure(12,61);
    }
    
    @Test
    public void test3uneMinuteDePlus() {
        h1.uneMinuteDePlus();
        assertEquals("14h58", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("14h59", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("15h00", h1.toString());
        h1.uneMinuteDePlus();
        assertEquals("15h01", h1.toString());
    }
    
    @Test
    public void test4uneHeureDePlus() {
        h2.uneHeureDePlus();
        assertEquals("00h56", h2.toString());
        h1.uneHeureDePlus();
        assertEquals("15h57", h1.toString());
    }
}
    
   
