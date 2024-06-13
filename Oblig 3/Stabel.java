public class Stabel<T> extends Lenkeliste<T> {
    
    //Subklassen Stabel av den abstrakte superklassen Lenkeliste.

    //Det eneste vi endrer på for stabel klassen er leggTil metoden.

    //Nye elementer blir lagt til først i listen.

    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        if (antNoder == 0){
            start = nyNode;
        } else {
            Node peker = start;
            start = nyNode;
            start.neste = peker;
        }
        antNoder ++;
    }
}
