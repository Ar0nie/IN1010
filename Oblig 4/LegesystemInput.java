import java.util.InputMismatchException;
import java.util.Scanner;

//Denne haandterer alt av innput fra brukeren som vi etterspoer i Legesystemet.

public class LegesystemInput {
    private Scanner input = new Scanner(System.in);

    // lukker scanner
    public void avslutt(){
        input.close();
    }

    /*
    Presenterer brukeren med en liste med valg og forkortelser,
    brukeren kan skrive inn forkortelsen for aa velge.

    returnerer stringen som brukeren velger
    */
    public String valgMeny(String ...test){
        Koe<String> forkortelser = new Koe<>();
        for (String valg : test) {
            int forkortelseLengde = 1;
            String forkortelse = "";
            do {
                forkortelse = valg.substring(0, forkortelseLengde);
                // sjekk om forkortelsen er brukt tidligere
                for (String annenForkortelse : forkortelser) {
                    if(annenForkortelse.toLowerCase().equals(forkortelse.toLowerCase())){
                        forkortelse = "";
                    }
                }
                forkortelseLengde++;
            } while (forkortelse.equals(""));
            forkortelser.leggTil(forkortelse);
            System.out.println(forkortelse + ": " + valg);
        }

        String valgt = hentString();

        int i = 0;
        for (String forkortelse : forkortelser) {
            if (valgt.toLowerCase().equals(forkortelse.toLowerCase())){
                return test[i];
            }
            i++;
        }
        System.out.println("Valge ditt (" + valgt + ") er ikke i listen, proev paa nytt...");
        return valgMeny(test);
    }

    public String hentString(){
        System.out.print("> ");
        String svar = input.nextLine().strip();
        if(svar.length() == 0){
            System.out.println("Teksten maa ha innhold, proev paa nytt :)");
            return hentString();
        }
        System.out.println();
        return svar;
    }
    
    
    public int hentInt(){
        System.out.print("> ");
        
        try {
            int svar = input.nextInt();
            input.nextLine();
            System.out.println();
            return svar;
        }
        catch(InputMismatchException e) {
            System.out.println("Feil datatype: Oppgi et heltall!");
            input.nextLine();
            return hentInt();
        }
    }

    public double hentDouble(){
        System.out.print("> ");

        try {
            double svar = input.nextDouble();
            input.nextLine();
            System.out.println();
            return svar;
        }
        catch(InputMismatchException e) {
            System.out.println("Feil datatype: Oppgi et flyttall!");
            input.nextLine();
            return hentDouble();
        }
    }

    public Pasient brukerValgPasient(Iterable<Pasient> liste){
        int i = 0;

        for(Pasient element: liste){
            i++;
            Integer.toString(i);
            System.out.println(i + ": " + element.hentDataString());
        }

        int valgtIndex = hentInt();

        Pasient valg = null;
        i = 0;
        for(Pasient element: liste){
            i++;
            if(i == valgtIndex){
                valg = element;
            }
        }
        if(valg == null){
            // bruker valgte noe annet, proev paa nytt
            System.out.println("Proev paa nytt");
            valg = brukerValgPasient(liste);
        }

        return valg;
    }

    public Lege brukerValgLege(Iterable<Lege> liste){
        int i = 0;

        for(Lege element: liste){
            i++;
            Integer.toString(i);
            System.out.println(i + ": " + element.hentDataString());
        }

        int valgtIndex = hentInt();

        Lege valg = null;
        i = 0;
        for(Lege element: liste){
            i++;
            if(i == valgtIndex){
                valg = element;
            }
        }
        if(valg == null){
            // bruker valgte noe annet, proev paa nytt
            System.out.println("Proev paa nytt");
            valg = brukerValgLege(liste);
        }

        return valg;
    }

    public Legemiddel brukerValgLegemiddel(Iterable<Legemiddel> liste){
        int i = 0;

        for(Legemiddel element: liste){
            i++;
            Integer.toString(i);
            System.out.println(i + ": " + element.hentDataString());
        }

        int valgtIndex = hentInt();

        Legemiddel valg = null;
        i = 0;
        for(Legemiddel element: liste){
            i++;
            if(i == valgtIndex){
                valg = element;
            }
        }
        if(valg == null){
            // bruker valgte noe annet, proev paa nytt
            System.out.println("Proev paa nytt");
            valg = brukerValgLegemiddel(liste);
        }

        return valg;
    }

    public Resept brukerValgResept(Iterable<Resept> resepter){
        int i = 0;

        for(Resept resept: resepter){
            i++;
            Integer.toString(i);
            System.out.println(i + ": " + resept.hentLegemiddel().hentNavn() + ", Reit: " + resept.hentReit() + ", Lege: " + resept.hentLege().hentNavn());
        }
        // hvis iterable er tom
        if(i == 0){
            return null;
        }
        
        int valgtIndex = hentInt();

        Resept valg = null;
        i = 0;
        for(Resept resept: resepter){
            i++;
            if(i == valgtIndex){
                valg = resept;
            }
        }
        if(valg == null){
            // bruker valgte noe annet, proev paa nytt
            System.out.println("Proev paa nytt");
            valg = brukerValgResept(resepter);
        }

        return valg;
    }
}
