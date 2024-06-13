public class Stabel<T> extends Lenkeliste<T> {
    
    //Subklassen Stabel av den abstrakte superklassen Lenkeliste.

    //Det eneste vi endrer paa for stabel klassen er leggTil metoden.

    //Nye elementer blir lagt til foerst i listen.

    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        if (antNoder == 0){
            start = nyNode;
            slutt = nyNode;
        } else {
            nyNode.neste = start;
            start = nyNode;
        }
        antNoder ++;
    }
}
