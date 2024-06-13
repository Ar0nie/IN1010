public class Vanedannende extends Legemiddel {
    private int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentVanedannendeStyrke(){
        return styrke;
    }

    @Override
    public String toString() {
        return String.format("Vanedannende legemiddel: %s (id: %d, pris: %d, virkestoff: %f, styrke: %d)", hentNavn(), hentId(), hentPris(), hentVirkestoff(), hentVanedannendeStyrke());
    }

    @Override
    public String hentDataString() {
        return navn + ",vanedannende," + Integer.toString(pris) + "," + Double.toString(virkestoff) + "," + Integer.toString(styrke);
    }
}
