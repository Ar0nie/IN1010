public class TestResept {
    
    public static void main(String[] args){
        
        //Instanser av ulike Legemidler for bruk i testing av subklassnee til Resept.

        Vanlig ibuprofen = new Vanlig("Ibuprofen", 150, 14.0);
        Narkotisk metadon = new Narkotisk("Metadon", 40, 14.0, 50);
        Vanedannende morfin = new Vanedannende("Morfin", 200, 3.0, 12);

        //Instanser av Lege og Spesialist for bruk i testing av subklassene til Resept.

        Lege lege = new Lege("Lege");
        Spesialist spesialist = new Spesialist("Spesialist", "123");

        //Instanser av de ulike subklassene av den abstrakte superklassen Resept.

        Hvit hvit = new Hvit(ibuprofen, lege, 1, 3);
        Blaa blaa = new Blaa(metadon, spesialist, 2, 4);
        MilResept milResept = new MilResept(morfin, spesialist, 3);
        PrevensjonResept pResept = new PrevensjonResept(ibuprofen, spesialist, 4, 4);

        //I likhet med TestLegemiddel, de ulike enhetstestene under er på formen boolean, og vil derfor gi utslag dersom noen av metodene ikke returnerer verdien true..
        //.. Dette er med unntak av testen for toString, som er en enkel utskrift til terminalen.

        //Enhetstesting for instansene med metoden hentID.

        if (testHentId(hvit, 1) && testHentId(blaa, 2) && testHentId(milResept, 3) && testHentId(pResept, 4)){
            System.out.println("Metoden hentId fungerte!");
        } else {
            System.out.println("Metoden hentId fungerte ikke!");
        }


        //testHentLegemiddel

        if (testHentLegemiddel(hvit, ibuprofen) && testHentLegemiddel(blaa, metadon) && testHentLegemiddel(milResept, morfin) && testHentLegemiddel(pResept, ibuprofen)){
            System.out.println("Metoden hentLegemiddel fungerte!");
        } else {
            System.out.println("Metoden hentLegemiddel fungerte ikke!");
        }

        //testHentLege

        if (testHentLege(hvit, lege) && testHentLege(blaa, spesialist) && testHentLege(milResept, spesialist) && testHentLege(pResept, spesialist)){
            System.out.println("Metoden hentLege fungerte!");
        } else {
            System.out.println("Metoden hentLege fungerte ikke!");
        }


        //testHentPasientId

        if (testHentPasientId(hvit, 1) && testHentPasientId(blaa, 2) && testHentPasientId(milResept, 3) && testHentPasientId(pResept, 4)){
            System.out.println("Metoden hentPasientId fungerte!");
        } else {
            System.out.println("Metoden hentPasientId fungerte ikke!");
        }


        //testHentReit

        if (testHentReit(hvit, 3) && testHentReit(blaa, 4) && testHentReit(milResept, 3) && testHentReit(pResept, 4)){
            System.out.println("Metoden hentReit fungerte!");
        } else {
            System.out.println("Metoden hentReit fungerte ikke!");
        }


        //testBruk

        if (testBruk(hvit) && testBruk(blaa) && testBruk(milResept) && testBruk(pResept)){
            System.out.println("Metoden bruk fungerte!");
        } else {
            System.out.println("Metoden bruk fungerte ikke!");
        }


        //testFarge

        if (testFarge(hvit, "Hvit") && testFarge(blaa, "Blaa") && testFarge(milResept, "Hvit") && testFarge(pResept, "Hvit")){
            System.out.println("Metoden farge fungerte!");
        } else {
            System.out.println("Metoden farge fungerte ikke!");
        }


        //testPrisAaBetale

        if (testPrisAaBetale(hvit, 204) && testPrisAaBetale(blaa, 300) && testPrisAaBetale(milResept, 200) && testPrisAaBetale(pResept, 200)){
            System.out.println("Metoden prisAaBetale fungerte!");
        } else {
            System.out.println("Metoden prisAaBetale fungerte ikke!");
        }


        //De ulike metodene benyttet for å teste hver instans av subklassene til Respet ser man nedenfor.

    }
    public static boolean testHentId(Resept resept, int forventetReseptId){
        return resept.hentId() == forventetReseptId;
    }
    
    public static boolean testHentLegemiddel(Resept respet, Legemiddel forventetLegemiddel){
        return respet.hentLegemiddel() == forventetLegemiddel;
    }

    public static boolean testHentLege(Resept resept, Lege forventetLege){
        return resept.hentLege() == forventetLege;
    }

    public static boolean testHentPasientId(Resept resept, int forventetPasientId){
        return resept.hentPasientId() == forventetPasientId;
    }

    public static boolean testHentReit(Resept respet, int forventetReit){
        return respet.hentReit() == forventetReit;
    }

    public static boolean testBruk(Resept resept){
        return resept.bruk();
    }

    public static boolean testFarge(Resept resept, String forventetFarge){
        return resept.farge() == forventetFarge;
    }
    
    public static boolean testPrisAaBetale(Resept resept, int pris){
        if (resept instanceof PrevensjonResept){
            return resept.prisAaBetale(pris) == (pris - 108) || resept.prisAaBetale(pris) == 0;
        }
        else if(resept instanceof MilResept){
            return resept.prisAaBetale(pris) == 0;
        }
        else if(resept instanceof Blaa){
            return resept.prisAaBetale(pris) == ((int)(pris*0.25));
        }
        else if(resept instanceof Hvit){
            return resept.prisAaBetale(pris) == pris; 
        }
        else{
            return false;
        }
    }


}
