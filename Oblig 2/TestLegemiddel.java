public class TestLegemiddel {
    

    public static void main(String[] args){

        //Opretter ulike instanser av subklassene til Legemiddel. 

        Vanlig ibuprofen = new Vanlig("Ibuprofen", 150, 14.0);
        Narkotisk heroin = new Narkotisk("Heroin", 40, 14.0, 50);
        Vanedannende morfin = new Vanedannende("Morfin", 200, 3.0, 12);


        //De ulike enhetstestene under er på formen boolean, og vil derfor gi utslag dersom noen av metodene ikke returnerer verdien true..
        //.. , dette er med unntak av test for toString, som er en enkel utskrift til terminalen.

        //Enhetstest for LegemiddelID metoden.

        if (testLegemiddelId(ibuprofen, 1) && testLegemiddelId(heroin, 2) && testLegemiddelId(morfin, 3)){
            System.out.println("Test for LegemiddelId fungerte!");
        } else {
            System.out.println("Testen for LegemiddelId slo feil!");
        }
        

        //Enhetstest for hentNavn metoden. 

        if (testHentNavn(ibuprofen, "Ibuprofen") && testHentNavn(heroin, "Heroin") && testHentNavn(morfin, "Morfin")){
            System.out.println("Metoden hentNavn fungerte!");
        } else {
            System.out.println("Metoden hentnavn fungerte ikke!");
        }

        //Enhetstest for hentPris metoden 

        if (testHentPris(ibuprofen, 150) && testHentPris(heroin, 40) && testHentPris(morfin, 200)){
        System.out.println("Metoden hentPris fungerte!");
        } else {
        System.out.println("Metoden hentPris fungerte ikke!");
        }

        //Enhetstest for settNyPris metoden

        if (testSettNyPris(ibuprofen, 160) && testSettNyPris(heroin, 50) && testSettNyPris(morfin, 220)){
            System.out.println("Metoden settNyPris fungerte!");
            } else {
            System.out.println("Metoden settNyPris fungerte ikke!");
            }


        //Enhetstest for hentVirkestoff metoden

        if (testHentVirkestoff(ibuprofen, 14.0) && testHentVirkestoff(heroin, 14.0) && testHentVirkestoff(morfin, 3.0)){
            System.out.println("Metoden settNyPris fungerte!");
            } else {
            System.out.println("Metoden settNyPris fungerte ikke!");
            }

        //Enhetstest for hentVanedannendeStyrke og hentNarkotiskStyrke

        if (testHentVanedannendeStyrke(morfin, 12) && testHentNarkotiskStyrke(heroin, 50)){
            System.out.println("Metodene hentVanedannendeStyrke og hentNarkotiskStyrke fungerte!");
            } else {
            System.out.println("Metodene hentVanedannendeStyrke og hentNarkotiskStyrke fungerte ikke!");
            }
        

        //Test av utskrift med toString metoden, for instansene av de ulike subklassene.
        
        System.out.println();
        System.out.println(ibuprofen);
        System.out.println(heroin);
        System.out.println(morfin);

    }
    
    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId){
        return legemiddel.hentId() == forventetLegemiddelId;
    }

    public static boolean testHentNavn(Legemiddel legemiddel, String forventetNavn){
        return legemiddel.hentNavn() == forventetNavn;
    }

    public static boolean testHentPris(Legemiddel legemiddel, int forventetPris){
        return legemiddel.hentPris() == forventetPris;
    }

    public static boolean testSettNyPris(Legemiddel legemiddel, int nyPris){
        legemiddel.settNyPris(nyPris);
        return legemiddel.hentPris() == nyPris;
    }

    public static boolean testHentVirkestoff(Legemiddel legemiddel, double forventetVirkestoff){
        return legemiddel.hentVirkestoff() == forventetVirkestoff;
    }

    public static boolean testHentNarkotiskStyrke(Narkotisk legemiddel, double forventetStyrke){
        return legemiddel.hentNarkotiskStyrke() == forventetStyrke;
    }
    
    public static boolean testHentVanedannendeStyrke(Vanedannende legemiddel, double forventetStyrke){
        return legemiddel.hentVanedannendeStyrke() == forventetStyrke;
    }
}