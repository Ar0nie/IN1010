import java.util.Iterator;
import java.util.NoSuchElementException;

//Den abstrakte klassen Lenkeliste med implementasjon av interfacet Liste.

abstract class Lenkeliste<T> implements Liste<T> {

    class LenkelisteIterator implements Iterator<T> {
        Node peker = start;

        @Override
        public boolean hasNext(){
            if (peker != null){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {

            T data = peker.data;
            peker = peker.neste;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }

    //Den lokale klassen Node som benyttes i Lenkeliste og alle dets subklasser. Alle noder har en peker til neste Node og data av en uspesifisert type.

    class Node {
        
        protected Node neste;
        protected T data;
        
        public Node(T data){
            this.data = data;
        }

        public String toString(){
            return super.toString();
        }
    }

    //Lenkelister og deres subklasser har alle en referanse til den foerste Noden i lenkelisten: start, og den siste Noden i lenkelisten: slutt. Utenom dette har man en int antNoder.

    protected Node start;
    protected Node slutt;
    protected int antNoder;

    //Metoden leggTil for lenkeliste. Nye elementer tilordnes referanse for start eller slutt dersom det passer seg, alle ny elementer legges til bakerst i lenkelisten.

    public void leggTil(T x){
        Node nyNode = new Node(x);
        if (start == null){
            start = nyNode;
        } else {
            slutt.neste = nyNode;
        }
        slutt = nyNode;
        antNoder++;
    }

    //Metoden T hent(), som returnerer dataen til den foerste Noden i lenkelisten.
    
    public T hent(){
        return start.data;
    }

    //Metoden T fjern(). Dersom antNoder = 0, vil vi kalle paa UgyldigListeindeks(0) for aa gi riktig feilmelding.
    //Metoden vil fjerne det foerste elementet i listen og returnere noden som blir fjernet.

    public T fjern() throws UgyldigListeindeks{
        if (antNoder == 0){
            throw new UgyldigListeindeks(0);
        }
        
        T returData = start.data;

        if (antNoder == 1){
            slutt = null;
            start = null;
        } else {
            start = start.neste;
        }
        
        antNoder--;
        return returData;
        
    }
    
    //Metoden stoerrelse returnerer antallet noder i lenkelisten.

    public int stoerrelse(){
        return antNoder;
    }

    //En toString metode som forteller oss om hva slags data som er lagret i lenkelisten.

    public String toString(){
        String svarStreng = "";
        svarStreng += "Noder i lenkelisten: ";
        Node peker = start;
        for (int i = 0; i < antNoder; i++){
            svarStreng += "\n Lagret data: ";
            if (i > 0){
                peker = peker.neste;
            }
            svarStreng += peker.toString();
        }
        
        return svarStreng;
    }
}
