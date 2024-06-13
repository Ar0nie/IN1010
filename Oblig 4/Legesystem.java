public class Legesystem {
    private IndeksertListe<Legemiddel> legemiddeler = new IndeksertListe<>();
    private IndeksertListe<Resept> resepter = new IndeksertListe<>();
    private Prioritetskoe<Lege> leger = new Prioritetskoe<>();
    private IndeksertListe<Pasient> pasienter = new IndeksertListe<>();

    private LegesystemInput input = new LegesystemInput();
    

    //Klassen Legesystem kaller paa filinnlesing fra klassen LegesystemInnleser. 
    //Klassen inneholder ogsaa det meste av brukergrensesnitt for hele systemet.
    
    public void lesInnFraFil(String filnavn){
        LegesystemInnleser innleser = new LegesystemInnleser();
        innleser.lesInnFraFil(filnavn);
        legemiddeler = innleser.hentLegemiddeler();
        resepter = innleser.hentResepter();
        leger = innleser.hentLeger();
        pasienter = innleser.hentPasienter();    
    }

    public void lagreTilFil(String filnavn){
        LegesystemLagrer.lagreTilFil(filnavn, pasienter, legemiddeler, leger, resepter);
    }

    public void startHovedmeny(){
        System.out.println("Velkommen til Legesystemet");
        
        while(true){
            System.out.println("Hovedmeny (tast inn bokstav(er))");
            String meny = input.valgMeny("Info", "Opprett", "Bruk resept", "Statistikk", "Lagre til fil", "Avslutt");

            if (meny.equals("Info")){
                infoMeny();
            }
            else if (meny.equals("Opprett")){
                opprettObjektMeny();
            }
            else if(meny.equals("Bruk resept")){
                brukReseptMeny();
            }
            else if (meny.equals("Statistikk")){
                statistikkMeny();
            }
            else if(meny.equals("Lagre til fil")){
                lagreMeny();
            }
            else if(meny.equals("Avslutt")){
                System.out.println();
                System.out.println("Takk for ditt besoek!");
                input.avslutt();
                return;
            }
        }
    }

    private void statistikkMeny(){
        System.out.println("Statistikk for elementer i Systemet");
        System.out.println();
        //teller antall resepter Vanedannende
        System.out.print("Antall utskrevne Resepter paa Vanedannende Legemiddler: ");
        int tellerVan = 0;
        for(Resept res : resepter){
            if (res.legemiddel instanceof Vanedannende){
                tellerVan++;
            }
        }
        System.out.println(tellerVan);
        //teller antall resepter narkotiske
        System.out.print("Antall utskrevne Resepter paa Narkotiske Legemiddler: ");
        int tellerNark = 0;
        for(Resept res : resepter){
            if (res.legemiddel instanceof Narkotisk){
                tellerNark++;
            }
        }
        System.out.println(tellerNark);
        System.out.println();
        //teller antall leger som har skrevet ut resepter, sorterer i alfabetisk rekkefoelge og antall narkRes
        System.out.println("Leger som har skrevet ut Resepter paa narkotiske midler");
        for (Lege lege : leger){
            int legeNark = 0;
            for(Resept res : lege.hentUtskrevneResepter()){
                if (res.legemiddel instanceof Narkotisk){
                legeNark++;
                }
            } 
            if(legeNark >0){
                System.out.print(lege);
                System.out.println(" Antall Narkotiske resepter " + legeNark);
            }
        }
        System.out.println();
        //pasienter med narkotisk legemiddel paa resept
        System.out.println("Pasienter med minst en gyldig respet paa Narkotiske legemiddler");
        for (Pasient pas : pasienter){
            int pasKnark = 0;
            for(Resept res : resepter){
                if (res.legemiddel instanceof Narkotisk){
                    if (res.hentPasient() == pas){
                        pasKnark++;
                    }
                }
            }
            if(pasKnark >0){
                System.out.print(pas);
                System.out.println(" Antall resepter med Narkotisk for pasient " + pasKnark);
            }
        }
        System.out.println();
    }

    private void infoMeny(){
        System.out.println("Hva vil du hente info om?");
        String valgt = input.valgMeny("Resept", "Lege", "Legemiddel", "Pasient", "Alle");
        
        if (valgt.equals("Resept")){
            skrivUtRes(resepter);
        }
        else if(valgt.equals("Lege")){
            skrivUtLege(leger);
        }
        else if(valgt.equals("Legemiddel")){
            skrivUtLegemiddel(legemiddeler);
        }
        else if(valgt.equals("Pasient")){
            skrivUtPas(pasienter);
        }
        else if(valgt.equals("Alle")){
            skrivUtAlle(pasienter, leger, legemiddeler, resepter);
        }
    }

    private void skrivUtRes(Iterable<Resept> resepter){
        System.out.println("Informasjon om Resepter");
        for(Resept resept: resepter){
            System.out.println(resept);
        }
        System.out.println();
    }
    
    private void skrivUtPas(Iterable<Pasient> pasienter){
        System.out.println("Informasjon om Pasienter");
        for(Pasient pasient: pasienter){
            System.out.println(pasient);
        }
        System.out.println();
    }

    private void skrivUtLege(Iterable<Lege> leger){
        System.out.println("Informasjon om Leger");
        for(Lege lege: leger){
            System.out.println(lege);
        }
        System.out.println();
    }

    private void skrivUtLegemiddel(Iterable<Legemiddel> legemiddeler){
        System.out.println("Informasjon om Legemidler");
        for(Legemiddel legemiddel: legemiddeler){
            System.out.println(legemiddel);
        }
        System.out.println();
    }

    private void skrivUtAlle(Iterable<Pasient> pasienter, Iterable<Lege> leger, Iterable<Legemiddel> legemiddeler, Iterable<Resept> resepter){
        System.out.println("Informasjon om alt i legesystemet");
        System.out.println();
        skrivUtPas(pasienter);
        
        skrivUtLege(leger);
        
        skrivUtLegemiddel(legemiddeler);
        
        skrivUtRes(resepter);
    }

    private void opprettObjektMeny(){
        System.out.println("Opprett objekt ");
        String valgtObjekt = input.valgMeny("Lege", "Legemiddel", "Pasient", "Resept");

        if (valgtObjekt.equals("Resept")){
            System.out.println("Hvilken lege vil du skrive ut resept paa?");

            Lege lege = input.brukerValgLege(leger);
            
            System.out.println("Hva slags type resept vil du lage?");
            String reseptType = input.valgMeny("Blaa", "Hvit", "Militaer", "P-resept");
    
            System.out.println("Velg et legemiddel ved aa taste inn tallet ved siden av den");
            Legemiddel legemiddel = input.brukerValgLegemiddel(legemiddeler);

            System.out.println("Velg en pasient ved aa taste inn ID: ");
            Pasient pasient = input.brukerValgPasient(pasienter);

            if(reseptType.equals("Blaa")){
                System.out.println("Skriv antall reit");
                int reit = input.hentInt();

                
                try {
                    Resept res = lege.skrivBlaaResept(legemiddel, pasient, reit);
                    resepter.leggTil(res);
                } catch (UlovligUtskrift e) {
                    System.out.println("Ulovlig utskrift, klarte ikke aa lage resept!");
                }
            } 
            else if(reseptType.equals("Hvit")){
                System.out.println("Skriv antall reit");
                int reit = input.hentInt();

                try {
                    Resept res = lege.skrivHvitResept(legemiddel, pasient, reit);
                    resepter.leggTil(res);
                } catch (UlovligUtskrift e) {
                    System.out.println("Ulovlig utskrift, klarte ikke aa lage resept!");
                }
            }
            else if(reseptType.equals("Militaer")){
                try {
                    Resept res = lege.skrivMilResept(legemiddel, pasient);
                    resepter.leggTil(res);
                } catch (UlovligUtskrift e) {
                    System.out.println("Ulovlig utskrift, klarte ikke aa lage resepet!");
                }
            }
            else if(reseptType.equals("P-resept")){
                System.out.println("Skriv antall reit");
                int reit = input.hentInt();

                try {
                    
                    Resept res = lege.skrivPResept(legemiddel, pasient, reit);
                    resepter.leggTil(res);
                } catch (Exception e) {
                    System.out.println("Ulovlig utskrift, klarte ikke aa lage resepet!");
                }
            }
        }
        else if(valgtObjekt.equals("Lege")){
            String kontrollId;
            Lege nyLege = null;
            System.out.println("Oppgi navn paa lege (paa formen Dr. +navn)");
            String navn = input.hentString();

            System.out.println("Er legen en spesialist?");
            String kommando = input.valgMeny("JA", "NEI");

            if (kommando.equals("JA")){
                System.out.println("Oppgi kontrollID");
                kontrollId = input.hentString();

                nyLege = new Spesialist(navn, kontrollId);
            } else if(kommando.equals("NEI")){
                nyLege = new Lege(navn);
            }
            leger.leggTil(nyLege);
        }
        else if(valgtObjekt.equals("Legemiddel")){
            String navn;
            int pris;
            double virkestoff;
            int styrke;
        
            System.out.println("Hva slags type legemiddel er dette");
            String kategori = input.valgMeny("Narkotisk", "Vanlig", "Vanedannende");

            Legemiddel nyttLegemiddel = null;
        
            System.out.println("Oppgi navn paa legemiddel: ");
            navn = input.hentString();

            System.out.println("Oppgi pris: ");
            pris = input.hentInt();

            System.out.println("Oppgi virkestoff paa desimalform: ");
            virkestoff = input.hentDouble();

            if(kategori.equals("Narkotisk")){
                System.out.println("Oppgi styrke i heltall: ");
                styrke = input.hentInt();
                nyttLegemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
            } 
            else if(kategori.equals("Vanlig")){
                nyttLegemiddel = new Vanlig(navn, pris, virkestoff);
            } 
            else if(kategori.equals("Vanedannende")){
                System.out.println("Oppgi styrke i heltall: ");
                styrke = input.hentInt();
                nyttLegemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
            }
            
            legemiddeler.leggTil(nyttLegemiddel);
            System.out.print("Lagt til legemiddel: ");
            System.out.println(nyttLegemiddel);
        }
        else if(valgtObjekt.equals("Pasient")){
            String navn;
            String foedselsnummer;

            System.out.println("Oppgi navn: ");
            navn = input.hentString();

            System.out.println("Oppgi foedselsnummer: ");
            foedselsnummer = input.hentString();

            if(foedselsnummer.length() != 11){
                System.out.println("Feil lengde paa foedselsnummer");
                System.out.println("Sendes tilbake til alternativer");
                return;
            } else {
                pasienter.leggTil(new Pasient(navn, foedselsnummer));
                System.out.println("Pasient lagt til");
            }
        }
        System.out.println();
    }
    
    private void brukReseptMeny(){
        System.out.println("Hvem vil du se resepter for?");
        Pasient pasient = input.brukerValgPasient(pasienter);
        
        System.out.println("Resepter for " + pasient.hentNavn());
        int antallResepter = 0;
        for (Resept resept : pasient.hentResepter()){
            antallResepter++;
            System.out.println("Id " + resept.hentId()+ " Navn " + resept.hentLegemiddel().hentNavn() + " Reit " + resept.hentReit());
        }

        if (antallResepter == 0){
            System.out.println("Personen har ingen resepter");
        }
        else{
            System.out.println("Hvilken resept vil du bruke?");
            Resept resept = input.brukerValgResept(pasient.hentResepter());
            
            if (resept.bruk()){
                System.out.println("Brukte resept paa "+ resept.legemiddel.hentNavn() + " antall gjennvaeernde reit " + resept.hentReit() );
            }
            else{
                System.out.println("Kunne ikke bruke " + resept.legemiddel.hentNavn() + " ingen gjennvaerende Reit");
            }
        }
    }

    private void lagreMeny() {
        System.out.println("Oppgi navn til fil paa formen (filnavn.txt)");
        String filnavn = input.hentString();
        this.lagreTilFil(filnavn);
    }
}
