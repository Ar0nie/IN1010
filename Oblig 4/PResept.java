public class PResept extends HvitResept {

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }
    
    @Override
    public int prisAaBetale() {
        int pris = legemiddel.hentPris() - 108;
        if (pris < 0){
            return 0;
        }else{
            return pris;
        }
    }

    @Override
    public String toString() {
        return String.format("P-resept: %s \n(id: %d, lege: %s, pasient: %s, reit: %d, prisAaBetale: %d)", hentLegemiddel().hentNavn(), hentId(), hentLege().hentNavn(), hentPasient().hentNavn(), hentReit(), prisAaBetale());
    }

    @Override
    public String hentDataString() {
        return String.valueOf(legemiddel.hentId()) + "," + utskrivendeLege.hentNavn() + "," + pasient.hentId() + "," + "p" + "," + String.valueOf(reit);
    }
}
