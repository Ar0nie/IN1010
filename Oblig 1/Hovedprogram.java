import java.io.FileNotFoundException;


// Hovedprogram som fremstiller utvalgt informasjon om dataklynger og deres innhold.

public class Hovedprogram {

    public static void main(String[] args) throws FileNotFoundException{
        
        String filnavn;
        if (args.length < 1){
            filnavn = "dataklynge2.txt";
        } else {
            filnavn = args[0];
        }

        Dataklynge dataklynge = new Dataklynge(filnavn);

        // Benytter en metode gyldig for å sjekke om hvorvidt noen av nodene og eller racks i en dataklynge har verdier som ikke passer minne og prossessor mengde.

        if (dataklynge.gyldig() == true){
            System.out.println("Noder med minst 128 GB: " + dataklynge.hentNoderMedNokMinne(128));
            System.out.println("Noder med minst 512 GB: " + dataklynge.hentNoderMedNokMinne(512));
            System.out.println("Noder med minst 1024 GB: " + dataklynge.hentNoderMedNokMinne(1024));
            System.out.println("");
            System.out.println("Antall prosessorer: " + dataklynge.hentAntProsessorer());
            System.out.println("Antall rack: " + dataklynge.hentAntRacks());
        } else{
            System.out.println("Beklager men en eller flere av nodene i det utvalgte dokumentet har 'ugyldige' verdier.");
        }
    }
}
