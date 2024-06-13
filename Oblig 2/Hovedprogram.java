public class Hovedprogram {
    
    public static void main(String[] args){
        
        //I hovedprogram opretter vi èn instans av hver klasse.
        //Først oprettes instanser av Legemidler

        Vanlig vanlig = new Vanlig("Vanlig", 150, 3.0);
        Narkotisk narkotisk = new Narkotisk("Narkotisk", 200, 4.0, 5);
        Vanedannende vanedannende = new Vanedannende("Vanedannende", 250, 4.5, 3);

        //Instanser av Lege og Spesialist
        Lege lege = new Lege("Lege1");
        Spesialist spesialist = new Spesialist("Spesialist1", "id452");

        //Instanser av ulike resepter.

        Blaa blaa = new Blaa(vanlig, lege, 10103, 4);
        Hvit hvit = new Hvit(narkotisk, lege, 10430,5);
        MilResept milResept = new MilResept(vanedannende, spesialist, 10100);
        PrevensjonResept prevResept = new PrevensjonResept(vanlig, lege, 104030, 5);

        //Utskrift med informasjon av de ulike legemidlene.

        System.out.println(vanlig);
        System.out.println(narkotisk);
        System.out.println(vanedannende);
        System.out.println();

        //Utskrift om instanser av Lege og spesialist.
        System.out.println(lege);
        System.out.println();
        System.out.println(spesialist);
        System.out.println();

        //Utskrift av ulike resepter.

        System.out.println(blaa);
        System.out.println();
        System.out.println(hvit);
        System.out.println();
        System.out.println(milResept);
        System.out.println();
        System.out.println(prevResept);
        
    }
}
