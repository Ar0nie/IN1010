//interfacet Liste med et spesifisert uvalg metoder.

interface Liste <T> {
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}