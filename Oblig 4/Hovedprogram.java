//Dette er hovedprogrammet for Legesystemet.

public class Hovedprogram {
    public static void main(String[] args){
        Legesystem legesystem = new Legesystem();
        legesystem.lesInnFraFil("Innlesing.txt");
        legesystem.startHovedmeny();
    }
}
