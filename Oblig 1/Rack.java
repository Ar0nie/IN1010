public class Rack {
    
    //Utvalgte metoder og konstruktør for Rack. 

    // Alle racks har samme maksNoder og en noderListe som definerer størrelsen på arrayen. Eller har vi boolske verdier for hvorvidt innholdet i arrayet..
    // .. er fullt, og en likende metode "gyldige" for å sjekke om noen av nodene som forsøkes å bli lagt inn i arrayet har for store verdier av minne og prossessorer.

    private int maksNoder = 12;
    private Node[] noderListe;
    private int antNoder = 0;
    private boolean full = false;
    private boolean gyldige = true;

    // Tilordner arrayet noderListe med størrelse maksNoder.

    public Rack(){
        this.noderListe = new Node[maksNoder];
    }
    
    // Metoden settInn plasserer node i arrayet noderListe og øker antNoder of hvert metodekall. Når arrayet når heltallsgrensen 12 vil objektet av Rack...
    // .. endre den boolske verdien full til true.
    
    public void settInn(Node node){
        if (full == false){
            noderListe[antNoder] = node;
            antNoder++;
        }
        if (antNoder == maksNoder){
            full = true;
        }
    }

    // hentNoderListe returnerer noderListe for senere bruk.

    public Node[] hentNoderListe(){
        return noderListe;
    }

    // fullStatus returnerer instansvariabelen full.

    public boolean fullStatus(){
        return full;
    }

    // hentAntNoder returnerer instansvariabelen antNoder.

    public int hentAntNoder(){
        return antNoder;
    }

    // hentAntProsessorer returner antallet prosessorer iblant objektene av Node klassen i noderListe arrayet.

    public int hentAntProsessorer(){
        int teller = 0;
        int antProsessorer = 0;

        while(noderListe[teller] != null){
            antProsessorer += noderListe[teller].hentProsessorer();
            teller++;
        }
        return antProsessorer;
    }

    // hentAntMinne returnerer minne iblant objektene av Node klassen i noderListe arrayet.

    public int hentAntMinne(){

        int teller = 0;
        int antMinne = 0;

        while (noderListe[teller] != null){
            antMinne += noderListe[teller].hentMinne();
            teller++;
        }
        return antMinne;
    }

    // gyldige returnerer hvorvidt en eller flere av nodene i noderListe arrayet har den boolske verdien gyldig = true eller false.


    public boolean gyldige(){
        int teller = 0;

        while (noderListe[teller] != null){
            if (noderListe[teller].gyldig()){
                gyldige = true;
            } else {
                gyldige = false;
            }
        }
        return gyldige;
    }
}
