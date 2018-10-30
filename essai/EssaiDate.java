package essai;

import temps.Date;

class EssaiDate {
    private EssaiDate() { }
    public static void essayer() {
        Date d1;
        d1 = new Date(1, 1, 2018);
        System.out.println(d1);
        for (int i = 1; i < 366; i++) {
            d1.passerAuLendemain();
            System.out.println(d1);
        }
        for (int i = 1; i < 366; i++) {
            d1.passerALaVeille();
            System.out.println(d1);
        }
    }
}
