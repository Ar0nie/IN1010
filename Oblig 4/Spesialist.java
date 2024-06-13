public class Spesialist extends Lege implements Godkjenningsfritak {
    private String kontrollID;

    public Spesialist(String navn, String kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }

    @Override
    public String hentKontrollID() {
        return kontrollID;
    }

    @Override
    public String toString() {
        return "Lege (spesialist): " + hentNavn() + " (kontrollId: " + kontrollID + ")";
    }

    @Override
    BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        return resept;
    }

    @Override
    public String hentDataString() {
        return navn + "," + kontrollID;
    }
}
