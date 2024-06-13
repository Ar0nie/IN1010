public class Vanlig extends Legemiddel {

    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }

    @Override
    public String toString() {
        return String.format("Vanlig legemiddel: %s (id: %d, pris: %d, virkestoff: %f)", hentNavn(), hentId(), hentPris(), hentVirkestoff());
    }

    @Override
    public String hentDataString() {
        return navn + ",vanlig," + Integer.toString(pris) + "," + Double.toString(virkestoff);
    }
}