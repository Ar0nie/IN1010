public class Koe<T> extends Lenkeliste<T> {
    
    //Subklassen Koe av den abstrakte superklassen Lenkeliste.


    //I leggTil metoden for Koe så vil vi legge til nye elementer bakerst. Denne Koe strukturen vil følge et FIFO prinsipp, altså First In First Out. 
    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        if (start == null){
            start = nyNode;
        } else {
            Node peker = start;
            while (peker.neste != null){
                peker = peker.neste;
            }
            peker.neste = nyNode;
            
        }
        antNoder++;
    }
}
