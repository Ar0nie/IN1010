public class IndeksertTest {
    
    public static void main(String[] args){
        IndeksertListe<String> k = new IndeksertListe<>();
        k = new IndeksertListe<>();
    
    k.leggTil("A");
	k.leggTil("B");
	k.leggTil("C");
    k.fjern();
    k.sett(1, "D");
	

        System.out.println(k.hent(0));
        System.out.println(k.hent(1));
        System.out.println(k.hent(2));
       

        
   
    }
}

