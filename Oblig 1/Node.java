public class Node{

    // Utvalgte metoder og konstruktør for klassen Node. Enhetene består av minne, prosessorer og en verdi boolean gyldig som sjekker om...
    // verdiene for prosessor og minne er innenfor viss mengde.

    private int minne;
    private int prosessorer;
    private boolean gyldig = true;

    public Node(int m, int p){
        if (m <= 4096){
            this.minne = m;
        } else {
            gyldig = false;
        }
        if (p <= 16){
            this.prosessorer = p;
        } else{
            gyldig = false;
        }
    }

    // Return av minne.

    public int hentMinne(){
        return minne;
    }

    // Return av prosessorer.

    public int hentProsessorer(){
        return prosessorer;
    }

    // Return av verdien gyldig.

    public boolean gyldig(){
        return gyldig;
    }

}