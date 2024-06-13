//UgyldigListeIndeks som kastes for ugyldige indekseringsverdier i de andre klassene.

public class UgyldigListeindeks extends RuntimeException {
    UgyldigListeindeks (int indeks){
        super("Ugyldig indeks: " + indeks);
    }
}
