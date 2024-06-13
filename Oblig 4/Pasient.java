public class Pasient implements KanLagres{
    private static int pasientAntall = 0;
    private int id;
    private String navn;
    private String foedselsnummer;
    private Koe<Resept> resepter;

    public Pasient(String navn, String foedselsnummer) {
        this.id = ++this.pasientAntall;
        this.resepter = new Koe<>();
        this.navn = navn;
        this.foedselsnummer = foedselsnummer;
    }

    public void leggTilResept(Resept resept){
        resepter.leggTil(resept);
    }

    public String hentNavn(){
        return navn;
    }
    
    public int hentId(){
        return id;
    }

    public Iterable<Resept> hentResepter(){
        return resepter;
    }

    @Override
    public String toString(){
        return ("Id "+ id +" Navn " + navn + " Foedselsnr " + foedselsnummer);
    }

    @Override
    public String hentDataString() {
        return navn + "," + foedselsnummer;
    }
}
