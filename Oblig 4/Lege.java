public class Lege implements Comparable<Lege>, KanLagres {
    protected String navn;
    protected IndeksertListe<Resept> utskrevneResepter;

    public Lege(String navn) {
        this.navn = navn;
        this.utskrevneResepter = new IndeksertListe<>();
    }

    public String hentNavn(){
        return navn;
    }

    @Override
    public String toString() {
        return "Lege: " + navn;
    }

    @Override
    public int compareTo(Lege lege) {
        return this.navn.compareTo(lege.hentNavn());
    }

    public IndeksertListe<Resept> hentUtskrevneResepter(){
        return utskrevneResepter;
    }


    HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
    }

    MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        MilResept resept = new MilResept(legemiddel, this, pasient);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
    }

    PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        PResept resept = new PResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
    }

    BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        pasient.leggTilResept(resept);
        return resept;
    }

    @Override
    public String hentDataString() {
        return navn + ",0";
    }
}
