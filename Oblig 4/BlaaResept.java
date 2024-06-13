public class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge() {
        return "blaa";
    }

    @Override
    public int prisAaBetale() {
        // 75% rabatt
        return (int)Math.round(legemiddel.hentPris() * 0.25d);
    }
    
    @Override
    public String toString() {
        return String.format("Blaa resept: %s \n(id: %d, lege: %s, pasient: %s, reit: %d, prisAaBetale: %d)", hentLegemiddel().hentNavn(), hentId(), hentLege().hentNavn(), hentPasient().hentNavn(), hentReit(), prisAaBetale());
    }

    @Override
    public String hentDataString() {
        return String.valueOf(legemiddel.hentId()) + "," + utskrivendeLege.hentNavn() + "," + pasient.hentId() + "," + "blaa" + "," + String.valueOf(reit);
    }
}
