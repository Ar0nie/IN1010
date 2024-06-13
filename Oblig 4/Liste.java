//interfacet Liste med et spesifisert uvalg metoder.
//testkommentar for git

interface Liste <T> extends Iterable<T> {
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}