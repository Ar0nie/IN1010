import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Denne klassen LegesystemInnleser haandterer filInnlesing for legesystemet.


public class LegesystemInnleser {
    private IndeksertListe<Legemiddel> legemiddeler = new IndeksertListe<>();
    private IndeksertListe<Resept> resepter = new IndeksertListe<>();
    private Prioritetskoe<Lege> leger = new Prioritetskoe<>();
    private IndeksertListe<Pasient> pasienter = new IndeksertListe<>();

    public void lesInnFraFil(String filNavn){
        Scanner fil = null;
        File filen = new File(filNavn);

        try {
            fil = new Scanner(filen);
        } catch (FileNotFoundException exception){
            System.out.println("Fant ikke filen.");
            System.exit(-1);
        }
        
        String objektType = "";
        while (fil.hasNextLine()) {
            String linje = fil.nextLine();
            
            if (linje.startsWith("#")) {
                if(linje.startsWith("# Pasienter")) {
                    objektType = "pasienter";
                } else if(linje.startsWith("# Legemidler")) {
                    objektType = "Legemidler";
                } else if (linje.startsWith("# Leger")) {
                    objektType = "Leger";
                } else if (linje.startsWith("# Resepter")) {
                    objektType = "Resepter";
                } else {
                    System.out.println("feil format: " + linje);
                }
            }
            else {
                if (objektType == "pasienter") {
                    lesInnPasient(linje);
                }
                else if (objektType == "Legemidler" ){
                    lesInnLegemiddel(linje);
                }
                else if (objektType == "Leger"){
                    lesInnLege(linje);
                }
                else if (objektType == "Resepter"){
                    lesInnResept(linje);
                }
            }
        }
    }

    
    private void lesInnPasient(String linje){
        String[] data = linje.strip().split(",");
        try {
            String navn = data[0];
            String foedselsnummer = data[1];
            Pasient pasient = new Pasient(navn, foedselsnummer);
            pasienter.leggTil(pasient.hentId()-1,pasient);
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Feil i linje: " + linje);
            return;
        }
    }

    
    private void lesInnLegemiddel(String linje){
        String[] data = linje.strip().split(",");
        Legemiddel nyttLegemiddel = null;
        try{
            if(data[1].equals("narkotisk")){
                int pris = Integer.parseInt(data[2]);
                double virkestoff = Double.parseDouble(data[3]);
                int styrke = Integer.parseInt(data[4]);
                nyttLegemiddel = new Narkotisk(data[0], pris, virkestoff, styrke);
                legemiddeler.leggTil(nyttLegemiddel.hentId()-1,nyttLegemiddel);
            }
            else if(data[1].equals("vanlig")){
                int pris = Integer.parseInt(data[2]);
                double virkestoff = Double.parseDouble(data[3]);
                nyttLegemiddel = new Vanlig(data[0], pris, virkestoff);
                legemiddeler.leggTil(nyttLegemiddel.hentId()-1,nyttLegemiddel);
            }
            else if(data[1].equals("vanedannende")){
                int pris = Integer.parseInt(data[2]);
                double virkestoff = Double.parseDouble(data[3]);
                int styrke = Integer.parseInt(data[4]);
                nyttLegemiddel = new Vanedannende(data[0], pris, virkestoff, styrke);
                legemiddeler.leggTil(nyttLegemiddel.hentId()-1,nyttLegemiddel);
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Feil i linje: " + linje);
            return;
        } 
    }

    private void lesInnLege(String linje){
        String[] data = linje.strip().split(",");
        try {
            if (data[1].equals("0")){
                Lege nyLege = new Lege(data[0]);
                leger.leggTil(nyLege);
            }
            else {
                Lege nyLege = new Spesialist(data[0], data[1]);
                leger.leggTil(nyLege);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Feil i linje: " + linje);
        }
    }

    private void lesInnResept(String linje){
        String[] data = linje.strip().split(",");
        try {
            Legemiddel legemiddel = legemiddeler.hent(Integer.valueOf(data[0])-1);
            Lege lege = null;
            for(Lege legen: leger){
                if(legen.hentNavn().compareTo(data[1]) == 0){
                    lege = legen;
                    break;
                }
            }

            Pasient pasient = pasienter.hent(Integer.valueOf(data[2])-1);

            if(data[3].equals("hvit")){
                int reit = Integer.parseInt(data[4]);
                Resept nyResept = lege.skrivHvitResept(legemiddel,pasient,reit);
                resepter.leggTil(nyResept);
            }
            else if (data[3].equals("militaer")){
                Resept nyResept = lege.skrivMilResept(legemiddel, pasient);
                resepter.leggTil(nyResept);
            }
            else if(data[3].equals("p")){
                int reit = Integer.parseInt(data[4]);
                Resept nyResept = lege.skrivPResept(legemiddel, pasient,reit);
                resepter.leggTil(nyResept);
            }
            else if(data[3].equals("blaa")){
                int reit = Integer.parseInt(data[4]);
                Resept nyResept = lege.skrivBlaaResept(legemiddel, pasient,reit);
                resepter.leggTil(nyResept);
            }
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Feil i linje: " + linje);
            return;

        } catch (UlovligUtskrift u){
            System.out.println("Ulovlig utskrift: " + linje);
            return;
        }
    }

    public IndeksertListe<Legemiddel> hentLegemiddeler() {
        return legemiddeler;
    }

    public Prioritetskoe<Lege> hentLeger() {
        return leger;
    }
    
    public IndeksertListe<Pasient> hentPasienter() {
        return pasienter;
    }

    public IndeksertListe<Resept> hentResepter() {
        return resepter;
    }
}
