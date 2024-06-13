public class MilResept extends HvitResept {

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient, 3);
    }
    
    @Override
    public int prisAaBetale() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Mil resept: %s \n(id: %d, lege: %s, pasient: %s, reit: %d, prisAaBetale: %d)", hentLegemiddel().hentNavn(), hentId(), hentLege().hentNavn(),hentPasient().hentNavn(), hentReit(), prisAaBetale());
    }

    @Override
    public String hentDataString() {
        return String.valueOf(legemiddel.hentId()) + "," + utskrivendeLege.hentNavn() + "," + pasient.hentId() + "," + "militaer";
    }
}
