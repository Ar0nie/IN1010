//Utvalgte metoder og konstruktør for Dataklynge.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Dataklynge inneholder den boolske verdien gyldig og ArrayList<Rack> racks hvor vi oppbevarer racks med tilhørende noder i dataklyngen.


public class Dataklynge {
    
    private boolean gyldig = true;
    private ArrayList<Rack> racks = new ArrayList<Rack>();

    //Konstruktøren tar imot filnavnet på en txt fil der man fordeler hver linje etter antNoder, prosessorer og minne. Deretter benytter man den private ...
    // .. metoden noderFraFil for å omgjøre informasjonen til objekter som lagres i ArrayList racks.

    public Dataklynge(String filNavn){
        Scanner fil = null;
        File filen = new File(filNavn);
        
        try {
            fil = new Scanner(filen);
        } catch (FileNotFoundException exception){
            System.out.println("Fant ikke filen.");
            System.exit(-1);
        }
        
        String linje = "";
        while (fil.hasNextLine() == true){
            linje = fil.nextLine();
            String[] biter = linje.split(" ");
            
            int antNoder = Integer.parseInt(biter[0]);
            int prosessorer = Integer.parseInt(biter[1]);
            int minne = Integer.parseInt(biter[2]);

            noderFraFil(antNoder, prosessorer, minne);
        }
        fil.close();
    }

    //noderFraFil basert på informasjon fra konstruktøren vil en løkke kjøre igjennom antallNoder ganger, der man kaller på metoden settInnNode og øker teller.

    private void noderFraFil(int antallNoder, int prosessorer, int minne){
        int teller = 0;

        while(teller < antallNoder){
            settInnNode(minne, prosessorer);
            teller++;
        }
    }

    //settInnNode gjennomgår ArrayList racks og dersom en rack ikke er full, vil man lage en Node og plassere den der det er ledig.
    //Dersom ingen racks har ledig plass oprettes en ny Rack og Node plasseres i det nye Rack objektet.

    public void settInnNode(int minne, int prosessorer){
        for (Rack rack : racks){
            if (rack.fullStatus() == false){
                rack.settInn(new Node(minne, prosessorer));
                return;
            }
        }
        Rack nyRack = new Rack();
        nyRack.settInn(new Node(minne, prosessorer));
        racks.add(nyRack);
    }

    //hentAntNoder benytter en for løkke for å gjennomgå rack i racks. Deretter nodene i rack, der vi benytter hentNoderListe metoden for å returnere tilhørende noder...
    //...i noderListe arrayet. For hver gjennomkjøring der plasser i arrayet i et rack ikke er verdien: null, økes en teller med 1. Deretter returneres verdien.

    public int hentAntNoder(){
        int teller = 0;

        for (Rack rack : racks){
            for (Node node : rack.hentNoderListe()){
                if (node != null){
                    teller++;
                }
            }
        }
        return teller;
    }

    //hentAntProsessorer liknende løsning som i hentAntNoder, for hver Node kaller man på metoden hentProsessorer, for så å legge de sammen for hver gjennomkjøring.

    public int hentAntProsessorer(){
       
        int antProsessorer = 0;
        
        for (Rack rack : racks){
          for (Node node : rack.hentNoderListe()){
              if (node != null){
                antProsessorer += node.hentProsessorer();
              }
            }
        }
        return antProsessorer;
    }

    //Enkel return av størrelsen på ArrayList racks.

    public int hentAntRacks(){
        return racks.size();
    }


    //hentNoderMedNokMinne liknende løsning som i forekommende metoder for prosessorer og hentAntNoder.
    //Ved sammenligning av minne der et node oppfyller kravet for paakrevdMinne øker verdien NoderMedNokMinne med 1. Deretter returneres verdien.

    public int hentNoderMedNokMinne(int paakrevdMinne){
        int noderMedNokMinne = 0;

        for(Rack rack : racks){
            for (Node node : rack.hentNoderListe()){
                if (node != null){
                    if(node.hentMinne() >= paakrevdMinne) {
                        noderMedNokMinne++;
                    }
                }
            }
        }
        return noderMedNokMinne;
    }  

    //gyldig Metode for å sjekke om noen av nodene og eller racks i dataklyngen har verdier som ikke er gyldige. Dette for å gi utslag i hovedprogram...
    // ... dersom man i txt dokumentet som benyttes har verdier for minne og prosessorer som ikke er innenfor gyldige verdier.

    public boolean gyldig(){
        for(Rack rack : racks){
            for (Node node : rack.hentNoderListe()){
                if(node != null && node.gyldig() == false){
                    gyldig = false;
                }
            }
        }
        return gyldig;
    }

}