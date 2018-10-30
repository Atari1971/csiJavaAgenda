package essai;

import temps.Heure;

class EssaiHeure {
    private EssaiHeure() { }
    public static void essayer() {
        Heure h = new Heure(22, 55);
        System.out.println(h);
        for(int i = 0; i < 100; i++) {
            h.uneMinuteDePlus();
            System.out.println(h);
        }
    }
}
