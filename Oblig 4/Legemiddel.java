public abstract class Legemiddel implements KanLagres{
    private static int legemiddelAntall = 0;
    protected String navn;
    protected int pris;
    protected double virkestoff;
    private int id;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.id = ++this.legemiddelAntall;
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
    }

    public int hentId(){
        return id;
    }

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return virkestoff;
    }

    public void settNyPris(int nyPris){
        pris = nyPris;
    }
}