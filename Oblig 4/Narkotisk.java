public class Narkotisk extends Legemiddel {
    private int styrke;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){
        return styrke;
    }

    @Override
    public String toString() {
        return String.format("Narkotisk legemiddel: %s (id: %d, pris: %d, virkestoff: %f, styrke: %d)", hentNavn(), hentId(), hentPris(), hentVirkestoff(), hentNarkotiskStyrke());
    }

    @Override
    public String hentDataString() {
        return navn + ",narkotisk," + Integer.toString(pris) + "," + Double.toString(virkestoff) + "," + Integer.toString(styrke);
    }
}
