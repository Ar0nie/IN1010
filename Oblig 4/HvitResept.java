public class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge() {
        return "hvit";
    }

    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }

    @Override
    public String toString() {
        return String.format("Hvit resept: %s \n(id: %d, lege: %s, pasient: %s, reit: %d, prisAaBetale: %d)", hentLegemiddel().hentNavn(), hentId(), hentLege().hentNavn(), hentPasient().hentNavn(), hentReit(), prisAaBetale());
    }

    @Override
    public String hentDataString() {
        return String.valueOf(legemiddel.hentId()) + "," + utskrivendeLege.hentNavn() + "," + pasient.hentId() + "," + "hvit" + "," + String.valueOf(reit);
    }
}
